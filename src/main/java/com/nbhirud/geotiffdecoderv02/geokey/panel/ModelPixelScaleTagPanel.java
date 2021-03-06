/*
 * ModelPixelScaleTagPanel.java
 *
 * Created on August 16, 2008, 12:43 PM
 */

package geokey.panel;

/**
 *
 * @author  KPServer
 */
public class ModelPixelScaleTagPanel extends javax.swing.JPanel {

    /** Creates new form ModelPixelScaleTagPanel */
    public ModelPixelScaleTagPanel(double values[]) {
        initComponents();
        scaleXTextField.setText(""+values[0]);
        scaleYTextField.setText(""+values[1]);
        scaleZTextField.setText(""+values[2]);
       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scaleXLabel = new javax.swing.JLabel();
        scaleYLabel = new javax.swing.JLabel();
        scaleZLabel = new javax.swing.JLabel();
        scaleXTextField = new javax.swing.JTextField();
        scaleYTextField = new javax.swing.JTextField();
        scaleZTextField = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Model Pixel Scale", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 255))); // NOI18N

        scaleXLabel.setText("X   :");

        scaleYLabel.setText(" Y   :");

        scaleZLabel.setText("Z   :");

        scaleXTextField.setEditable(false);
        scaleXTextField.setText("scaleX");

        scaleYTextField.setEditable(false);
        scaleYTextField.setText("scaleY");

        scaleZTextField.setEditable(false);
        scaleZTextField.setText("scaleZ");
        scaleZTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleZTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scaleXLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scaleXTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scaleYLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scaleYTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(scaleZLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scaleZTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {scaleXTextField, scaleYTextField, scaleZTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(scaleXLabel)
                .addComponent(scaleXTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(scaleYLabel)
                .addComponent(scaleYTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(scaleZLabel)
                .addComponent(scaleZTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void scaleZTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleZTextFieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_scaleZTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel scaleXLabel;
    private javax.swing.JTextField scaleXTextField;
    private javax.swing.JLabel scaleYLabel;
    private javax.swing.JTextField scaleYTextField;
    private javax.swing.JLabel scaleZLabel;
    private javax.swing.JTextField scaleZTextField;
    // End of variables declaration//GEN-END:variables

}
