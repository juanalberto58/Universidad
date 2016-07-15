package gui.modal;

import java.awt.event.ActionEvent;


/**
 * This class For contact with me visit https://www.sudano.net or send me a
 * email
 * <a href="mailto:cdelatorre@correo.ugr.es">Carlos de la Torre</a>
 *
 * @author <a href="mailto:cdelatorre@correo.ugr.es">Carlos de la Torre</a>
 * created on 01-may-2016
 */
public class QuestionsRecordOptions extends Questions {

    /**
     * Ventana modal que se encarga de hacer diferentes preguntas al usuario.
     *
     * @param parent [in] Este será el padre de la ventana modal
     * @param modal [in] aquí indicamos el tipo de ventana modal que queremos:
     * si podemos pinchar fuera de ella sin seleccionar nada o por el contrario
     * tenemos que seleccionar algo para cerrar la ventana y continuar.
     */
    public QuestionsRecordOptions(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setContentDialog(this.jPanelContent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupOptions = new javax.swing.ButtonGroup();
        jPanelContent = new javax.swing.JPanel();
        jRadioButtonSound = new javax.swing.JRadioButton();
        jRadioButtonVideo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelContent.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanelContent.setLayout(new javax.swing.BoxLayout(jPanelContent, javax.swing.BoxLayout.PAGE_AXIS));

        buttonGroupOptions.add(jRadioButtonSound);
        jRadioButtonSound.setSelected(true);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("internalization/Bundle"); // NOI18N
        jRadioButtonSound.setText(bundle.getString("RECORD_SOUND")); // NOI18N
        jPanelContent.add(jRadioButtonSound);

        buttonGroupOptions.add(jRadioButtonVideo);
        jRadioButtonVideo.setText(bundle.getString("RECORD_VIDEO")); // NOI18N
        jPanelContent.add(jRadioButtonVideo);

        getContentPane().add(jPanelContent, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.jRadioButtonSound.isSelected()) {
            this.myParent.setOptionRecording("sound");
        } else {
            this.myParent.setOptionRecording("video");
        }
        dispose();
    }

    @Override
    protected void jButtonCancelActionPerformed(ActionEvent evt) {
        super.jButtonCancelActionPerformed(evt);
        this.myParent.getToggleButtonRecord().setSelected(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupOptions;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JRadioButton jRadioButtonSound;
    private javax.swing.JRadioButton jRadioButtonVideo;
    // End of variables declaration//GEN-END:variables
}
