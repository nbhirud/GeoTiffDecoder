/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import com.sun.media.jai.codec.TIFFField;
import geokey.panel.GeographicTypeGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoKey;
import reader.geotag.GeoKeyDirectoryTag;

/**
 *
 * @author KPServer
 */
public class GeographicTypeGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int GEOGRAPHICTYPEGEOKEY = 2048;
    private boolean isAvailable = false;
    private boolean isUserDefined = false;
    private TIFFField tIFFField;
    private short value;
    private GeographicTypeGeoKeyPanel geographicTypeGeoKeyPanel;
    private static final int GCS_Datum_73 = 4274;
    private static final int GCS_WGS_72 = 4322;
    private static final int GCS_WGS_72BE = 4324;
    private static final int GCS_WGS_84 = 4326;
    private static final int GCSE_WGS84 = 4030;
    private static final int GCSE_Sphere = 4035;

    public GeographicTypeGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoKeyDirectoryTag geoKeyDirectoryTag = iGeoTiffTag.getGeoKeyDirectoryTag();
        if (geoKeyDirectoryTag != null) {
            if (geoKeyDirectoryTag.isKeyPresent(GEOGRAPHICTYPEGEOKEY)) {
                String string = "";
                GeoKey key = geoKeyDirectoryTag.getKey(GEOGRAPHICTYPEGEOKEY);
                switch (key.getValue()) {
                     
                    case GCS_Datum_73:
                        string = "GCS_Datum_73";
                        break;
                    case GCS_WGS_72:
                        string = "GCS_WGS_72";
                        break;
                    case GCS_WGS_72BE:
                        string = "GCS_WGS_72BE";
                        break;
                    case GCS_WGS_84:
                        string = "GCS_WGS_84";
                        break;
                    case GCSE_WGS84:
                        string = "GCSE_WGS84";
                        break;
                    case GCSE_Sphere:
                        string = "GCSE_Sphere";
                        break;
                }
                System.out.println("Value in GeographicTypeGeoKey = "+string);
                geographicTypeGeoKeyPanel = new GeographicTypeGeoKeyPanel(this);
            }
        }
    }

    /**
     * 
     * @return
     */
    public String getTagString(int value){
        String string="";
        switch (value) {
                     
                    case GCS_Datum_73:
                        string = "GCS_Datum_73";
                        break;
                    case GCS_WGS_72:
                        string = "GCS_WGS_72";
                        break;
                    case GCS_WGS_72BE:
                        string = "GCS_WGS_72BE";
                        break;
                    case GCS_WGS_84:
                        string = "GCS_WGS_84";
                        break;
                    case GCSE_WGS84:
                        string = "GCSE_WGS84";
                        break;
                    case GCSE_Sphere:
                        string = "GCSE_Sphere";
                        break;
                }
        return string; 
    }
    public boolean isValid() {
        boolean valid = false;
        int tiffFieldTag = tIFFField.getTag();
        /* Ranges in which the tag should be 
         * Geodetic datum using Greenwich PM have codes equal to the corresponding Datum code - 2000.
         * the numeric code is equal to the code of the correspoding EPSG ellipsoid, minus 3000.
         */
        if ((tiffFieldTag >= 4201 && tiffFieldTag <= 4326) ||
                (tiffFieldTag >= 4801 && tiffFieldTag <= 4813) ||
                (tiffFieldTag >= 4901 && tiffFieldTag <= 4902) ||
                (tiffFieldTag >= 4001 && tiffFieldTag <= 4035)) {
            valid = true;
        }
        return valid;
    }

    /**
     * 
     * @return
     */
    public boolean isIsAvailable() {
        return isAvailable;
    }

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
    public short getValue() {
        return value;
    }

    @Override
    public String toString() {
        String string = null;
        int tiffFieldTag = tIFFField.getTag();
        if (isUserDefined()) {
            string = "user defined key";
        } else {
            if (isValid()) {
                switch (tiffFieldTag) {
                    case GCS_Datum_73:
                        string = "GCS_Datum_73";
                        break;
                    case GCS_WGS_72:
                        string = "GCS_WGS_72";
                        break;
                    case GCS_WGS_72BE:
                        string = "GCS_WGS_72BE";
                        break;
                    case GCS_WGS_84:
                        string = "GCS_WGS_84";
                        break;
                    case GCSE_WGS84:
                        string = "GCSE_WGS84";
                        break;
                    case GCSE_Sphere:
                        string = "GCSE_Sphere";
                        break;
                    default:
                        string = "other key";
                }
            } else {

                string = "invalid key";

            }
        }
        string += "This key may be used to specify the code for the geographic coordinate system used to map lat-long to a specific ellipsoid over the earth.\nGeoKey Requirements for User-Defined geographic CS:\nGeogCitationGeoKey\nGeogGeodeticDatumGeoKey\nGeogAngularUnitsGeoKey (if not degrees)\nGeogPrimeMeridianGeoKey (if not Greenwich)";
        return string;
    }

    /**
     * 
     * @return
     */
    public JPanel getPanel() {
        return geographicTypeGeoKeyPanel;
    }
}
