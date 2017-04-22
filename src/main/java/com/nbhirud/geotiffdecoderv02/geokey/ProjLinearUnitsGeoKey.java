/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import com.sun.media.jai.codec.TIFFField;
import geokey.panel.ProjLinearUnitsGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;

/**
 *
 * @author KPServer
 */
public class ProjLinearUnitsGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int PROJLINEARUNITSGEOKEY = 3076;
    private boolean isUserDefined=false;
    private boolean isAvailable = false;
    private TIFFField tIFFField;
    private short value;
    private ProjLinearUnitsGeoKeyPanel projLinearUnitsGeoKeyPanel;
    private static final int Linear_Meter = 9001;
    private static final int Linear_Foot = 9002;
    private static final int Linear_Mile_International_Nautical = 9015;

    public ProjLinearUnitsGeoKey(IGeoTiffTag iGeoTiffTag) {

//        super(tIFFFields, PROJLINEARUNITSGEOKEY);
//        tIFFField = getTIFFField();
//        if (tIFFField != null) {
//            isAvailable = true;
//            short temp[] = tIFFField.getAsShorts();
//            value = temp[0];
//            String type = "";
//        switch (tIFFField.getTag()) {
//            case Linear_Foot:
//                type = "Linear_Foot";
//                break;
//            case Linear_Meter:
//                type = "Linear_Meter";
//                break;
//            case Linear_Mile_International_Nautical:
//                type = "Linear_Mile_International_Nautical";
//                break;
//        }
//        projLinearUnitsGeoKeyPanel = new ProjLinearUnitsGeoKeyPanel(type);
//        }
        
    }

    public boolean isValid() {
        boolean valid = false;
        int tag = tIFFField.getTag();
        if ((tag >= 9000 && tag <= 9099)) {
            valid = true;
        }
        return valid;
    }

    private boolean isUserDefined() {
        if (tIFFField.getTag() == 32767) {
            isUserDefined = true;
        }
        return isUserDefined;
    }

    @Override
    public String toString() {
        String string = "";
        if (isUserDefined()) {
            string = "user defined key";
        } else {
            if (isValid()) {
                switch (tIFFField.getTag()) {
                    case Linear_Foot:
                        string = "Linear_Foot";
                        break;
                    case Linear_Meter:
                        string = "Linear_Meter";
                        break;
                    case Linear_Mile_International_Nautical:
                        string = "Linear_Mile_International_Nautical";
                        break;
                }
            } else {
                string = "invalid key";
            }
        }
        string += "\nDefines linear units used by projection.";
        return string;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public short getValue() {
        return value;
    }

    /**
     * 
     * @return
     */
    public JPanel getPanel() {
        return projLinearUnitsGeoKeyPanel;
    }
}
