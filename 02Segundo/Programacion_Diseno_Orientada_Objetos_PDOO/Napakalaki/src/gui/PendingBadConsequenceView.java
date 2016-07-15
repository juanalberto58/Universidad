package gui;

import napakalaki.BadConsequence;
import napakalaki.NumericBadConsequence;
import napakalaki.SpecificBadConsequence;

/**
 *
 * @author Carlos de al Torre
 */
public class PendingBadConsequenceView extends javax.swing.JPanel {

    /**
     * Este será el objeto de tipo PendingBadConsequence que tengamos en la
     * vista para preguntarle todos los datos necesarios.
     */
    BadConsequence pendingbadconsequenceModel;

    /**
     * Creates new form BadConsequenceView
     */
    public PendingBadConsequenceView() {
        initComponents();
    }

    /**
     * Con este metodo conseguimos asignar el PendingBadConsequence a la vista para
     * mostrar todos sus atributos.
     *
     * @param aBadConsequence es un objeto de cualquiera de las clases que hay
     * de BadConsequence, ya que lo leera igualmente.
     */
    protected void setPendingBadConsequence(BadConsequence aBadConsequence) {
        this.pendingbadconsequenceModel = aBadConsequence;
        String cadenaVisibles, cadenaOcultos;
        this.jTNiveles.setText("" + this.pendingbadconsequenceModel.getLevels());
        if (this.pendingbadconsequenceModel.getDeath()) {
            this.jTMuerte.setText("Si");
        } else {
            this.jTMuerte.setText("No");
        }
        if (this.pendingbadconsequenceModel instanceof NumericBadConsequence) {
            this.jTATesorosVisibles.setText(""+((NumericBadConsequence) this.pendingbadconsequenceModel).getNVisibleTreasures());
            this.jTATesorosOcultos.setText(""+((NumericBadConsequence) this.pendingbadconsequenceModel).getNHiddenTreasures());
            this.jTATextoMalRollo.setText("Tienes que descartarte de cualquier tipo de tesoro hasta dejar a cero los contadores");
        } else if (this.pendingbadconsequenceModel instanceof SpecificBadConsequence) {
            cadenaVisibles = ((SpecificBadConsequence) this.pendingbadconsequenceModel).getSpecificVisibleTreasures().toString();
            cadenaOcultos = ((SpecificBadConsequence) this.pendingbadconsequenceModel).getSpecificHiddenTreasures().toString();
            this.jTATesorosVisibles.setText(cadenaVisibles);
            this.jTATesorosOcultos.setText(cadenaOcultos);
            this.jTATextoMalRollo.setText("Por favor descartaté de: " + cadenaVisibles + " Visibles y " + cadenaOcultos + " Ocultos");
        } else {
            this.jLDescarteVisibles.setVisible(false);
            this.jLDescarteOcultos.setVisible(false);
            this.jTATesorosVisibles.setVisible(false);
            this.jTATesorosOcultos.setVisible(false);
        }
        repaint();
        revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTATesorosOcultos = new javax.swing.JTextArea();
        jLPierdes = new javax.swing.JLabel();
        jTNiveles = new javax.swing.JTextField();
        jLVasAMorir = new javax.swing.JLabel();
        jTMuerte = new javax.swing.JTextField();
        jLNiveles = new javax.swing.JLabel();
        jTATextoMalRollo = new javax.swing.JTextArea();
        jLDescarteVisibles = new javax.swing.JLabel();
        jLDescarteOcultos = new javax.swing.JLabel();
        jTATesorosVisibles = new javax.swing.JTextArea();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Mal Rollo Pendiente"));
        setMinimumSize(new java.awt.Dimension(234, 230));
        setPreferredSize(new java.awt.Dimension(234, 230));
        setRequestFocusEnabled(false);

        jTATesorosOcultos.setBackground(new java.awt.Color(238, 238, 238));
        jTATesorosOcultos.setColumns(20);
        jTATesorosOcultos.setLineWrap(true);
        jTATesorosOcultos.setRows(2);

        jLPierdes.setLabelFor(jTNiveles);
        jLPierdes.setText("Pierdes:");

        jTNiveles.setBackground(new java.awt.Color(238, 238, 238));
        jTNiveles.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTNiveles.setText("jTNiveles");
        jTNiveles.setBorder(null);

        jLVasAMorir.setLabelFor(jLPierdes);
        jLVasAMorir.setText("Vas a Morir:");

        jTMuerte.setBackground(new java.awt.Color(238, 238, 238));
        jTMuerte.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTMuerte.setText("jTMuerte");
        jTMuerte.setBorder(null);

        jLNiveles.setLabelFor(jLPierdes);
        jLNiveles.setText("niveles");

        jTATextoMalRollo.setBackground(new java.awt.Color(238, 238, 238));
        jTATextoMalRollo.setColumns(19);
        jTATextoMalRollo.setLineWrap(true);
        jTATextoMalRollo.setRows(3);
        jTATextoMalRollo.setBorder(null);

        jLDescarteVisibles.setLabelFor(jTATesorosOcultos);
        jLDescarteVisibles.setText("Descártate de Visibles:");

        jLDescarteOcultos.setLabelFor(jTATesorosOcultos);
        jLDescarteOcultos.setText("Descártate de Ocultos:");

        jTATesorosVisibles.setBackground(new java.awt.Color(238, 238, 238));
        jTATesorosVisibles.setColumns(20);
        jTATesorosVisibles.setLineWrap(true);
        jTATesorosVisibles.setRows(2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLVasAMorir)
                        .addGap(3, 3, 3)
                        .addComponent(jTMuerte, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLPierdes)
                        .addGap(2, 2, 2)
                        .addComponent(jTNiveles, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLNiveles))
                    .addComponent(jLDescarteOcultos)
                    .addComponent(jTATesorosOcultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTATesorosVisibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDescarteVisibles)
                    .addComponent(jTATextoMalRollo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTATextoMalRollo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPierdes)
                    .addComponent(jTNiveles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLNiveles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLVasAMorir)
                    .addComponent(jTMuerte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLDescarteVisibles)
                .addGap(0, 0, 0)
                .addComponent(jTATesorosVisibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLDescarteOcultos)
                .addGap(0, 0, 0)
                .addComponent(jTATesorosOcultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLDescarteOcultos;
    private javax.swing.JLabel jLDescarteVisibles;
    private javax.swing.JLabel jLNiveles;
    private javax.swing.JLabel jLPierdes;
    private javax.swing.JLabel jLVasAMorir;
    private javax.swing.JTextArea jTATesorosOcultos;
    private javax.swing.JTextArea jTATesorosVisibles;
    private javax.swing.JTextArea jTATextoMalRollo;
    private javax.swing.JTextField jTMuerte;
    private javax.swing.JTextField jTNiveles;
    // End of variables declaration//GEN-END:variables
}