/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.window;

import javax.swing.JButton;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import reader.IGeoTiffTag;
import reader.geotag.GeoAsciiParamsTag;
import reader.geotag.GeoDoubleParamsTag;
import reader.geotag.GeoKeyDirectoryTag;
import reader.geotag.ModelPixelScaleTag;
import reader.geotag.ModelTiepointTag;

/**
 *
 * @author kamlesh.paunikar
 */
public class TagInfoTableModel implements TableModel {

    private IGeoTiffTag geoTiffTag;
    private String columnNames[] = {"Tag No.", "Tag Name", "Status", "Show"};
    private Class<?> columnClass[] = {Integer.class, String.class, String.class, JButton.class};
    private int rowCount = 5;

    TagInfoTableModel(IGeoTiffTag geoTiffTag) {
        this.geoTiffTag = geoTiffTag;
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex==3){
            return true;
        }
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(rowIndex)
        {
            case 0:
                return geoAsciiParamsTagValue(rowIndex,columnIndex);
            case 1:
                return geoDoubleParamsTagValue(rowIndex,columnIndex);
            case 2:
                return geoKeyDirectoryTagValue(rowIndex,columnIndex);
            case 3:
                return modelPixelScaleTagValue(rowIndex,columnIndex);
            case 4:
                return modelTiepointTagValue(rowIndex,columnIndex);
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }

    private Object geoAsciiParamsTagValue(int rowIndex,int columnIndex) {
        GeoAsciiParamsTag geoAsciiParamsTag = geoTiffTag.getGeoAsciiParamsTag();
        switch(columnIndex)
        {
            case 0:
                return rowIndex+1;
            case 1:
                return "GeoAsciiParamsTag";
            case 2:
                if(geoAsciiParamsTag!=null)
                {
                    return "Present";
                }
                else
                {
                    return "Not Present";
                }
            case 3:
                return new JButton("...");
        }
        return null;
    }

    private Object geoDoubleParamsTagValue(int rowIndex, int columnIndex) {
        GeoDoubleParamsTag geoDoubleParamsTag = geoTiffTag.getGeoDoubleParamsTag();
        switch(columnIndex)
        {
            case 0:
                return rowIndex+1;
            case 1:
                return "GeoDoubleParamsTag";
            case 2:
                if(geoDoubleParamsTag!=null)
                {
                    return "Present";
                }
                else
                {
                    return "Not Present";
                }
            case 3:
                return new JButton("...");
        }
        return null;
    }

    private Object geoKeyDirectoryTagValue(int rowIndex, int columnIndex) {
       GeoKeyDirectoryTag geoKeyDirectoryTag = geoTiffTag.getGeoKeyDirectoryTag();
        switch(columnIndex)
        {
            case 0:
                return rowIndex+1;
            case 1:
                return "GeoKeyDirectoryTag";
            case 2:
                if(geoKeyDirectoryTag!=null)
                {
                    return "Present";
                }
                else
                {
                    return "Not Present";
                }
            case 3:
                return new JButton("...");
        }
        return null;
    }

    private Object modelPixelScaleTagValue(int rowIndex, int columnIndex) {
       ModelPixelScaleTag modelPixelScaleTag = geoTiffTag.getModelPixelScaleTag();
        switch(columnIndex)
        {
            case 0:
                return rowIndex+1;
            case 1:
                return "ModelPixelScaleTag";
            case 2:
                if(modelPixelScaleTag!=null)
                {
                    return "Present";
                }
                else
                {
                    return "Not Present";
                }
            case 3:
                return new JButton("...");
        }
        return null;
    }

    private Object modelTiepointTagValue(int rowIndex, int columnIndex) {
       ModelTiepointTag modelTiePointTag = geoTiffTag.getModelTiepointTag();
        switch(columnIndex)
        {
            case 0:
                return rowIndex+1;
            case 1:
                return "ModelTiePointTag";
            case 2:
                if(modelTiePointTag!=null)
                {
                    return "Present";
                }
                else
                {
                    return "Not Present";
                }
            case 3:
                return new JButton("...");
        }
        return null;
    }
}
