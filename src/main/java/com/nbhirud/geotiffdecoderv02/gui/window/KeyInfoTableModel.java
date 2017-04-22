/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.window;

import geokey.IGeoKeyInfo;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author kamlesh.paunikar
 */
public class KeyInfoTableModel implements TableModel {

    private String columns[] = {"Key Information"};
    private Class<?> columnClass[] = {JPanel.class};
    private ArrayList<IGeoKeyInfo> geoKeyInfoList = new ArrayList<IGeoKeyInfo>();
    
   public KeyInfoTableModel(ArrayList<IGeoKeyInfo> geoKeyInfoList) {
        this.geoKeyInfoList = geoKeyInfoList;
    }

    public int getRowCount() {
        return geoKeyInfoList.size();
    }

    public int getColumnCount() {
        return columns.length;
    }

    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    public Class<?> getColumnClass(int columnIndex) {
       return columnClass[columnIndex];
    }

     public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return geoKeyInfoList.get(rowIndex).getPanel();
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }

    public void addTableModelListener(TableModelListener l) {
        
    }

    public void removeTableModelListener(TableModelListener l) {
        
    }
}
