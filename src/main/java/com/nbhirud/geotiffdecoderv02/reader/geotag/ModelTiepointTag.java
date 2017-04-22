/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.geotag;

import com.sun.media.jai.codec.TIFFField;
import geokey.TiePoint;
import java.util.ArrayList;

/**
 *
 * @author kamlesh.paunikar
 */
public class ModelTiepointTag {

    public final static int ModelTiepointTag = 33922;

    private ArrayList <TiePoint> tiePointList=new ArrayList<TiePoint>();

    public ArrayList<TiePoint> getTiePointList() {
        return tiePointList;
    }
    
    public ModelTiepointTag(TIFFField field) {
        double values[]=field.getAsDoubles();
        for(int index=0;index<values.length;index+=6)
        {
            TiePoint tiePoint=new TiePoint();
            tiePoint.setPixelX(values[index]);
            tiePoint.setPixelY(values[index+1]);
            tiePoint.setPixelZ(values[index+2]);
            tiePoint.setGeoX(values[index+3]);
            tiePoint.setGeoY(values[index+4]);
            tiePoint.setGeoZ(values[index+5]);
            tiePointList.add(tiePoint);
        }
    }
    @Override
    public String toString()
    {
        String string="";
        for(TiePoint tiePoint:tiePointList)
        {
            string+="\n"+tiePoint;
        }
        return string;
    }
}
