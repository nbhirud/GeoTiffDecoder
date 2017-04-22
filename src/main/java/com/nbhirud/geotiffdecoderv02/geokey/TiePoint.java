/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

/**
 *
 * @author KPServer
 */
public class TiePoint {

    private double pixelX;
    private double pixelY;
    private double pixelZ;
    private double geoX;
    private double geoY;
    private double geoZ;

    public TiePoint()
    {
        
    }
    public TiePoint(double tiePointValues[]) {
        if (tiePointValues.length>0) {
            for (int index = 0; index < tiePointValues.length; index++) {
                System.out.println("tilepoint values ["+index+"]"+tiePointValues[index]);
            }
            pixelX = tiePointValues[0];
            pixelY = tiePointValues[1];
            pixelZ = tiePointValues[2];
            geoX = tiePointValues[3];
            geoY = tiePointValues[4];
            geoZ = tiePointValues[5];
        }
    }

    public double getGeoX() {
        return geoX;
    }

    public void setGeoX(double geoX) {
        this.geoX = geoX;
    }

    public double getGeoY() {
        return geoY;
    }

    public void setGeoY(double geoY) {
        this.geoY = geoY;
    }

    public double getGeoZ() {
        return geoZ;
    }

    public void setGeoZ(double geoZ) {
        this.geoZ = geoZ;
    }

    public double getPixelX() {
        return pixelX;
    }

    public void setPixelX(double pixelX) {
        this.pixelX = pixelX;
    }

    public double getPixelY() {
        return pixelY;
    }

    public void setPixelY(double pixelY) {
        this.pixelY = pixelY;
    }

    public double getPixelZ() {
        return pixelZ;
    }

    public void setPixelZ(double pixelZ) {
        this.pixelZ = pixelZ;
    }
    @Override
    public String toString()
    {
        String string="X="+pixelX+" Y="+pixelY+" Z="+pixelZ+
                " GeoX.="+geoX+" GeoY.="+geoY+" GeoZ="+geoZ;
        return string;
    }
}
