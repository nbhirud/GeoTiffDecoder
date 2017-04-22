/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import com.sun.media.jai.codec.TIFFField;
import geokey.panel.ProjectedCSTypeGeoKeyPanel;
import javax.swing.JPanel;
import reader.IGeoTiffTag;
import reader.geotag.GeoKey;
import reader.geotag.GeoKeyDirectoryTag;

/**
 *
 * @author KPServer
 */
public class ProjectedCSTypeGeoKey extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int PROJECTEDCSTYPEGEOKEY = 3072;
    private boolean isAvailable = false;
    private   boolean isUserDefined = false;
    private short value;
    private int tag;
    private ProjectedCSTypeGeoKeyPanel projectedCSTypeGeoKeyPanel;

    public ProjectedCSTypeGeoKey(IGeoTiffTag iGeoTiffTag) {

        GeoKeyDirectoryTag geoKeyDirectoryTag = iGeoTiffTag.getGeoKeyDirectoryTag();
        if(geoKeyDirectoryTag.isKeyPresent(PROJECTEDCSTYPEGEOKEY)){
            GeoKey key = geoKeyDirectoryTag.getKey(PROJECTEDCSTYPEGEOKEY);
            tag=key.getTag();
            value = (short) key.getValue();
            projectedCSTypeGeoKeyPanel= new ProjectedCSTypeGeoKeyPanel(getZoneInformation());
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public short getValues() {
        return value;
    }

    /**
     * Ranges in which the tag should be 
     * 1. For PCS utilising GeogCS with code in range 4201 through 4321 i.e. geodetic datum code 6201 through 6319): As far as is possible
     *    the PCS code will be of the format gggzz where ggg is (geodetic datum code -2000) and zz is zone.
     * 2. For PCS utilising GeogCS with code out of range 4201 through 4321
     *    (i.e. geodetic datum code 6201 through 6319). PCS code 20xxx where xxx is a sequential number.
     * 3. Other:
     * WGS72 / UTM northern hemisphere: 322zz where zz is UTM zone number
     * WGS72 / UTM southern hemisphere: 323zz where zz is UTM zone number
     * WGS72BE / UTM northern hemisphere: 324zz where zz is UTM zone number
     * WGS72BE / UTM southern hemisphere: 325zz where zz is UTM zone number
     * WGS84 / UTM northern hemisphere: 326zz where zz is UTM zone number
     * WGS84 / UTM southern hemisphere: 327zz where zz is UTM zone number
     * US State Plane (NAD27): 267xx/320xx
     * US State Plane (NAD83): 269xx/321xx
     * @return
     */
    public boolean isValid() {
        boolean valid = false;
               if ((tag >= 1 && tag <= 1000) || (tag >= 20000 && tag <= 32760)) {
            valid = true;
        }
        return valid;
    }

    private boolean isUserDefined() {
      
        if (tag == 32767) {
            isUserDefined = true;
        }
        return isUserDefined;
    }

    @Override
    public String toString() {
        String string = "";
        if (isUserDefined()) {
            string = "user-defined type";
        } else {
            if (isValid()) {
                ZoneInformation zi = getZoneInformation();
                string += zi.getTagName();
                string += " Zone Name:" + zi.getZoneName();
                string = string + " Zone number:" + zi.getZoneNumber();
            }
            else{
                string = "invalid key";
            }
        }
        string += "\nThis code is provided to specify the projected coordinate system.\nGeoKey requirements for 'user-defined' PCS families:\nPCSCitationGeoKey\nProjectionGeoKey\nGeographicTypeGeoKey";
        return string;
    }

    private ZoneInformation getZoneInformation() {
      String tagName = null, zoneName = null;
        int zoneNumber = 0;
        if (tag >= 32200 && tag <= 32299) {

            tagName = "WGS72";
            zoneNumber = tag % 100;
            zoneName = "UTM northern hemisphere";
        } else {
            if (tag >= 32300 && tag <= 32399) {
                tagName = "WGS72";
                zoneNumber = tag % 100;
                zoneName = "UTM southern hemisphere:";
            } else {
                if (tag >= 32400 && tag <= 32499) {
                    tagName = "WGS72BE";
                    zoneNumber = tag % 100;
                    zoneName = "UTM northern hemisphere";
                } else {
                    if (tag >= 32500 && tag <= 32599) {
                        tagName = "WGS72BE";
                        zoneNumber = tag % 100;
                        zoneName = "UTM southern hemisphere";
                    } else {
                        if (tag >= 32600 && tag <= 32699) {
                            tagName = "WGS84";
                            zoneNumber = tag % 100;
                            zoneName = "UTM northern hemisphere";
                        } else {
                            if (tag >= 32700 && tag <= 32799) {
                                tagName = "WGS84";
                                zoneNumber = tag % 100;
                                zoneName = "UTM southern hemisphere";
                            }
                        }
                    }
                }
            }
        }
        return new ZoneInformation(tagName, zoneNumber, zoneName);
    }

    public JPanel getPanel() {
        return projectedCSTypeGeoKeyPanel;
    }
}
