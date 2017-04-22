/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import geokey.panel.ProjCenterLongGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoDoubleParamsTag;
import reader.geotag.GeoKey;
import reader.geotag.GeoKeyDirectoryTag;

/**
 *
 * @author KPServer
 */
public class ProjCenterLongGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int PROJCENTERLONGGEOKEY = 3088;
    private boolean isAvailable = false;
    private double value;
    private ProjCenterLongGeoKeyPanel projCenterLongGeoKeyPanel;

    /**
     * 
     * @param tIFFFields
     */
    public ProjCenterLongGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoDoubleParamsTag geoDoubleParamsTag = iGeoTiffTag.getGeoDoubleParamsTag();
        GeoKeyDirectoryTag geoKeyDirectoryTag = iGeoTiffTag.getGeoKeyDirectoryTag();
        if (geoKeyDirectoryTag.isKeyPresent(PROJCENTERLONGGEOKEY)) {
            isAvailable = true;
            GeoKey key = geoKeyDirectoryTag.getKey(PROJCENTERLONGGEOKEY);
            int index = key.getValue();
            value = geoDoubleParamsTag.getValue(index);
            projCenterLongGeoKeyPanel = new ProjCenterLongGeoKeyPanel(value);
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
        String string = "Type = DOUBLE\nUnits: GeogAngularUnit\nLongitude of Center of Projection. Note that this is not necessarily the origin of the projection.";
        return string;
    }

    public JPanel getPanel() {
        return projCenterLongGeoKeyPanel;
    }
}
