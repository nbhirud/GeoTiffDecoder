/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import geokey.panel.GeogSemiMajorAxisGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoDoubleParamsTag;
import reader.geotag.GeoKey;
import reader.geotag.GeoKeyDirectoryTag;

/**
 *
 * @author KPServer
 */
public class GeogSemiMajorAxisGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int GEOGSEMIMAJORAXISGEOKEY = 2057;
    private boolean isAvailable = false;
    private double value;
    private GeogSemiMajorAxisGeoKeyPanel geogSemiMajorAxisGeoKeyPanel;

    /**
     * 
     * @param tIFFField
     */
    public GeogSemiMajorAxisGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoDoubleParamsTag geoDoubleParamsTag = iGeoTiffTag.getGeoDoubleParamsTag();
        GeoKeyDirectoryTag geoKeyDirectoryTag = iGeoTiffTag.getGeoKeyDirectoryTag();
        if (geoKeyDirectoryTag.isKeyPresent(GEOGSEMIMAJORAXISGEOKEY)) {
            GeoKey key = geoKeyDirectoryTag.getKey(GEOGSEMIMAJORAXISGEOKEY);
            int index = key.getValue();
            value = geoDoubleParamsTag.getValue(index);
            geogSemiMajorAxisGeoKeyPanel = new GeogSemiMajorAxisGeoKeyPanel(value);
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
        String string = "specification of user-defined Ellipsoid Semi-Major Axis";
        return string;
    }

    /**
     * 
     * @return
     */
    public JPanel getPanel() {
        return geogSemiMajorAxisGeoKeyPanel;
    }
}
