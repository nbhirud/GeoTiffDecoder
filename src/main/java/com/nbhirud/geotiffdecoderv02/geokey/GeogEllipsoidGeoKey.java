/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import geokey.panel.GeogEllipsoidGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoKey;
import reader.geotag.GeoKeyDirectoryTag;

/**
 *
 * @author KPServer
 */
public class GeogEllipsoidGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int GEOGELLIPSOIDGEOKEY = 2056;
    private boolean isAvailable = false;
    private boolean isUserDefined = false;
    private int tag;
    private short value;
    private GeogEllipsoidGeoKeyPanel geogEllipsoidGeoKeyPanel;
    private static final int Ellipse_WGS_84 = 7030;
    private static final int Ellipse_Sphere = 7035;

    public GeogEllipsoidGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoKeyDirectoryTag geoKeyDirectoryTag = iGeoTiffTag.getGeoKeyDirectoryTag();
            if(geoKeyDirectoryTag.isKeyPresent(GEOGELLIPSOIDGEOKEY)){
                isAvailable=true;
                System.out.println("geogEllipsoidGeoKey is present");
                GeoKey key = geoKeyDirectoryTag.getKey(GEOGELLIPSOIDGEOKEY);
                value = (short) key.getValue();
                tag= key.getTag();
                System.out.println("value  "+value);
                geogEllipsoidGeoKeyPanel = new GeogEllipsoidGeoKeyPanel(value);
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
    public short getValues() {
        return value;
    }

    private boolean isUserDefined() {

        if (tag== 32767) {
            isUserDefined = true;
        }
        return isUserDefined;
    }

    /**
     * 
     * @return
     */
    public boolean isValid() {
        boolean valid = false;
        /* Ranges in which the tag should be 
         */
        if ((tag >= 7030 && tag <= 7035)) {
            valid = true;
        }
        return valid;
    }

    /**
     * 
     * @return
     */
    @Override
    public String toString() {
        String string = null;
        if (isUserDefined()) {
            string = "user defined key";
        } else if (isValid()) {
            switch (value) {
                case Ellipse_WGS_84:
                    string = "Ellipse_WGS_84";
                    break;
                case Ellipse_Sphere:
                    string = "Ellipse_Sphere";
                    break;

                default:
                    string = "other key";
            }
        } else {

            string = "invalid key";

        }
        string += "Type = SHORT (code)\nThis key may be used to specify the coded ellipsoid used in the\ngeodetic datum of the Geographic Coordinate System.\nGeoKey Requirements for User-Defined Ellipsoid:\nGeogCitationGeoKey\n[GeogSemiMajorAxisGeoKey,[GeogSemiMinorAxisGeoKey | GeogInvFlatteningGeoKey]]";

        return string;
    }

    public JPanel getPanel() {
        return geogEllipsoidGeoKeyPanel;
    }
}
