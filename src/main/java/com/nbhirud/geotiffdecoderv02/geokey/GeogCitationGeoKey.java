/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import com.sun.media.jai.codec.TIFFField;
import geokey.panel.GeogCitationGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoAsciiParamsTag;

/**
 *
 * @author KPServer
 */
public class GeogCitationGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int GEOGCITATIONGEOKEY = 2049;
    private boolean isAvailable = false;
    private String[] values;
    private GeogCitationGeoKeyPanel geogCitationGeoKeyPanel;

    /**
     * 
     * @param tIFFFields
     */
    public GeogCitationGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoAsciiParamsTag geoAsciiParamsTag = iGeoTiffTag.getGeoAsciiParamsTag();
        int valueCount = geoAsciiParamsTag.getValueCount();
        if (valueCount > 0) {
            isAvailable = true;
            values = new String[valueCount];
            for (int index = 0; index < valueCount; index++) {
                values[index] = geoAsciiParamsTag.getValue(index);
            }
            geogCitationGeoKeyPanel = new GeogCitationGeoKeyPanel(values);
        }
    }

    /**
     * 
     * @return
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * 
     * @return
     */
    public String[] getValues() {
        return values;
    }

    /**
     * 
     * @return
     */
    @Override
    public String toString() {
        String string = null;

        string += "Type = ASCII\nValues = text\nGeneral citation and reference for all Geographic CS parameters.";
        return string;
    }

    public JPanel getPanel() {
        return geogCitationGeoKeyPanel;
    }
}
