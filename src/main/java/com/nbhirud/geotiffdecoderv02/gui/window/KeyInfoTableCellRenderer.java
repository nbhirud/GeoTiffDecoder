/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.window;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author KPServer
 */
public class KeyInfoTableCellRenderer implements TableCellRenderer{

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return (JPanel)value;
    }

}
