#!/usr/bin/python
# -*- coding: UTF-8 -*-
"""Lista de controladores del programa.

En este fichero podemos encontrarnos todos los controladores,
de todas las vistas de nuestro programa.
"""

from src.controller.Controller import Controller, Path
from src.model.Models import *
from src.controller.Controllers import *
from src.view_app.Views import *

class EjerciciosTema1Controller(Controller):
    """Gestión de eventos para la ventana de los ejercicios del tema 1
    Con esta controlaremos cada uno de los codigos que tenemos en las
    diapositivas del tema 1
    """
    def back(self, event):
        model = MainModel()
        controller = MainController(self._window, model)
        view = MainView(self._window, controller)
        view.init_view()

    def pag8(self, event):
        """El ejercicio que hay para mostrar y reproducir un fichero wav

        Ponemos un archivo por defecto pero si ese archivo no esta
        se abre una ventana en la que se solicita un fichero"""
        filename = "/home/usuario/nextCloud/Facultad/03_Procesamiento_Digital_de_Señales_PDS_5to/Ejemplos_Python/This_is_a_test.wav"
        if not filename:
            filename = filediag.askopenfilename(initialdir='$USER',
                                                  title="Selecciona el fichero a estudiar",
                                                  filetypes=(("Sound files", "*.wav"),
                                                             ("all files", "*.*"))
                                                  )
        filename = Path(filename)
        if filename.suffix == '.wav':
            self._model.reproducir(str(filename))
            plt, x, framerate = self._model.leer_wave(str(filename))
            plt, Pxx, freqs = self._model.representa_espectrograma(x, 256, framerate, 128)
            plt.show()
        if not filename.exists():
            msgbox.showerror("Open file", "Cannot open this file\n(%s)" % str(filename))
            return

    def pag13(self, event):
        """El ejercicio que hay para mejorar el contraste de las imagenes

        la imagen de ejemplo es una datasheet de la luna"""
        # configuración especifica para matplotlib
        matplotlib.rcParams['font.size'] = 8
        # datos de imagen
        img = data.moon()
        # Para realzar el contrastre
        p2, p98 = numpy.percentile(img, (2, 98))
        img_rescale = exposure.rescale_intensity(img, in_range=(p2, p98))
        # Ecualización
        img_eq = exposure.equalize_hist(img)
        # Ecualización Adaptativa
        img_adapteq = exposure.equalize_adapthist(img, clip_limit=0.03)
        # Resultados
        fig = plt.figure(figsize=(9, 6))
        axes = numpy.zeros((2, 4), dtype=numpy.object)
        axes[0, 0] = fig.add_subplot(2, 4, 1)
        for i in range(1, 4):
            axes[0, i] = fig.add_subplot(2, 4, 1 + i, sharex=axes[0, 0], sharey=axes[0, 0])
        for i in range(0, 4):
            axes[1, i] = fig.add_subplot(2, 4, 5 + i)

        ax_img, ax_hist, ax_cdf = self._model.plot_img_and_hist(img, axes[:, 0])
        ax_img.set_title('Imagen de bajo contraste')

        y_min, y_max = ax_hist.get_ylim()
        ax_hist.set_ylabel('Número de pixels')
        ax_hist.set_yticks(numpy.linspace(0, y_max, 5))

        ax_img, ax_hist, ax_cdf = self._model.plot_img_and_hist(img_rescale, axes[:, 1])
        ax_img.set_title('Realce de contraste')

        ax_img, ax_hist, ax_cdf = self._model.plot_img_and_hist(img_eq, axes[:, 2])
        ax_img.set_title('Ecualización de histograma')

        ax_img, ax_hist, ax_cdf = self._model.plot_img_and_hist(img_adapteq, axes[:, 3])
        ax_img.set_title('Ecualización adaptativa')

        ax_cdf.set_ylabel('Fracción de la intensidad total')
        ax_cdf.set_yticks(numpy.linspace(0, 1, 5))

        # Prevenir la sobre-exposición de las etiquetas del eje y
        fig.subplots_adjust(wspace=0.4)
        plt.show()

    def pag15(self, event):
        """Ejemplo de funciones de la pagina 15 del tema 1 de PDS de UGR

        Este ejemplo se usa para mostrar una libreria que tabaja
        con una base de datos de bioseñales"""
        # se ha cambiado la siguiente linea de codigo por la siguiente por que la api ha avanzado
        # sig, fields = wfdb.rdsamp('/home/usuario/nextCloud/Facultad/03_Procesamiento_Digital_de_Señales_PDS_5to/Ejemplos_Python/b001')
        record = wfdb.rdrecord('/home/usuario/nextCloud/Facultad/03_Procesamiento_Digital_de_Señales_PDS_5to/Ejemplos_Python/b001', sampto=30000)
        wfdb.plot_wfdb(record, figsize=(10,7), title='Registro b001 de la base de datos Physionet CEBS')

    def pag18(self, event):
        """El ejercicio que hay para mejorar el contraste de las imagenes

        Ponemos un archivo por defecto pero si ese archivo no esta
        se abre una ventana en la que se solicita un fichero"""
        filename = "/home/usuario/nextCloud/Facultad/03_Procesamiento_Digital_de_Señales_PDS_5to/Ejercicios/01_Ejercicio_opcional_1/21_training.tif"
        # filename = ""
        # configuración especifica para matplotlib
        matplotlib.rcParams['font.size'] = 8
        if not filename:
            filename = filediag.askopenfilename(initialdir='$USER',
                                                       title="Selecciona el fichero a estudiar",
                                                       filetypes=(("JPG Files", "*.jpg"),
                                                                  ("GIF Files", "*.gif"),
                                                                  ("TIFF Files", "*.tif"))
                                                       )
        filename = Path(filename)
        if filename.exists() and filename.suffix == '.tif':
            # msgbox.showinfo("Acceso a fichero", "Tenemos este fichero para trabajar con el\n(%s)" % str(filename))
            # datos de imagen
            img = data.load(filename)
            # Para realzar el contrastre
            p0, p80 = numpy.percentile(img, (0, 80))
            img_rescale = exposure.rescale_intensity(img, in_range=(p0, p80))
            # Conversión en blanco y negro
            img_bw = color.rgb2grey(img_rescale)
            # Calculo de la mascara de umbralización
            mask_img = filters.threshold_li(img_bw)
            # Umbralización de la imagen
            img_umbra = img_bw > mask_img
            # Imagen final de venas
            img_venas = gradient(img_bw, disk(5))
            # Resultados
            fig = plt.figure(figsize=(12, 6))
            axes = numpy.zeros((2, 5), dtype=numpy.object)
            axes[0, 0] = fig.add_subplot(2, 5, 1)
            for i in range(1, 5):
                axes[0, i] = fig.add_subplot(2, 5, 1 + i, sharex=axes[0, 0], sharey=axes[0, 0])
            for i in range(0, 5):
                axes[1, i] = fig.add_subplot(2, 5, 6 + i)
            # ------------------------------------------------------------------------
            ax_img, ax_hist, ax_cdf = self._model.plot_img_and_hist(img, axes[:, 0])
            ax_img.set_title('Imagen Original')

            y_min, y_max = ax_hist.get_ylim()
            ax_hist.set_ylabel('Número de pixels')
            ax_hist.set_yticks(numpy.linspace(0, y_max, 5))

            ax_img, ax_hist, ax_cdf = self._model.plot_img_and_hist(img_rescale, axes[:, 1])
            ax_img.set_title('Realzado de la imagen')

            ax_img, ax_hist, ax_cdf = self._model.plot_img_and_hist(img_bw, axes[:, 2])
            ax_img.set_title('Imagen blanco y negro')

            ax_img, ax_hist, ax_cdf = self._model.plot_img_and_hist(img_umbra, axes[:, 3])
            ax_img.set_title('Umbralización de Imagen')

            ax_img, ax_hist, ax_cdf = self._model.plot_img_and_hist(img_venas, axes[:, 4])
            ax_img.set_title('Imagen de Venas')

            ax_cdf.set_ylabel('Fracción de la intensidad total')
            ax_cdf.set_yticks(numpy.linspace(0, 1, 5))
            # ------------------------------------------------------------------------
            plt.show()
        else:
            msgbox.showerror("Open file", "Cannot open this file\n(%s)" % str(filename))
            return

    def pag56(self, event):
        """Ejercicio de la pagina 54 que se encarga de calcular la SQNR de un sonido

        Ponemos un archivo por defecto pero si ese archivo no esta
        se abre una ventana en la que se solicita un fichero"""
        filename = "/home/usuario/nextCloud/Facultad/03_Procesamiento_Digital_de_Señales_PDS_5to/Ejercicios/04_Python_SQNR_tema1_trans54/OSR_us_000_0010_8k.wav"
        if not filename:
            filename = filediag.askopenfilename(initialdir='$USER',
                                                title="Selecciona el fichero a estudiar",
                                                filetypes=(("Sound files", "*.wav"),
                                                           ("all files", "*.*"))
                                                )
        filename = Path(filename)
        if filename.suffix == '.wav':
            # leemos el fichero
            plt, x, framerate = self._model.leer_wave(str(filename))
            # calculamos y mostramos el espectograma
            plt, Pxx, freqs = self._model.representa_espectrograma(x, 256, framerate, 128)
            # calculamos el tiempo del fichero
            t = numpy.arange(start=0, stop=1.0 * x.size/framerate, step=1./framerate)
            plt.figure(2)
            plt.plot(t, x)
            plt.xlabel('t (s)')
            x = x / 2.0**15
            # array con los valores de la SQNR para diferentes valores de Bits
            ASQNR = []
            # Cuantización de 8, 7, 6, 5, 4 y 3 bits
            for bits in range(3, 9):
                output, q = self._model.quantization(x, 2**bits)
                error = x - output
                # Añadimos cada valor de SQNR al array
                ASQNR.append(10 * numpy.log10(numpy.var(x) / numpy.var(error)))
                plt.figure(bits)
                plt.title('Cuantización %s bits' % str(bits))
                plt.ylabel('Amplitud')
                plt.xlabel('t (s)')
                plt.plot(t, x, t, error)
            plt.figure(10)
            plt.plot(range(3, 9), ASQNR, 'bo-')
            plt.xlabel('Bits')
            plt.ylabel('SQNR(dB)')
            plt.grid()
            plt.show()
            # reproducimos el fichero
            #self._model.reproducir(str(filename))
        if not filename.exists():
            msgbox.showerror("Open file", "Cannot open this file\n(%s)" % str(filename))
            return

class MainController(Controller):

    def back(self, event):
        # FIXME: implementar esta función para regresar al menu anterior
        pass

    def eje_teo_tema1(self, event):
        """Cambia la vista de la ventana.
        pasamos a crear todos los componentes para la primera practica
        """
        model = EjerciciosTema1Model()
        controller = EjerciciosTema1Controller(self._window, model)
        view = EjerciciosTema1View(self._window, controller)
        controller.set_view(view)
        view.init_view()