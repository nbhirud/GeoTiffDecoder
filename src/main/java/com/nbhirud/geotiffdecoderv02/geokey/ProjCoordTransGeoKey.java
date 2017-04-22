/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import com.sun.media.jai.codec.TIFFField;
import geokey.panel.ProjCoordTransGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoKey;
import reader.geotag.GeoKeyDirectoryTag;

/**
 *
 * @author KPServer
 */
public class ProjCoordTransGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int PROJCOORDTRANSGEOKEY = 3075;
    private boolean isAvailable = false;
    private boolean isUserDefined = false;
    private TIFFField tIFFField;
    private short value;
    private ProjCoordTransGeoKeyPanel projCoordTransGeoKeyPanel;
    private final short CT_TransverseMercator = 1;
    private final short CT_TransvMercator_Modified_Alaska = 2;
    private final short CT_ObliqueMercator = 3;
    private final short CT_ObliqueMercator_Laborde = 4;
    private final short CT_ObliqueMercator_Rosenmund = 5;
    private final short CT_ObliqueMercator_Spherical = 6;
    private final short CT_Mercator = 7;
    private final short CT_LambertConfConic_2SP = 8;
    private final short CT_LambertConfConic_Helmert = 9;
    private final short CT_LambertAzimEqualArea = 10;
    private final short CT_AlbersEqualArea = 11;
    private final short CT_AzimuthalEquidistant = 12;
    private final short CT_EquidistantConic = 13;
    private final short CT_Stereographic = 14;
    private final short CT_PolarStereographic = 15;
    private final short CT_ObliqueStereographic = 16;
    private final short CT_Equirectangular = 17;
    private final short CT_CassiniSoldner = 18;
    private final short CT_Gnomonic = 19;
    private final short CT_MillerCylindrical = 20;
    private final short CT_Orthographic = 21;
    private final short CT_Polyconic = 22;
    private final short CT_Robinson = 23;
    private final short CT_Sinusoidal = 24;
    private final short CT_VanDerGrinten = 25;
    private final short CT_NewZealandMapGrid = 26;
    private final short CT_TransvMercator_SouthOriented = 27;

    public ProjCoordTransGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoKeyDirectoryTag geoKeyDirectoryTag = iGeoTiffTag.getGeoKeyDirectoryTag();
        if (geoKeyDirectoryTag.isKeyPresent(PROJCOORDTRANSGEOKEY)) {
            GeoKey key = geoKeyDirectoryTag.getKey(PROJCOORDTRANSGEOKEY);
            value = (short) key.getValue();
            String string = "";
            switch (value) {

                case CT_TransverseMercator:
                    string = "CT_TransverseMercator";
                    break;
                case 2:string = "CT_TransvMercator_Modified_Alaska";
                    break;
                case 3:string = "CT_ObliqueMercator";
                    break;
                case 4:string = "CT_ObliqueMercator_Laborde";
                    break;
                case 5:string = "CT_ObliqueMercator_Rosenmund";
                    break;
                case 6:string = "CT_ObliqueMercator_Spherical";
                    break;
                case CT_Mercator:string = "CT_Mercator";
                    break;
                case 8:string = "CT_LambertConfConic_2SP";
                    break;
                case 9:string = "CT_LambertConfConic_Helmert";
                    break;
                case 10:string = "CT_LambertAzimEqualArea";
                    break;
                case 11:string = "CT_AlbersEqualArea";
                    break;
                case 12:string = "CT_AzimuthalEquidistant";
                    break;
                case CT_EquidistantConic:string = "CT_EquidistantConic";
                    break;
                case CT_Stereographic:string = "CT_Stereographic";
                    break;
                case 15:string = "CT_PolarStereographic";
                    break;
                case 16:string = "CT_ObliqueStereographic";
                    break;
                case 17:string = "CT_Equirectangular";
                    break;
                case 18:string = "CT_CassiniSoldner";
                    break;
                case 19:string = "CT_Gnomonic";
                    break;
                case 20:string = "CT_MillerCylindrical";
                    break;
                case 21:string = "CT_Orthographic";
                    break;
                case 22:string = "CT_Polyconic";
                    break;
                case 23:string = "CT_Robinson";
                    break;
                case CT_Sinusoidal:string = "CT_Sinusoidal";
                    break;
                case 25:string = "CT_VanDerGrinten";
                    break;
                case 26:string = "CT_NewZealandMapGrid";
                    break;
                case CT_TransvMercator_SouthOriented:string = "CT_TransvMercator_SouthOriented";
                    break;
            }
            projCoordTransGeoKeyPanel = new ProjCoordTransGeoKeyPanel(string);
        }
//        super(tIFFFields, PROJCOORDTRANSGEOKEY);
//        tIFFField = getTIFFField();
//        if(tIFFField!=null){
//            isAvailable=true;
//            short[] temp=tIFFField.getAsShorts();
//            value=temp[0];
//            projCoordTransGeoKeyPanel= new ProjCoordTransGeoKeyPanel(value);
//        }

    }

    @Override
    public String toString() {
        String string = "";
        if (isUserDefined()) {
            string = "userdefined key";
        } else {
            // concatenate the respective transfrmation method
        }
        string += "Allows specification of the coordinate transformation method used.\nNote: this does not include the definition of the corresponding Geographic Coordinate System to which the projected CS is related; only the transformation method is defined here.";
        return string;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public short getValue() {
        return value;
    }

    public JPanel getPanel() {
        return projCoordTransGeoKeyPanel;
    }

    private boolean isUserDefined() {
        if (tIFFField.getTag() == 32767) {
            isUserDefined = true;
        }
        return isUserDefined;
    }
}
