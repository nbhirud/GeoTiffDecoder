/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reader;

import java.io.File;
import java.io.FileNotFoundException;
import reader.geotag.GeoAsciiParamsTag;
import reader.geotag.GeoDoubleParamsTag;
import reader.geotag.GeoKeyDirectoryTag;

/**
 *
 * @author kamlesh.paunikar
 */
public class GeoTiffReaderTest {

    public static void main(String[] args) throws FileNotFoundException, Exception {
        IGeoTiffTag geoTiffTag = new GeoTiffReader(new File("E:\\NetBeansProjects\\GeoTiffDecoder\\samples\\c41078a1.gtif"));
        GeoAsciiParamsTag geoAsciiParamsTag = geoTiffTag.getGeoAsciiParamsTag();
        if (geoAsciiParamsTag != null) {
            System.out.println("Acii "+geoAsciiParamsTag.getValue(0));
        }
        GeoDoubleParamsTag geoDoubleParamsTag = geoTiffTag.getGeoDoubleParamsTag();
        if (geoDoubleParamsTag != null) {
            int valueCount = geoDoubleParamsTag.getValueCount();
            for (int index = 0; index < valueCount; index++) {
                System.out.println("Value=" + geoDoubleParamsTag.getValue(index));
            }
        }
        GeoKeyDirectoryTag geoKeyDirectoryTag = geoTiffTag.getGeoKeyDirectoryTag();
        if(geoKeyDirectoryTag!=null)
        {
            System.out.println("Dir. Version="+geoKeyDirectoryTag.getKeyDirectoryVersion());
            System.out.println("Minor Version="+geoKeyDirectoryTag.getMinorRevision());
            System.out.println("Revision No.="+geoKeyDirectoryTag.getKeyRevision());
            System.out.println("Number of keys="+geoKeyDirectoryTag.getNumberOfKeys());
        }
    }
}
