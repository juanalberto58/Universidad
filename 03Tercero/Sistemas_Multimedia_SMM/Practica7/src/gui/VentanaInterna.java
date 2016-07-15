package gui;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import sm.cdlt.ui.Lienzo2D;

/**
 *
 * For contact with me visit https://www.sudano.net or send me a email
 *
 * @author <a href="mailto:cdelatorre@correo.ugr.es">Carlos de al Torre</a>
 * created on 14-abr-2016
 */
public class VentanaInterna extends javax.swing.JInternalFrame{

    /**
     * Para poder devolver mensajes a la ventana principal.
     */
    VentanaPrincipal myParent;

    /**
     * Creates new form VentanaInterna
     *
     * @param parent Este sera el padre de la Ventana.
     */
    public VentanaInterna(VentanaPrincipal parent) {
        initComponents();
        // le pongo el borde discontinuo al Lienzo
        this.JPanelLienzo.setBorder(BorderFactory.createDashedBorder(Color.BLACK, 1F, 5F, 3F, true));
        // añado el padre de la ventana
        this.myParent = parent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelLienzo = new sm.cdlt.ui.Lienzo2D();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Nombre del Dibujo");
        setToolTipText("Aquí ponemos el tamaño de la imagen");
        setMinimumSize(new java.awt.Dimension(200, 200));
        setPreferredSize(new java.awt.Dimension(400, 400));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(null);

        JPanelLienzo.setMinimumSize(new java.awt.Dimension(200, 200));
        JPanelLienzo.setPreferredSize(new java.awt.Dimension(300, 300));
        JPanelLienzo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                JPanelLienzoMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout JPanelLienzoLayout = new javax.swing.GroupLayout(JPanelLienzo);
        JPanelLienzo.setLayout(JPanelLienzoLayout);
        JPanelLienzoLayout.setHorizontalGroup(
            JPanelLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        JPanelLienzoLayout.setVerticalGroup(
            JPanelLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        getContentPane().add(JPanelLienzo);
        JPanelLienzo.setBounds(0, 0, 300, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Nos devuelve el Lienzo de la ventana Interna para poder cambiar sus
     * propiedades.
     *
     * @return Devuelve un objeto de tipo Lienzo2D que es donde pintamos.
     */
    public Lienzo2D getLienzo() {
        return JPanelLienzo;
    }

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // el grosor de la linea
        this.myParent.jSpinnerGrosor.setValue((int) this.JPanelLienzo.getStroke());
        String aux_option = this.JPanelLienzo.whatOptionSelected();
        switch (aux_option) {
            case "paint":
                this.myParent.jToggleButtonPintar.setSelected(true);
                this.myParent.jLabelAccionRaton.setText(VentanaPrincipal.bundle.getString("MOUSE"));
                break;
            case "move":
                this.myParent.jToggleButtonMover.setSelected(true);
                this.myParent.jLabelAccionRaton.setText(VentanaPrincipal.bundle.getString("MOVE"));
                break;
            case "delete":
                //this.myParent.jToggleButtonBorrar.setSelected(true);
                this.myParent.jLabelAccionRaton.setText(VentanaPrincipal.bundle.getString("DELETE"));
                break;
            default:
                break;
        }
        // si esta relleno
        if (this.JPanelLienzo.withFill()){
            this.myParent.getToggleButtonRelleno().setSelected(true);
        }else{
            this.myParent.getToggleButtonRelleno().setSelected(false);
        }
        // si aplicamos alisado
        this.myParent.jToggleButtonAntiAliasing.setSelected(this.JPanelLienzo.getFlatten());
        // si tiene transparencia
        this.myParent.jSpinnerTransparencia.setValue(this.JPanelLienzo.getAlpha());

        // el color que esta elegido
        if (this.JPanelLienzo.getColor().equals(Color.BLACK)) {
            this.myParent.jComboBoxColor.setSelectedItem(Color.BLACK);
        } else if (this.JPanelLienzo.getColor().equals(Color.WHITE)) {
            this.myParent.jComboBoxColor.setSelectedItem(Color.WHITE);
        } else if (this.JPanelLienzo.getColor().equals(Color.RED)) {
            this.myParent.jComboBoxColor.setSelectedItem(Color.RED);
        } else if (this.JPanelLienzo.getColor().equals(Color.GREEN)) {
            this.myParent.jComboBoxColor.setSelectedItem(Color.GREEN);
        } else if (this.JPanelLienzo.getColor().equals(Color.BLUE)) {
            this.myParent.jComboBoxColor.setSelectedItem(Color.BLUE);
        } else if (this.JPanelLienzo.getColor().equals(Color.YELLOW)) {
            this.myParent.jComboBoxColor.setSelectedItem(Color.YELLOW);
        }
        this.myParent.jLabelColor.setText(VentanaPrincipal.bundle.getString("COLOR")
                + "[R: " + ((Color) this.myParent.jComboBoxColor.getSelectedItem()).getRed()
                + " G: " + ((Color) this.myParent.jComboBoxColor.getSelectedItem()).getGreen()
                + " B: " + ((Color) this.myParent.jComboBoxColor.getSelectedItem()).getBlue() + "]");
        // la herramienta que esta elegida
        switch (this.JPanelLienzo.getTool()) {
            case "point":
                this.myParent.jToggleButtonPunto.setSelected(true);
                this.myParent.jLabelHerramienta.setText(VentanaPrincipal.bundle.getString("TOOL_POINT"));
                break;
            case "line":
                this.myParent.jToggleButtonLinea.setSelected(true);
                this.myParent.jLabelHerramienta.setText(VentanaPrincipal.bundle.getString("TOOL_LINE"));
                break;
            case "rect":
                this.myParent.jToggleButtonRectangulo.setSelected(true);
                this.myParent.jLabelHerramienta.setText(VentanaPrincipal.bundle.getString("TOOL_RECT"));
                break;
            case "oval":
                this.myParent.jToggleButtonCirculo.setSelected(true);
                this.myParent.jLabelHerramienta.setText(VentanaPrincipal.bundle.getString("TOOL_CIRCLE"));
                break;
        }
    }//GEN-LAST:event_formInternalFrameActivated

    private void JPanelLienzoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPanelLienzoMouseMoved
        this.myParent.jLabelMousePos.setText(VentanaPrincipal.bundle.getString("MOUSE_POS") + " (" + (int) evt.getPoint().getX() + ":" + (int) evt.getPoint().getY() + ")");
        if (this.myParent.jToggleButtonPintar.isSelected()) {
            this.JPanelLienzo.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        } else if (this.myParent.jToggleButtonMover.isSelected()) {
            this.JPanelLienzo.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        } else {
            this.JPanelLienzo.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_JPanelLienzoMouseMoved

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sm.cdlt.ui.Lienzo2D JPanelLienzo;
    // End of variables declaration//GEN-END:variables
}
