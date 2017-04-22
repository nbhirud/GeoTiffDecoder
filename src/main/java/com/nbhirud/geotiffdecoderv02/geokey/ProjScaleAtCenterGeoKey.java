/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import geokey.panel.ProjScaleAtCenterGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoDoubleParamsTag;
import reader.geotag.GeoKey;
import reader.geotag.GeoKeyDirectoryTag;

/**
 *
 * @author KPServer
 */
public class ProjScaleAtCenterGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int PROJSCALEATCENTERGEOKEY = 3093;
    private boolean isAvailable = false;
    private double value;
    private ProjScaleAtCenterGeoKeyPanel projScaleAtCenterGeoKeyPanel;

    /**
     * 
     * @param tIFFFields
     */
    public ProjScaleAtCenterGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoDoubleParamsTag geoDoubleParamsTag = iGeoTiffTag.getGeoDoubleParamsTag();
        GeoKeyDirectoryTag geoKeyDirectoryTag = iGeoTiffTag.getGeoKeyDirectoryTag();
        if (geoKeyDirectoryTag.isKeyPresent(PROJSCALEATCENTERGEOKEY)) {
            isAvailable = true;
            GeoKey key = geoKeyDirectoryTag.getKey(PROJSCALEATCENTERGEOKEY);
            int index = key.getValue();
            value = geoDoubleParamsTag.getValue(index);
            projScaleAtCenterGeoKeyPanel = new ProjScaleAtCenterGeoKeyPanel(value);
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
        String string = "Scale at Center. This is a ratio, so no units are required.";
        return string;
    }

    public JPanel getPanel() {
        return projScaleAtCenterGeoKeyPanel;
    }
}
