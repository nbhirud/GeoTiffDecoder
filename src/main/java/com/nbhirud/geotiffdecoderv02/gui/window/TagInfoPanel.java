/*
 * TagInfoPanel.java
 *
 * Created on August 26, 2008, 12:51 PM
 */

package gui.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import reader.IGeoTiffTag;

/**
 *
 * @author  kamlesh.paunikar
 */
public class TagInfoPanel extends javax.swing.JPanel {

    private JTable table;
    private JScrollPane scrollPane;
    
    /** Creates new form TagInfoPanel */
    public TagInfoPanel(IGeoTiffTag geoTiffTag) {
        initComponents();
        scrollPane=new JScrollPane();
        TagInfoTableModel tagInfoTableModel=new TagInfoTableModel(geoTiffTag);
        table=new JTable(tagInfoTableModel);
        table.setDefaultRenderer(JButton.class, new TagInfoCellRenderer());
        TableColumn column = table.getColumnModel().getColumn(3);
        column.setCellEditor(new TagInfoCellEditor());
        scrollPane.setViewportView(table);
        add(scrollPane,BorderLayout.CENTER);
        int tableRowHeight=table.getRowHeight();
        scrollPane.setPreferredSize(new Dimension(getPreferredSize().width, tableRowHeight * (table.getRowCount()+1)));
        setPreferredSize(scrollPane.getPreferredSize());
    }

    void refresh() {
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}