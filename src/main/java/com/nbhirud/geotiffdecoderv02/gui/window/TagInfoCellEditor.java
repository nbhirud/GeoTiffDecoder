/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.window;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author kamlesh.paunikar
 */
public class TagInfoCellEditor extends AbstractCellEditor implements
        TableCellEditor {

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        System.out.println("I m ");
        JButton button = new JButton("...");
        final int row1 = row;
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Button CLicked of row " + row1);
                switch (row1) {
                    case 0:
                        
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
            }
        });
        return button;
    }
}
