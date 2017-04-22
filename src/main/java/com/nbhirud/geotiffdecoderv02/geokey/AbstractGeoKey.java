/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geokey;

import com.sun.media.jai.codec.TIFFField;

/**
 *
 * @author KPServer
 */
abstract public class AbstractGeoKey {

    private TIFFField tIFFField;

    public AbstractGeoKey() {
    }

    /**
     * constructor to retain TIFFField
     * @param tIFFField[]
     * @param tag
     */
    public AbstractGeoKey(TIFFField tIFFField[], int tag) {

        for (int index = 0; index < tIFFField.length; index++) {
            if (tag == tIFFField[index].getTag()) {
                this.tIFFField = tIFFField[index];
            }
        }

    }

    /**
     * returns the value of tiffField
     * @return
     */
    public TIFFField getTIFFField() {
        return tIFFField;
    }
}
