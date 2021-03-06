package gui;

import gui.componets.VentanaInternaListModel;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import sm.cdlt.images.MultipleImageOP;

/**
 *
 * For contact with me visit https://www.sudano.net or send me a email
 *
 * @author <a href="mailto:cdelatorre@correo.ugr.es">Carlos de al Torre</a>
 * created on 18-may-2016
 */
public class VentanaInternaBlend extends VentanaInterna {

    /**
     * Imagenes que hay que mezclar.
     */
    private ArrayList<BufferedImage> images_to_mix;
    /**
     * Variable que almacena el modelo de datos de la lista de imagenes;
     */
    private final VentanaInternaListModel model_list = new VentanaInternaListModel();
    /**
     * Que tipo de operación se va a realizar en la ventana
     */
    private MultipleImageOP operation;
    /**
     * Lista de imagenes
     */
    private String[] images;
    /**
     * Valores de alpha para las diferentes imagenes
     */
    private float[] alphas;

    /**
     * Creates new form VentanaInternaBlend
     */
    public VentanaInternaBlend() {
        super();
        initComponents();
    }

    /**
     * Constructor para crear una ventana interna, se utilizan tres parámetros
     * para darle mas funcionalidad al programa, parent es para indicar cual es
     * el padre de la ventanainterna, d es la dimensión que queremos que tenga
     * la ventana interna, t es el tipo de imagenes que queremos crear entro de
     * la ventana interna, una vez terminada la construccion de la ventana padre
     * se añade le panel lateral donde se muestra la información para procesar
     * imagenes.
     *
     * @param parent [in] Este será el padre de la Ventana.
     * @param d [in] Objeto tipo Dimension que indica el tamaño de la imagen que
     * queremos dentro de la ventana.
     * @param t [in] Tipo entero que indica el tipo de la imagen a crear.
     */
    public VentanaInternaBlend(VentanaPrincipal parent, Dimension d, int t) {
        super(parent, d, t);
        initComponents();
        this.setRightPanel(this.jPanelContent);
    }

    /**
     * Con este método podemos decidir que tipo de operación se va a realizar en
     * la ventana.
     *
     * @param imgs [in] lista de imagenes que se van a procesar.
     * @param o [in] Tipo MultipleImageOP operación que queremos realizar en las
     * imagenes.
     */
    public void setOperation(MultipleImageOP o, ArrayList<BufferedImage> imgs) {
        this.operation = o;
        this.images_to_mix = imgs;
        int aux_size = this.images_to_mix.size();
        this.images = new String[aux_size];
        this.alphas = new float[aux_size];
        Arrays.fill(alphas, 1.0f / aux_size);
        for (int i = 0; i < this.images.length; i++) {
            this.images[i] = "Image " + (i + 1);
        }
        this.model_list.setCadenas(this.images);
        this.JPanelLienzo.setImage(this.operation.applyOP(this.images_to_mix, this.alphas, this.JPanelLienzo.getImage()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContent = new javax.swing.JPanel();
        jScrollPaneImages = new javax.swing.JScrollPane();
        jListImages = new javax.swing.JList<>();
        jPanelSliderBlend = new javax.swing.JPanel();
        jLabelImageDownAlpha = new javax.swing.JLabel();
        jSliderBlend = new javax.swing.JSlider();
        jLabelImageUpAlpha = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanelButtons = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        jPanelContent.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanelContent.setLayout(new javax.swing.BoxLayout(jPanelContent, javax.swing.BoxLayout.PAGE_AXIS));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("interna/Bundle"); // NOI18N
        jScrollPaneImages.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("IMAGE_LIST"))); // NOI18N
        jScrollPaneImages.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneImages.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPaneImages.setMaximumSize(new java.awt.Dimension(250, 250));

        jListImages.setModel(this.model_list);
        jListImages.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListImages.setMaximumSize(new java.awt.Dimension(36, 75));
        jListImages.setPreferredSize(new java.awt.Dimension(36, 36));
        jListImages.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListImagesValueChanged(evt);
            }
        });
        jScrollPaneImages.setViewportView(jListImages);

        jPanelContent.add(jScrollPaneImages);

        jPanelSliderBlend.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanelSliderBlend.setLayout(new javax.swing.BoxLayout(jPanelSliderBlend, javax.swing.BoxLayout.LINE_AXIS));

        jLabelImageDownAlpha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImageDownAlpha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/alpha_down.png"))); // NOI18N
        jPanelSliderBlend.add(jLabelImageDownAlpha);

        jSliderBlend.setValue(0);
        jSliderBlend.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5));
        jSliderBlend.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderBlendStateChanged(evt);
            }
        });
        jPanelSliderBlend.add(jSliderBlend);

        jLabelImageUpAlpha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImageUpAlpha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/alpha_up.png"))); // NOI18N
        jPanelSliderBlend.add(jLabelImageUpAlpha);

        jPanelContent.add(jPanelSliderBlend);
        jPanelContent.add(filler1);

        jPanelButtons.setLayout(new javax.swing.BoxLayout(jPanelButtons, javax.swing.BoxLayout.LINE_AXIS));

        jButtonSave.setText(bundle.getString("SAVE")); // NOI18N
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonSave);

        jButtonCancel.setText(bundle.getString("BUTTON_CANCEL")); // NOI18N
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonCancel);

        jPanelContent.add(jPanelButtons);

        getContentPane().add(jPanelContent, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListImagesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListImagesValueChanged
        int idx = this.jListImages.getSelectedIndex();
        /* primero multiplico luego casting, si no multiplica por 0*/
        this.jSliderBlend.setValue((int) (this.alphas[idx] * 100));
    }//GEN-LAST:event_jListImagesValueChanged

    /**
     * Al mover el slider y no tener ningúna imagen seleccionada en la lista 
     * se cambiara el valor para todas las imagenes, sin embargo si seleccionamos
     * una imgaen se cambiara el valor solo para esa imagen.
     * @param evt [in]
     */
    private void jSliderBlendStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderBlendStateChanged
        int aux = this.jListImages.getSelectedIndex();
        if (aux < 0) {
            for (int i = 0; i < this.alphas.length; i++) {
                this.alphas[i] = this.jSliderBlend.getValue() * 0.01f;
            }
        } else {
            this.alphas[aux] = this.jSliderBlend.getValue() * 0.01f;
        }
        this.JPanelLienzo.setImage(this.operation.applyOP(this.images_to_mix, this.alphas, this.JPanelLienzo.getImage()));
    }//GEN-LAST:event_jSliderBlendStateChanged

    /**
     * Con este botón creamos una ventana nueva y almacenamos la imagen resultante
     * por si queremos aplicar mas efectos diferentes.
     * Ya que esta parte de la aplicación solo esta dedicada a las imagenes 
     * @param evt 
     */
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        VentanaInterna ultima_ventana = (VentanaInterna) this.myParent.getEscritorio().getSelectedFrame();
        VentanaInterna vi = new VentanaInterna(this.myParent, new Dimension(this.JPanelLienzo.getImage().getWidth(), this.JPanelLienzo.getImage().getHeight()), BufferedImage.TYPE_INT_ARGB);
        VentanaPrincipal.COUNT_VI++;
        vi.setTitle("(Sin Título " + VentanaPrincipal.COUNT_VI + ")");
        vi.setLocation(ultima_ventana.getLocation().x + 15, ultima_ventana.getLocation().y + 15);
        this.myParent.getEscritorio().add(vi);
        vi.JPanelLienzo.setImage(this.JPanelLienzo.getImage());
        vi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.formInternalFrameClosing(null);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabelImageDownAlpha;
    private javax.swing.JLabel jLabelImageUpAlpha;
    private javax.swing.JList<String> jListImages;
    private javax.swing.JPanel jPanelButtons;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelSliderBlend;
    private javax.swing.JScrollPane jScrollPaneImages;
    private javax.swing.JSlider jSliderBlend;
    // End of variables declaration//GEN-END:variables
}
