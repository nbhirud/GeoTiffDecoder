/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reader;

import com.sun.media.jai.codec.TIFFField;
import java.io.File;
import java.io.FileNotFoundException;
import reader.geotag.GeoAsciiParamsTag;
import reader.geotag.GeoDoubleParamsTag;
import reader.geotag.GeoKeyDirectoryTag;
import reader.geotag.ModelPixelScaleTag;
import reader.geotag.ModelTiepointTag;

/**
 *
 * @author Administrator
 */
public class GeoTiffReader extends TiffReader implements IGeoTiffTag {

    private GeoAsciiParamsTag geoAsciiParamsTag;
    private GeoDoubleParamsTag geoDoubleParamsTag;
    private GeoKeyDirectoryTag geoKeyDirectoryTag;
    private ModelPixelScaleTag modelPixelScaleTag;
    private ModelTiepointTag modelTiepointTag;

    /**
     * costructor to accept file
     * @param file
     * @throws java.io.FileNotFoundException
     */
    public GeoTiffReader(File file) throws FileNotFoundException, Exception {
        super(file);
        if (tIFFDirectory != null) {
            loadTags();
        }
    }

    private void loadGeoAsciiParamsTag() {
        if (tIFFDirectory.isTagPresent(GeoAsciiParamsTag.GeoAsciiParamsTag)) {
            TIFFField field = tIFFDirectory.getField(GeoAsciiParamsTag.GeoAsciiParamsTag);
            geoAsciiParamsTag = new GeoAsciiParamsTag(field);
        }
    }

    private void loadGeoDoubleParamsTag() {
        if (tIFFDirectory.isTagPresent(GeoDoubleParamsTag.GeoDoubleParamsTag)) {
            TIFFField field = tIFFDirectory.getField(GeoDoubleParamsTag.GeoDoubleParamsTag);
            geoDoubleParamsTag = new GeoDoubleParamsTag(field);
        }
    }

    private void loadGeoKeyDirectoryTag() {
        if (tIFFDirectory.isTagPresent(GeoKeyDirectoryTag.GeoKeyDirectoryTag)) {
            TIFFField field = tIFFDirectory.getField(GeoKeyDirectoryTag.GeoKeyDirectoryTag);
            geoKeyDirectoryTag = new GeoKeyDirectoryTag(field);
        }
    }

    private void loadModelPixelScaleTag() {
        if (tIFFDirectory.isTagPresent(ModelPixelScaleTag.ModelPixelScaleTag)) {
            TIFFField field = tIFFDirectory.getField(ModelPixelScaleTag.ModelPixelScaleTag);
            modelPixelScaleTag = new ModelPixelScaleTag(field);
        }
    }

    private void loadModelTiepointTag() {
        if (tIFFDirectory.isTagPresent(ModelTiepointTag.ModelTiepointTag)) {
            TIFFField field = tIFFDirectory.getField(ModelTiepointTag.ModelTiepointTag);
            modelTiepointTag = new ModelTiepointTag(field);
        }
    }

    private void loadTags() {
        loadGeoAsciiParamsTag();
        loadGeoDoubleParamsTag();
        loadGeoKeyDirectoryTag();
        loadModelPixelScaleTag();
        loadModelTiepointTag();
    }

    @Override
    public GeoAsciiParamsTag getGeoAsciiParamsTag() {
        return geoAsciiParamsTag;
    }

    @Override
    public GeoDoubleParamsTag getGeoDoubleParamsTag() {
        return geoDoubleParamsTag;
    }

    @Override
    public GeoKeyDirectoryTag getGeoKeyDirectoryTag() {
        return geoKeyDirectoryTag;
    }

    @Override
    public ModelPixelScaleTag getModelPixelScaleTag() {
        return modelPixelScaleTag;
    }

    @Override
    public ModelTiepointTag getModelTiepointTag() {
        return modelTiepointTag;
    }
}
