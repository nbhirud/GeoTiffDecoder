/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import geokey.panel.ModelPixelScaleTagPanel;
import com.sun.media.jai.codec.TIFFField;
import javax.swing.JPanel;
import reader.IGeoTiffTag;

/**
 *
 * @author KPServer
 */
public class ModelPixelScaleTag extends AbstractGeoKey implements IGeoKeyInfo {

    private static final int MODELPIXELSCALETAG = 33550;
    private boolean isAvailable = false;
    private double values[];
    TIFFField tiFFField;
    private ModelPixelScaleTagPanel modelPixelScaleTagPanel;

    /**
     * 
     * @param tIFFField
     */
    public ModelPixelScaleTag(IGeoTiffTag iGeoTiffTag) {

        reader.geotag.ModelPixelScaleTag modelPixelScaleTag = iGeoTiffTag.getModelPixelScaleTag();
        values = new double[3];
        if (modelPixelScaleTag != null) {
            isAvailable=true;
            values[0] = modelPixelScaleTag.getScaleX();
            values[1] = modelPixelScaleTag.getScaleY();
            values[2] = modelPixelScaleTag.getScaleZ();
            modelPixelScaleTagPanel = new ModelPixelScaleTagPanel(values);
        }
    }

    /**
     * 
     * @return
     */
    public double[] getValue() {
        return values;
    }

    /**
     * return wheather tifffield contains the given key or not
     * @return
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        String string = "This tag may be used to specify the size of raster pixel spacing in the model space units, when the raster space can be embedded in the model space coordinate system without rotation, and consists of the following 3 values: ModelPixelScaleTag = (ScaleX, ScaleY, ScaleZ) where ScaleX and ScaleY give the horizontal and vertical spacing of raster pixels. The ScaleZ is primarily used to map the pixel value of a digital elevation model into the correct Z-scale, and so for most other purposes this value should be zero (since most model spaces are 2-D,with Z=0).";
        return string;
    }

    /**
     * 
     * @return
     */
    public JPanel getPanel() {

        return modelPixelScaleTagPanel;
    }
}
