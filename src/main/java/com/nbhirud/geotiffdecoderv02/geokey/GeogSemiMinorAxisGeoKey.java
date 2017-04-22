/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import geokey.panel.GeogSemiMinorAxisGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoDoubleParamsTag;
import reader.geotag.GeoKey;
import reader.geotag.GeoKeyDirectoryTag;

/**
 *
 * @author KPServer
 */
public class GeogSemiMinorAxisGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int GEOGSEMIMINORAXISGEOKEY = 2058;
    private boolean isAvailable = false;
    private double value;
    private GeogSemiMinorAxisGeoKeyPanel geogSemiMinorAxisGeoKeyPanel;

    /**
     * 
     * @param tIFFFields
     */
    public GeogSemiMinorAxisGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoDoubleParamsTag geoDoubleParamsTag = iGeoTiffTag.getGeoDoubleParamsTag();
        GeoKeyDirectoryTag geoKeyDirectoryTag = iGeoTiffTag.getGeoKeyDirectoryTag();
        if (geoKeyDirectoryTag.isKeyPresent(GEOGSEMIMINORAXISGEOKEY)) {
            GeoKey key = geoKeyDirectoryTag.getKey(GEOGSEMIMINORAXISGEOKEY);
            int index = key.getValue();
            value = geoDoubleParamsTag.getValue(index);
            geogSemiMinorAxisGeoKeyPanel = new GeogSemiMinorAxisGeoKeyPanel(value);
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
        String string = "" + value;
        return string;
    }

    /**
     * 
     */
    public JPanel getPanel() {
        return geogSemiMinorAxisGeoKeyPanel;
    }
}
