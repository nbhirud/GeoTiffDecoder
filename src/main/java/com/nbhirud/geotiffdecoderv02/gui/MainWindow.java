/*
 * MainWindow.java
 *
 * Created on August 9, 2008, 11:33 PM
 */
package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author  Administrator
 */
public class MainWindow extends javax.swing.JFrame implements IViewListener {

    private IGUIManager gUIManager;
    private final String TIFFIMAGE = "Tiff Image(*.tiff)";
    private final String GTIFIMAGE = "GeoTif(*.gtif)";
    private ArrayList<IViewWindow> viewWindowArrayList = new ArrayList<IViewWindow>();
    private ViewWindowsStatusTableModel statusTableModel;
    private JTable table;
    private JScrollPane scrollPane;

    /** Creates new form MainWindow */
    public MainWindow(IGUIManager gUIManager) {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/title.png"));
        setIconImage(imageIcon.getImage());
        this.gUIManager = gUIManager;
        initComponents();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, 300, (int) (screenSize.height * 0.8));
        createImageWindowsStatusTable();
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //get the selected imageWindow in focus
                if(e.getClickCount()==2){
                    ViewWindow viewWindow =(ViewWindow) viewWindowArrayList.get(table.getSelectedRow());
                    viewWindow.setVisible(true);
            }
            }
        });
        
    }

    public void refresh() {
        statusTableModel = new ViewWindowsStatusTableModel(viewWindowArrayList);
        table.setModel(statusTableModel);
        scrollPane.setViewportView(table);
    }

    public void createImageWindowsStatusTable() {
        table = new JTable();

        scrollPane = new JScrollPane(table);
        scrollPane.setViewportView(table);
        veiwWindowStatusPanel.add(scrollPane);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        veiwWindowStatusPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mainWindowFileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        mainWindowHelpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Window");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        veiwWindowStatusPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(veiwWindowStatusPanel, java.awt.BorderLayout.CENTER);

        mainWindowFileMenu.setMnemonic('F');
        mainWindowFileMenu.setText("File");
        mainWindowFileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainWindowFileMenuActionPerformed(evt);
            }
        });

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        mainWindowFileMenu.add(openMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        mainWindowFileMenu.add(exitMenuItem);

        jMenuBar1.add(mainWindowFileMenu);

        mainWindowHelpMenu.setMnemonic('H');
        mainWindowHelpMenu.setText("Help");

        aboutMenuItem.setText("About");
        mainWindowHelpMenu.add(aboutMenuItem);

        jMenuBar1.add(mainWindowHelpMenu);

        setJMenuBar(jMenuBar1);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-520)/2, (screenSize.height-446)/2, 520, 446);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method closes the application
     * @param evt
     */
private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
    if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit !", "", JOptionPane.YES_NO_OPTION) == 0) {
        System.exit(0);
    }
}//GEN-LAST:event_exitMenuItemActionPerformed
    /**
     * This method is used to display open Dialog to open the "*.tiff","*.gtif" type of images
     * @param evt
     */
private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed

    JFileChooser openFileChooser = new JFileChooser();
    openFileChooser.setDialogTitle("Open Image");

    openFileChooser.setFileFilter(new FileFilter() {

        @Override
        public boolean accept(File f) {
            boolean value = false;
            if (f.isDirectory() || f.getName().endsWith(".tiff")) {
                value = true;
            }
            return value;
        }

        @Override
        public String getDescription() {
            return TIFFIMAGE;
        }
    });
    openFileChooser.setFileFilter(new FileFilter() {

        @Override
        public boolean accept(File f) {
            boolean value = false;
            if (f.isDirectory() || f.getName().endsWith(".gtif")) {
                value = true;
            }
            return value;
        }

        @Override
        public String getDescription() {
            return GTIFIMAGE;
        }
    });
    openFileChooser.showOpenDialog(this);
    File selectedFile = openFileChooser.getSelectedFile();
    if (openFileChooser.getSelectedFile() != null) {
        ViewWindow viewWindow = gUIManager.createViewWindow(selectedFile);
        viewWindow.addViewListener(this);
        viewWindow.setVisible(true);
        viewWindowArrayList.add(viewWindow);
    }

//GEN-LAST:event_openMenuItemActionPerformed
    }

private void mainWindowFileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainWindowFileMenuActionPerformed
}//GEN-LAST:event_mainWindowFileMenuActionPerformed

private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
}//GEN-LAST:event_formWindowGainedFocus

private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
}//GEN-LAST:event_formFocusGained

private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
}//GEN-LAST:event_formMouseClicked

private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
}//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                new MainWindow(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mainWindowFileMenu;
    private javax.swing.JMenu mainWindowHelpMenu;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JPanel veiwWindowStatusPanel;
    // End of variables declaration//GEN-END:variables

    public void mapCreated(IViewWindow iViewWindow) {

        refresh();
    }

    public void mapClosed(IViewWindow viewWindow) {
        System.out.println("Mapclosed");
        viewWindowArrayList.remove(viewWindow);
        refresh();
    }
}
