/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reader;

import reader.geotag.GeoAsciiParamsTag;
import reader.geotag.GeoDoubleParamsTag;
import reader.geotag.GeoKeyDirectoryTag;
import reader.geotag.ModelPixelScaleTag;
import reader.geotag.ModelTiepointTag;

/**
 *
 * @author kamlesh.paunikar
 */
public interface IGeoTiffTag {

    public GeoAsciiParamsTag getGeoAsciiParamsTag();

    public GeoDoubleParamsTag getGeoDoubleParamsTag();

    public GeoKeyDirectoryTag getGeoKeyDirectoryTag();

    public ModelPixelScaleTag getModelPixelScaleTag();

    public ModelTiepointTag getModelTiepointTag();
}
