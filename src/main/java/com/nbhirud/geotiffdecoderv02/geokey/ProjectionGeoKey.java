/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import com.sun.media.jai.codec.TIFFField;
import geokey.panel.ProjectionGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;

/**
 *
 * @author KPServer
 */
public class ProjectionGeoKey extends AbstractGeoKey implements IGeoKeyInfo{

    private static final int PROJECTIONGEOKEY = 3074;
    private boolean isAvailable = false;
    private TIFFField tIFFField;
    private short values[];
    private ProjectionGeoKeyPanel projectionGeoKeyPanel;

    public ProjectionGeoKey(IGeoTiffTag iGeoTiffTag) {

//        super(tIFFFields, PROJECTIONGEOKEY);
//        tIFFField = getTIFFField();
//        if(tIFFField!=null){
//            isAvailable=true;
//           values = tIFFField.getAsShorts();
//           projectionGeoKeyPanel=new ProjectionGeoKeyPanel();
//        }
        
    }

    /**
     * 
     * @return
     */
    public boolean isValid() {
        boolean valid = false;
        int tag = tIFFField.getTag();
        if ((tag >= 1 && tag <= 9999) || (tag >= 10000 && tag <= 19999)) {
            valid = true;
        }
        return valid;
    }
    
    /**
     * 
     * @return
     */
    private boolean isUserDefined() {
        boolean isUserDefined = false;
        if (isValid()) {
            if (tIFFField.getTag() == 32767) {
                isUserDefined = true;
            }
        }
        return isUserDefined;
    }
    @Override
    public String toString() {
        String string="";
        int tag=tIFFField.getTag();
        if(tag==32767){
            string="userdefined key";
        }else{
            
        }
        string += "Allows specification of the coordinate transformation method and projection zone parameters.\nNote : when associated with an appropriate Geographic Coordinate System, this forms a Projected Coordinate System.";
        return string;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public short[] getValues() {
        return values;
    }

    
    public JPanel getPanel() {
        return projectionGeoKeyPanel;
    }
}
