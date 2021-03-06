package gui.others;

import javax.swing.ImageIcon;
import sm.cdlt.util.Utils;

/**
 *
 * @author Carlos de al Torre
 */
public class AcercaDe extends javax.swing.JDialog {

    /**
     * Esta será la imagen que queremos mostrar.
     */
    ImageIcon miImage = null;
    
    /**
     * Creates new form AcercaDe
     * @param parent Será el la ventana padre
     * @param modal especifica el modo de la ventana, verdadero se puede
     * manipular la ventana padre aunque la hija este abierta,
     * falso para el caso contrario
     */
    public AcercaDe(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextPaneInfo = new javax.swing.JTextPane();
        jLabelImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acerca de ...");
        setIconImage(null);
        setMaximumSize(new java.awt.Dimension(525, 230));
        setMinimumSize(new java.awt.Dimension(525, 230));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(525, 230));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jTextPaneInfo.setEditable(false);
        jTextPaneInfo.setBackground(new java.awt.Color(238, 238, 238));
        jTextPaneInfo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTextPaneInfo.setText("Desarrollador:\n      Carlos de la Torre\nAsignatura:\n      Sistemas Multimedia\nBlog Personal:\n       https://www.sudano.net\nPerfil Profecional:\n       https://es.linkedin.com/in/soycarlosdelatorre\n");
        getContentPane().add(jTextPaneInfo, java.awt.BorderLayout.CENTER);
        jTextPaneInfo.getAccessibleContext().setAccessibleDescription("Información del Desarrollador");

        jLabelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/foto.jpg"))); // NOI18N
        jLabelImagen.setMaximumSize(new java.awt.Dimension(150, 200));
        jLabelImagen.setMinimumSize(new java.awt.Dimension(150, 200));
        jLabelImagen.setPreferredSize(new java.awt.Dimension(150, 200));
        jLabelImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImagenMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelImagen, java.awt.BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImagenMouseClicked
        if (evt.getClickCount() == 5){
            Splash miSplash = new Splash(this);
            miSplash.setVisible(true);
            miSplash.setLocation(Utils.centerOfScreen(miSplash.getWidth(),miSplash.getHeight()));
        }
    }//GEN-LAST:event_jLabelImagenMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JTextPane jTextPaneInfo;
    // End of variables declaration//GEN-END:variables
}
