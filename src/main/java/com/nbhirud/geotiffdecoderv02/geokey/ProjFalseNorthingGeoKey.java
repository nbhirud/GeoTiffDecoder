/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import geokey.panel.ProjFalseNorthingGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoDoubleParamsTag;
import reader.geotag.GeoKey;
import reader.geotag.GeoKeyDirectoryTag;

/**
 *
 * @author KPServer
 */
public class ProjFalseNorthingGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int PROJFALSENORTHINGGEOKEY = 3083;
    private boolean isAvailable = false;
    private double value;
    private ProjFalseNorthingGeoKeyPanel projFalseNorthingGeoKeyPanel;

    /**
     * 
     * @param tIFFFields
     */
    public ProjFalseNorthingGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoDoubleParamsTag geoDoubleParamsTag = iGeoTiffTag.getGeoDoubleParamsTag();
        GeoKeyDirectoryTag geoKeyDirectoryTag = iGeoTiffTag.getGeoKeyDirectoryTag();
        if (geoKeyDirectoryTag.isKeyPresent(PROJFALSENORTHINGGEOKEY)) {
            isAvailable = true;
            GeoKey key = geoKeyDirectoryTag.getKey(PROJFALSENORTHINGGEOKEY);
            int index = key.getValue();
            value = geoDoubleParamsTag.getValue(index);
            projFalseNorthingGeoKeyPanel = new ProjFalseNorthingGeoKeyPanel(value);
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
    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        String string = "Gives the northing coordinate of the map projection Natural origin.";
        return string;
    }

    public JPanel getPanel() {
        return projFalseNorthingGeoKeyPanel;
    }
}
