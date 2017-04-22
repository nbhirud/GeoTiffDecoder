/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import geokey.panel.GTCitationGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoAsciiParamsTag;

/**
 *
 * @author KPServer
 */
public class GTCitationGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int GTCITATIONGEOKEY = 1026;
    private boolean isAvailable = false;
    private String value[];
    private GTCitationGeoKeyPanel gTCitationGeoKeyPanel;

    public GTCitationGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoAsciiParamsTag geoAsciiParamsTag = iGeoTiffTag.getGeoAsciiParamsTag();
        if (geoAsciiParamsTag != null) {
            isAvailable=true;
            int valueCount = geoAsciiParamsTag.getValueCount();
            if (valueCount > 0) {
                value = new String[valueCount];
                for (int index = 0; index < valueCount; index++) {
                    value[index] = geoAsciiParamsTag.getValue(index);
                }
                gTCitationGeoKeyPanel = new GTCitationGeoKeyPanel(value);
            }
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
    public String[] getValue() {
        return value;
    }

    @Override
    /**
     * 
     */
    public String toString() {
        String string = "give an ASCII reference to published documentation on the overall configuration of GeoTIFF file.";

        return string;
    }

    public JPanel getPanel() {
        return gTCitationGeoKeyPanel;
    }
}
