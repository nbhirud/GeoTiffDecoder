/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.geotag;

import com.sun.media.jai.codec.TIFFField;

/**
 *
 * @author kamlesh.paunikar
 */
public class ModelPixelScaleTag {

    public final static int ModelPixelScaleTag = 33550;
    private double scaleX;
    private double scaleY;
    private double scaleZ;

    public ModelPixelScaleTag(TIFFField field) {
        double values[] = field.getAsDoubles();
        if (values.length >= 1) {
            scaleX = values[0];
        }
        if (values.length >= 2) {
            scaleY = values[1];
        }
        if (values.length >= 3) {
            scaleZ = values[2];
        }
    }

    public double getScaleX() {
        return scaleX;
    }

    public double getScaleY() {
        return scaleY;
    }

    public double getScaleZ() {
        return scaleZ;
    }
}
