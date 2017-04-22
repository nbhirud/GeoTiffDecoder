/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import geokey.panel.GTRasterTypeGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoKey;
import reader.geotag.GeoKeyDirectoryTag;

/**
 *
 * @author KPServer
 */
public class GTRasterTypeGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int GRASTERTYPEGEOKEY = 1025;
    private boolean isAvailable = false;
    private short value;
    final public short RasterPixelIsArea = 1;
    final public short RasterPixelIsPoint = 2;
    private GTRasterTypeGeoKeyPanel gTRasterTypeGeoKeyPanel;

    public GTRasterTypeGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoKeyDirectoryTag geoKeyDirectoryTag = iGeoTiffTag.getGeoKeyDirectoryTag();
        if (geoKeyDirectoryTag.isKeyPresent(GRASTERTYPEGEOKEY)) {
            GeoKey key = geoKeyDirectoryTag.getKey(GRASTERTYPEGEOKEY);
            value = (short) key.getValue();
            switch (value) {
                case RasterPixelIsArea:
                    gTRasterTypeGeoKeyPanel = new GTRasterTypeGeoKeyPanel("RasterPixelIsArea");
                    break;
                case RasterPixelIsPoint:
                    gTRasterTypeGeoKeyPanel = new GTRasterTypeGeoKeyPanel("RasterPixelIsPoint");
                    break;
            }
        }
    }

    /**
     * 
     * @return
     */
    public short getValue() {
        return value;
    }

    /**
     * return wheather tifffield contains the given key or not
     * @return
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        String string = "";
        string = "Raster Space coordinate system used :RasterPixelIsArea or RasterPixelIsPoint";
        return string;
    }

    public JPanel getPanel() {
        return gTRasterTypeGeoKeyPanel;
    }
}
