/*
 * ProductInformationWindow.java
 *
 * Created on August 26, 2008, 12:50 PM
 */
package gui.window;

import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import reader.IGeoTiffTag;

/**
 *
 * @author  kamlesh.paunikar
 */
public class ProductInformationWindow extends javax.swing.JFrame {

    private JSplitPane splitPane;
    private TagInfoPanel tagInfoPanel;
    

    /** Creates new form ProductInformationWindow */
    public ProductInformationWindow(IGeoTiffTag geoTiffTag) {
        initComponents();
        tagInfoPanel = new TagInfoPanel(geoTiffTag);
        splitPane = new JSplitPane();
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(tagInfoPanel);
        add(splitPane, BorderLayout.CENTER);
        pack();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setTitle("Product Information");

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-408)/2, (screenSize.height-334)/2, 408, 334);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public void refreshTagInfoPanel() {
        tagInfoPanel.refresh();
    }

    public void refreshKeyInfoPanel() {
    }

    public void refresh() {
        tagInfoPanel.refresh();

    }
}