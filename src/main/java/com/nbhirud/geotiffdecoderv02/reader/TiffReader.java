/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reader;

import com.sun.media.jai.codec.TIFFDirectory;
import com.sun.media.jai.codec.TIFFField;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import javax.media.jai.JAI;
import javax.swing.JOptionPane;

/**
 * To read the contents of tiff file.
 * @author Administrator
 */
public class TiffReader {

    private RenderedImage renderedImage;
    protected TIFFDirectory tIFFDirectory;

    /**
     * default constructor.
     */
    protected TiffReader() {
    }

    /**
     * Constructor to accept tiff file.
     * @param file
     * @throws java.io.FileNotFoundException
     */
    public TiffReader(File file) throws FileNotFoundException, Exception {
        if (!file.exists()) {
            throw new FileNotFoundException("File not exist : " + file.getPath());
        }
        load(file);
    }

    private void load(File file) throws Exception {
        try {
            renderedImage = (RenderedImage) JAI.create("fileload", file.getPath());
            Object property = renderedImage.getProperty("tiff_directory");
            if (property != null) {

                tIFFDirectory = (TIFFDirectory) property;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bad Format");
           
        }
    }

    /**
     * returns the renderedimage of given file.
     * @return rendered image
     */
    public RenderedImage getRenderedImage() {
        return renderedImage;
    }

    /**
     * 
     * @return TIFFDirectory
     */
    public TIFFDirectory getTIFFDirectory() {
        return tIFFDirectory;
    }
}
