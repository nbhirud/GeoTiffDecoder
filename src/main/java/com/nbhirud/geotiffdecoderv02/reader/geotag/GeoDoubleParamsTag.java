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
public class GeoDoubleParamsTag {

    public final static int GeoDoubleParamsTag = 34736;

    private double values[];
    
    public GeoDoubleParamsTag(TIFFField field) {
        
        values=field.getAsDoubles();
    }
    
    public Double getValue(int index)
    {
        if(index<values.length)
        {
            return values[index];
        }
        return null;
    }
    public int getValueCount()
    {
        return values.length;
    }
    
}
