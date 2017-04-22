/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Administrator
 */
public interface IViewWindow {

    public String getMapName();
    void addViewListener(IViewListener viewListener);
   void removeViewListener(IViewListener viewListener);
}
