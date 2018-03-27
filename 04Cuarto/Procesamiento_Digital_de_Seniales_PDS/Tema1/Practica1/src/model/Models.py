#!/usr/bin/python
# -*- coding: UTF-8 -*-

"""Lista de modelos del programa.

En este fichero podemos encontrarnos todos los modelos,
que se pueden usar para nuestro programa.
"""

from src.model.Model import Model, play, mix, wave, plt, numpy

class EjerciciosTema1Model(Model):

    def hacer_algo(self):
        pass

    def leer_wave(self, filename):
        spf = wave.open(filename, 'r')
        params = spf.getparams()
        framerate = params[2]
        x = spf.readframes(-1)
        x = numpy.fromstring(x, 'Int16')
        plt.figure(1)
        plt.subplot(211)
        plt.title('Onda de:\n' + filename)
        plt.plot(x)
        spf.close()
        return plt, x, framerate

    def representa_espectrograma(self, x, NFFT, Fs, noverlap):
        plt.figure(1)
        plt.subplot(212)
        plt.title('Espectograma')
        plt.ylabel('Frequencia [Hz]')
        plt.xlabel('Tiempo [seg]')
        Pxx, freqs, bins, im = plt.specgram(x, NFFT=NFFT, Fs=Fs, cmap='jet', noverlap=noverlap)
        return plt, Pxx, freqs

    def reproducir(self, filename):
        play(mix.from_wav(filename))

class Practica1Model(Model):

    def hacer_algo(self):
        pass

    def leer_wave(self, filename):
        spf = wave.open(filename, 'r')
        params = spf.getparams()
        framerate = params[2]
        x = spf.readframes(-1)
        x = np.fromstring(x, 'Int16')
        plt.title('Onda de:\n' + filename)
        plt.plot(x)
        plt.show()
        return x, framerate

    def representa_espectrograma(self, x, NFFT, Fs, noverlap):
        Pxx, freqs, bins, im = plt.specgram(x, NFFT=NFFT, Fs=Fs, cmap='jet', noverlap=noverlap)
        plt.title('Espectograma de:\n' + filename)
        plt.ylabel('Frequencia [Hz]')
        plt.xlabel('Tiempo [seg]')
        plt.plot(Pxx)
        plt.show()
        return Pxx, freqs

    def reproducir(self, filename):
        """Función para reproducir el sonido que queremos

        prametros de entrada:
        filename: cadena de texto, fichero a reproducir."""
        play(mix.from_wav(filename))

class EjerciciosTema2Model(Model):

    def hacer_algo(self):
        pass


class OtherModel(Model):

    def hacer_algo(self):
        pass

    def bin_dec(self, num=0):
        """Función que combierte un numero binario en decimal

        prametros de entrada:
        num: cadena de texto, con el numero binario.

        parametros de salida:
        entero, el numero decimal convertido."""
        return int(num, 2)

    def pos(self, num=0):
        """Función que busca la posición de inicio de la lectura del texto

        párametros de entrada:
        num: entero, con el dividendo para el cálculo.

        párametros de salida:
        entero, la posición de comienzo de la lectura."""
        return int(num/1589)

    def text(self, string, pos):
        """Función que devuelve los 10 siguiente caracteres de la cadena
        que pasamos por párametros, a partir de la posición que indiquemos
        en el segundo párametro.

        párametros de entrada:
        str: cadena de texto, cadena que analizamos
        pos: entero, posición desde donde se empieza a analizar

        párametros de salida:
        cadena de texto, los 10 caracteres que están justo a continuación de pos."""

        return string[pos:pos+10]

class MainModel(Model):

    def hacer_algo(self):
        pass