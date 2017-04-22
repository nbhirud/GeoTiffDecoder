/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author KPServer
 */
public class TilePointTableModel implements TableModel {

    private ArrayList<TiePoint> tiePointList = new ArrayList<TiePoint>();
    private String columnNames[] = {"TiePoints", "RasterX", "RasterY", "RasterZ", "ModelX", "ModelY", "ModelZ"};

    public TilePointTableModel(ArrayList<TiePoint> tiePointList) {
        this.tiePointList = tiePointList;
    }

    public int getRowCount() {
        return tiePointList.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return Double.class;
            case 2:
                return Double.class;
            case 3:
                return Double.class;
            case 4:
                return Double.class;
            case 5:
                return Double.class;
            case 6:
                return Double.class;
        }
        return null;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        TiePoint tiePoint = tiePointList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                String s = "" + (rowIndex + 1);
                return s;
            case 1:
                return tiePoint.getPixelX();
            case 2:
                return tiePoint.getPixelY();
            case 3:
                return tiePoint.getPixelZ();
            case 4:
                return tiePoint.getGeoX();
            case 5:
                return tiePoint.getGeoY();
            case 6:
                return tiePoint.getGeoZ();
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
