/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import com.sun.media.jai.codec.TIFFField;
import geokey.panel.ProjFalseEastingGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoDoubleParamsTag;
import reader.geotag.GeoKey;
import reader.geotag.GeoKeyDirectoryTag;

/**
 *
 * @author KPServer
 */
public class ProjFalseEastingGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int PROJFALSEEASTINGGEOKEY = 3082;
    private boolean isAvailable = false;
    private double value;
    private ProjFalseEastingGeoKeyPanel projFalseEastingGeoKeyPanel;

    /**
     * 
     * @param tIFFFields
     */
    public ProjFalseEastingGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoDoubleParamsTag geoDoubleParamsTag = iGeoTiffTag.getGeoDoubleParamsTag();
        GeoKeyDirectoryTag geoKeyDirectoryTag = iGeoTiffTag.getGeoKeyDirectoryTag();
        if (geoKeyDirectoryTag.isKeyPresent(PROJFALSEEASTINGGEOKEY)) {
            System.out.println("PROJFALSEEASTINGGEOKEY present");
            isAvailable= true;
            GeoKey key = geoKeyDirectoryTag.getKey(PROJFALSEEASTINGGEOKEY);
            int index = key.getValue();
            value = geoDoubleParamsTag.getValue(index);
            projFalseEastingGeoKeyPanel = new ProjFalseEastingGeoKeyPanel(value);
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
        String string = "Gives the easting coordinate of the map projection Natural origin.";
        return string;
    }

    public JPanel getPanel() {
        return projFalseEastingGeoKeyPanel;
    }
}
