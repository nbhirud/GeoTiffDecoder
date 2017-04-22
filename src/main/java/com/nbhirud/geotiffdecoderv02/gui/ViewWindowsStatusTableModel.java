/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Administrator
 */
public class ViewWindowsStatusTableModel implements TableModel {

    private ArrayList<IViewWindow> viewWindowArrayList;

    public ViewWindowsStatusTableModel(ArrayList<IViewWindow> viewWindowArrayList) {
        this.viewWindowArrayList = viewWindowArrayList;
    }
    public void setViewWindowArrayList(){
        
    }
    private String columns[] = {"Sr. No", "Map"};

    public int getRowCount() {
        return viewWindowArrayList.size();
    }

    public int getColumnCount() {
        return columns.length;
    }

    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return JLabel.class;
        }
        return null;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return ("" + (rowIndex + 1));
            case 1:
                return viewWindowArrayList.get(rowIndex).getMapName();
        }
        return null;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    public void addTableModelListener(TableModelListener l) {
       
    }

    public void removeTableModelListener(TableModelListener l) {
    }
}
