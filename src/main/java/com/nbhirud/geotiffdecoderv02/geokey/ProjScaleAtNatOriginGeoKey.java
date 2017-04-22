/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import geokey.panel.ProjScaleAtNatOriginGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoDoubleParamsTag;
import reader.geotag.GeoKey;
import reader.geotag.GeoKeyDirectoryTag;

/**
 *
 * @author KPServer
 */
public class ProjScaleAtNatOriginGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int PROJSCALEATNATORIGINGEOKEY = 3092;
    private boolean isAvailable = false;
    private double value;
    private ProjScaleAtNatOriginGeoKeyPanel projScaleAtNatOriginGeoKeyPanel;

    /**
     * 
     * @param tIFFFields
     */
    public ProjScaleAtNatOriginGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoDoubleParamsTag geoDoubleParamsTag = iGeoTiffTag.getGeoDoubleParamsTag();
        GeoKeyDirectoryTag geoKeyDirectoryTag = iGeoTiffTag.getGeoKeyDirectoryTag();
        if (geoKeyDirectoryTag.isKeyPresent(PROJSCALEATNATORIGINGEOKEY)) {
            isAvailable = true;
            GeoKey key = geoKeyDirectoryTag.getKey(PROJSCALEATNATORIGINGEOKEY);
            int index = key.getValue();
            value = geoDoubleParamsTag.getValue(index);
            projScaleAtNatOriginGeoKeyPanel = new ProjScaleAtNatOriginGeoKeyPanel(value);
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
        String string = "Scale at Natural Origin. This is a ratio, so no units are required.";
        return string;
    }

    public JPanel getPanel() {
        return projScaleAtNatOriginGeoKeyPanel;
    }
}
