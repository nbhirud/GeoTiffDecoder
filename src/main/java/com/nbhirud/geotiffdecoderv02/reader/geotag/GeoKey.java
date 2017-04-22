/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.geotag;

/**
 *
 * @author kamlesh.paunikar
 */
public class GeoKey {

    private int tag;
    private int type;
    private int count;
    private int value;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    @Override
    public String toString()
    {
        String string="Tag="+tag+" Type="+type+" Count="+count+" Value="+value;
        return string;
    }
}
