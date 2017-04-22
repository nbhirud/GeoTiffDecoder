/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.window;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author kamlesh.paunikar
 */
public class TagInfoCellRenderer extends DefaultTableCellRenderer{

    @Override
     public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, int row, int column) {
         JButton button=new JButton("...");
        
         return button;
     }

}
