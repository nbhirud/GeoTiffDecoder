/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import gui.GUIManager;
import gui.IGUIManager;
import gui.SplashScreen;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class ApplicationManager implements IAppContext {

    private static GUIManager gUIManager;

    /**
     * 
     */
    public ApplicationManager() {
        gUIManager = new GUIManager(this);
    }

    /**
     * 
     */
    private static void setDefaultSkin() {

        JFrame.setDefaultLookAndFeelDecorated(true);
    }

    /**
     * 
     */
    private void start() {
        SplashScreen splashScreen = new SplashScreen(null, true);
        splashScreen.setVisible(true);
   //     JDialog.setDefaultLookAndFeelDecorated(true);
        gUIManager.start();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                setDefaultSkin();
                new ApplicationManager().start();
            }
        });
    }

    /**
     * 
     * @return
     */
    public IGUIManager getGUIManager() {
        return gUIManager;
    }
}
