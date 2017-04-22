/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.geotag;

import com.sun.media.jai.codec.TIFFField;
import java.util.ArrayList;

/**
 *
 * @author kamlesh.paunikar
 */
public class GeoKeyDirectoryTag {

    public final static int GeoKeyDirectoryTag = 34735;
    private char values[];
    private int keyDirectoryVersion;
    private int keyRevision;
    private int minorRevision;
    private int numberOfKeys;
    private ArrayList<GeoKey> keyList = new ArrayList<GeoKey>();

    public int getKeyDirectoryVersion() {
        return keyDirectoryVersion;
    }

    public int getKeyRevision() {
        return keyRevision;
    }

    public int getMinorRevision() {
        return minorRevision;
    }

    public int getNumberOfKeys() {
        return numberOfKeys;
    }

    public GeoKeyDirectoryTag(TIFFField field) {
        values = field.getAsChars();
        loadHeaderValues();
        loadKeys();

    }

    private void loadHeaderValues() {
        if (values.length >= 4) {
            keyDirectoryVersion = values[0];
            keyRevision = values[1];
            minorRevision = values[2];
            numberOfKeys = values[3];
        }
    }

    private void loadKeys() {
        int startIndex = 4;
        keyList.clear();
        for (int keyIndex = 0; keyIndex < numberOfKeys; keyIndex++) {
            GeoKey geoKey = new GeoKey();
            geoKey.setTag(values[startIndex + keyIndex * 4]);
            geoKey.setType(values[startIndex + keyIndex * 4 + 1]);
            geoKey.setCount(values[startIndex + keyIndex * 4 + 2]);
            geoKey.setValue(values[startIndex + keyIndex * 4 + 3]);
            keyList.add(geoKey);
        }
    }

    public boolean isKeyPresent(int tag) {
        for (GeoKey geoKey : keyList) {
            if (geoKey.getTag() == tag) {
                return true;
            }
        }
        return false;
    }

    public GeoKey getKey(int tag) {
        for (GeoKey geoKey : keyList) {
            if (geoKey.getTag() == tag) {
                return geoKey;
            }
        }
        return null;
    }
}
