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
public class GeoAsciiParamsTag {

    public final static int GeoAsciiParamsTag = 34737;
    private String values[];
    private String value;

    public GeoAsciiParamsTag(TIFFField field) {
        int index = 0;
        value = field.getAsString(index);
        System.out.println("Value="+value);
        values = value.split("\\|");
    
    }

    public String getValue(int index) {
        if (index < values.length) {
            return values[index];
        }
        return null;
    }
    public int getValueCount()
    {
        return values.length;
    }
    public String getValue(int startIndex,int nChars)
    {
        if(value!=null)
        {
           String partValue=value.substring(startIndex,startIndex+nChars);
           return partValue;
        }
        return null;
    }
}
