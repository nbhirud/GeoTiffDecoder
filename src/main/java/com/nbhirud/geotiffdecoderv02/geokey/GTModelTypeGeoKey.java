/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import com.sun.media.jai.codec.TIFFField;
import geokey.panel.GTModelTypeGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoDoubleParamsTag;
import reader.geotag.GeoKey;
import reader.geotag.GeoKeyDirectoryTag;

/**
 *
 * @author KPServer
 */
public class GTModelTypeGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int GTMODELTYPEGEOKEY = 1024;
    private boolean isAvailable = false;
    private boolean isUserDefined = false;
    private TIFFField tiFFField;
    private short value;
    final public short ModelTypeProjected = 1;
    final public short ModelTypeGeographic = 2;
    final public short ModelTypeGeocentric = 3;
    private GTModelTypeGeoKeyPanel gTModelTypeGeoKeyPanel;

    /**
     * 
     * @param tIFFField
     */
    public GTModelTypeGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoKeyDirectoryTag geoKeyDirectoryTag = iGeoTiffTag.getGeoKeyDirectoryTag();
        if (geoKeyDirectoryTag.isKeyPresent(GTMODELTYPEGEOKEY)) {
            isAvailable = true;
            GeoKey key = geoKeyDirectoryTag.getKey(GTMODELTYPEGEOKEY);
            value = (short) key.getValue();
            String type = "";
            switch (value) {
                case ModelTypeProjected:
                    type = "ModelTypeProjected";
                    break;
                case ModelTypeGeographic:
                    type = "ModelTypeGeographic";
                    break;
                case ModelTypeGeocentric:
                    type = "ModelTypeGeocentric";
                    break;
            }
            gTModelTypeGeoKeyPanel = new GTModelTypeGeoKeyPanel(type);
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
    public short getValue() {
        return value;
    }

    /**
     * 
     * @return
     */
    public boolean isUserDefined() {
        if (tiFFField.getTag() == 32767) {
            isUserDefined = true;
        }
        return isUserDefined;
    }

    /**
     * 
     * @return
     */
    @Override
    public String toString() {
        String string = "";
        if (isUserDefined()) {
            string = "user defined key";
        }
        switch (value) {
            case ModelTypeProjected:
                string = "ModelTypeProjected";
                break;
            case ModelTypeGeographic:
                string = "ModelTypeGeographic";
                break;
            case ModelTypeGeocentric:
                string = "ModelTypeGeocentric";
                break;
        }
        string += "\ngeneral type of model Coordinate system used:Projection Coordinate System or Geographic latitude-longitude System or Geocentric (X,Y,Z) Coordinate System";
        return string;
    }

    public JPanel getPanel() {
        return gTModelTypeGeoKeyPanel;
    }
}
