/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package geokey;

/**
 *
 * @author KPServer
 */
public class ZoneInformation {
    private String tagName;
    private int zoneNumber;
    private String zoneName;

    public ZoneInformation(String tagname,int zoneNumber,String zoneName) {
        
        this.tagName=tagname;
        this.zoneNumber= zoneNumber;
        this.zoneName= zoneName;
    }

    
    public String getTagName() {
        return tagName;
    }

    public String getZoneName() {
        return zoneName;
    }

    public int getZoneNumber() {
        return zoneNumber;
    }
    

}
