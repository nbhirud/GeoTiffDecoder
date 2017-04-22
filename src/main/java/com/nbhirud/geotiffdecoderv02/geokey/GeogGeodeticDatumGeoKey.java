/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import com.sun.media.jai.codec.TIFFField;
import geokey.panel.GeogGeodeticDatumGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoKey;
import reader.geotag.GeoKeyDirectoryTag;

/**
 *
 * @author KPServer
 */
public class GeogGeodeticDatumGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int GEOGGEODETICDATUMGEOKEY = 2050;
    private boolean isAvailable = false;
    private boolean isUserDefined = false;
    private TIFFField tIFFField;
    private short value;
    private GeogGeodeticDatumGeoKeyPanel geogGeodeticDatumGeoKeyPanel;
    private static final int Datum_European_Datum1987 = 6231;
    private static final int Datum_European_Reference_System_1989 = 6258;
    private static final int Datum_WGS72 = 6322;
    private static final int Datum_WGS72_Transit_Broadcast_Francaise = 6324;
    private static final int Datum_WGS84 = 6326;
    private static final int DatumE_WGS84 = 6030;
    private static final int DatumE_Sphere = 6035;

    public GeogGeodeticDatumGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoKeyDirectoryTag geoKeyDirectoryTag = iGeoTiffTag.getGeoKeyDirectoryTag();
            if(geoKeyDirectoryTag.isKeyPresent(GEOGGEODETICDATUMGEOKEY)){
                GeoKey key = geoKeyDirectoryTag.getKey(GEOGGEODETICDATUMGEOKEY);
                value = (short) key.getValue();
                System.out.println("Value = "+value);
                String string="";
                switch (value) {
                    case Datum_European_Datum1987:
                        string = "Datum_European_Datum1987";
                        break;
                    case Datum_European_Reference_System_1989:
                        string = "Datum_European_Reference_System_1989";
                        break;
                    case Datum_WGS72:
                        string = "Datum_WGS72";
                        break;
                    case Datum_WGS72_Transit_Broadcast_Francaise:
                        string = "Datum_WGS72_Transit_Broadcast_Francaise";
                        break;
                    case Datum_WGS84:
                        string = "Datum_WGS84";
                        break;
                    case DatumE_WGS84:
                        string = "DatumE_WGS84";
                        break;
                    case DatumE_Sphere:
                        string = "DatumE_Sphere";
                        break;
                    default:
                        string = "other key";
                }
                geogGeodeticDatumGeoKeyPanel = new GeogGeodeticDatumGeoKeyPanel(string);
            }
}

    /**
     * 
     * @return
     */
    public boolean isIsAvailable() {
        return isAvailable;
    }

    /**
     * 
     * @return
     */
    public short getValues() {
        return value;
    }

    /**
     * 
     * @return
     */
    private boolean isUserDefined() {

        if (tIFFField.getTag() == 32767) {
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
        int tiffFieldTag = tIFFField.getTag();
        /* Ranges in which the tag should be 
         * Ellipsoid-Only Datum: 6001 - 6035 the numeric code is equal to the corresponding ellipsoid code, minus 1000.
         */
        if ((tiffFieldTag >= 6201 && tiffFieldTag <= 6326) || (tiffFieldTag >= 6901 && tiffFieldTag <= 6902) || (tiffFieldTag >= 6001 && tiffFieldTag <= 6035)) {
            valid = true;
        }
        return valid;
    }

    @Override
    public String toString() {
        String string = "";
        int tiffFieldTag = tIFFField.getTag();
        if (isUserDefined()) {
            string = "user defined key";
        } else {
            if (isValid()) {
                switch (tiffFieldTag) {
                    case Datum_European_Datum1987:
                        string = "Datum_European_Datum1987";
                        break;
                    case Datum_European_Reference_System_1989:
                        string = "Datum_European_Reference_System_1989";
                        break;
                    case Datum_WGS72:
                        string = "Datum_WGS72";
                        break;
                    case Datum_WGS72_Transit_Broadcast_Francaise:
                        string = "Datum_WGS72_Transit_Broadcast_Francaise";
                        break;
                    case Datum_WGS84:
                        string = "Datum_WGS84";
                        break;
                    case DatumE_WGS84:
                        string = "DatumE_WGS84";
                        break;
                    case DatumE_Sphere:
                        string = "DatumE_Sphere";
                        break;
                    default:
                        string = "other key";
                }
            } else {

                string = "invalid key";

            }
        }
        string += "This key may be used to specify the horizontal datum, defining the size, position and orientation of the reference ellipsoid used in user-defined geographic coordinate systems.GeoKey Requirements for User-Defined Horizontal Datum:GeogCitationGeoKey, GeogEllipsoidGeoKey";
        return string;
    }

    public JPanel getPanel() {
        return geogGeodeticDatumGeoKeyPanel;
    }
}
