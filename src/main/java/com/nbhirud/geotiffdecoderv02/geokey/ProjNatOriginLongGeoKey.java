/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import com.sun.media.jai.codec.TIFFField;
import geokey.panel.ProjNatOriginLongGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoDoubleParamsTag;
import reader.geotag.GeoKey;
import reader.geotag.GeoKeyDirectoryTag;

/**
 *
 * @author KPServer
 */
public class ProjNatOriginLongGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int PROJNATORIGINLONGGEOKEY = 3080;
    private boolean isAvailable = false;
    private double value;
    private ProjNatOriginLongGeoKeyPanel projNatOriginLongGeoKeyPanel;

    /**
     * 
     * @param tIFFFields
     */
    public ProjNatOriginLongGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoDoubleParamsTag geoDoubleParamsTag = iGeoTiffTag.getGeoDoubleParamsTag();
        GeoKeyDirectoryTag geoKeyDirectoryTag = iGeoTiffTag.getGeoKeyDirectoryTag();
        if (geoKeyDirectoryTag.isKeyPresent(PROJNATORIGINLONGGEOKEY)) {
            isAvailable = true;
            GeoKey key = geoKeyDirectoryTag.getKey(PROJNATORIGINLONGGEOKEY);
            int index = key.getValue();
            value = geoDoubleParamsTag.getValue(index);
            projNatOriginLongGeoKeyPanel = new ProjNatOriginLongGeoKeyPanel(value);
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
        String string = "Longitude of map-projection Natural origin.";
        return string;
    }

    /**
     * 
     * @return
     */
    public JPanel getPanel() {
        return projNatOriginLongGeoKeyPanel;
    }
}
