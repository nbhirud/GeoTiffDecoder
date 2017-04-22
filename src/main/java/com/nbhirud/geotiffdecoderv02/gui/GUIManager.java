/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import application.IAppContext;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class GUIManager implements IGUIManager {

    private MainWindow mainWindow;
    private ArrayList<ViewWindow> viewWindowList = new ArrayList<ViewWindow>();
    private IAppContext appContext;

    /**
     * 
     * @param appContext
     */
    public GUIManager(IAppContext appContext) {
        this.appContext=appContext;
        mainWindow = new MainWindow(this);

    }

    public void start() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                mainWindow.setVisible(true);
            }
        });
    }

    /**
     * 
     * @param file
     * @return
     */
    public ViewWindow createViewWindow(File file) {
        ViewWindow viewWindow=null;
        try {
            try {
                viewWindow = new ViewWindow(file);
            } catch (Exception ex) {
                Logger.getLogger(GUIManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            viewWindowList.add(viewWindow);
        } catch (Exception ex) {
            Logger.getLogger(GUIManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return viewWindow;
    }
}
