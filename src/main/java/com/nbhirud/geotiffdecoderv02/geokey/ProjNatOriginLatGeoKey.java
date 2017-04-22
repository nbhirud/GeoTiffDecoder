/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import geokey.panel.ProjNatOriginLatGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoDoubleParamsTag;
import reader.geotag.GeoKey;
import reader.geotag.GeoKeyDirectoryTag;

/**
 *
 * @author KPServer
 */
public class ProjNatOriginLatGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int PROJNATORIGINLATGEOKEY = 3081;
    private boolean isAvailable = false;
    private double value;
    private ProjNatOriginLatGeoKeyPanel projNatOriginLatGeoKeyPanel;

    /**
     * 
     * @param tIFFFields
     */
    public ProjNatOriginLatGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoDoubleParamsTag geoDoubleParamsTag = iGeoTiffTag.getGeoDoubleParamsTag();
        GeoKeyDirectoryTag geoKeyDirectoryTag = iGeoTiffTag.getGeoKeyDirectoryTag();
        if (geoKeyDirectoryTag.isKeyPresent(PROJNATORIGINLATGEOKEY)) {
            isAvailable=true;
            GeoKey key = geoKeyDirectoryTag.getKey(PROJNATORIGINLATGEOKEY);
            int index = key.getValue();
            value = geoDoubleParamsTag.getValue(index);
            projNatOriginLatGeoKeyPanel = new ProjNatOriginLatGeoKeyPanel(value);
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
        String string = "Latitude of map-projection Natural origin.";
        return string;
    }

    public JPanel getPanel() {
        return projNatOriginLatGeoKeyPanel;
    }
}
