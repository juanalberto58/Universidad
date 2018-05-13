package utils;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author usuario
 */
public class utilities {

    /**
     * Variables que sirven para posicionar la aplicación en mirad de la
     * pantalla.
     */
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private static final double SCREEN_WIDTH = SCREEN_SIZE.getWidth();
    private static final double SCREEN_HEIGHT = SCREEN_SIZE.getHeight();

    /**
     * Con este método podemos poner cualquier objeto que tenga el método
     * setLocation(), justamente en el centro de la pantalla, así pues, si
     * nosotros le pasamos el alto y el ancho del objeto en cuestión este método
     * nos calcula el punto donde debería estar la esquina superior izquierda de
     * dicho objeto para que saliera en el centro de la pantalla.
     *
     * @param w [in] Este será el ancho que tendrá el objeto que queremos
     * centrar
     * @param h [in] Este será el alto que tendrá el objeto que queremos centrar
     * @return Objeto de tipo Point con las coordenadas de la esquina superior
     * izquierda.
     */
    public static Point centerOfScreen(double w, double h) {
        int pos_x, pos_y;
        pos_x = pos_y = 0;
        if (w > 0 && h > 0) {
            pos_x = (int) (utilities.SCREEN_WIDTH / 2 - w / 2);
            pos_y = (int) (utilities.SCREEN_HEIGHT / 2 - h / 2);
        } else {
            // @TODO Tienes que poner una exception que sea correcta
            throw new UnsupportedOperationException("The size of the width and height are not correct");
        }
        return new Point(pos_x, pos_y);
    }

    // Funcion que convierte un array de bytes a un entero
    public static int byteArrayToInt(byte[] b) {
        switch (b.length) {
            case 4:
                return b[0] << 24 | (b[1] & 0xff) << 16 | (b[2] & 0xff) << 8 | (b[3] & 0xff);
            case 2:
                return 0x00 << 24 | 0x00 << 16 | (b[0] & 0xff) << 8 | (b[1] & 0xff);
            case 1:
                return b[0];
            default:
                return 0;
        }
    }

    // Funcion que convierte un entero a bytes
    public static byte[] toBytes(int i) {
        byte[] resultado = new byte[4];
        resultado[0] = (byte) (i >> 24);
        resultado[1] = (byte) (i >> 16);
        resultado[2] = (byte) (i >> 8);
        resultado[3] = (byte) (i /*>> 0*/);
        return resultado;
    }

    public static byte[] InputStreamToByteArray(InputStream input, int size) throws IOException {
        byte[] data = new byte[size];
        int index = 0;
        while (index < size) {
            int bytesRead = input.read(data, index, size - index);
            if (bytesRead < 0) {
                throw new IOException("Insufficient data in stream");
            }
            index += bytesRead;
        }
        return data;
    }
}
