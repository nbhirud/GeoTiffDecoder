/*
 * ProductInformationDialog.java
 *
 * Created on August 12, 2008, 11:04 AM
 */
package gui.window;

import com.sun.media.jai.codec.TIFFField;
import geokey.GTCitationGeoKey;
import geokey.GTModelTypeGeoKey;
import geokey.GTRasterTypeGeoKey;
import geokey.GeogCitationGeoKey;
import geokey.GeogEllipsoidGeoKey;
import geokey.GeogGeodeticDatumGeoKey;
import geokey.GeogSemiMajorAxisGeoKey;
import geokey.GeogSemiMinorAxisGeoKey;
import geokey.IGeoKeyInfo;
import geokey.ModelPixelScaleTag;
import geokey.ProjCenterLatGeoKey;
import geokey.ProjCenterLongGeoKey;
import geokey.ProjCoordTransGeoKey;
import geokey.ProjFalseEastingGeoKey;
import geokey.ProjFalseNorthingGeoKey;
import geokey.ProjLinearUnitsGeoKey;
import geokey.ProjNatOriginLatGeoKey;
import geokey.ProjNatOriginLongGeoKey;
import geokey.ProjScaleAtCenterGeoKey;
import geokey.ProjScaleAtNatOriginGeoKey;
import geokey.ProjectedCSTypeGeoKey;
import geokey.ProjectionGeoKey;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author  Administrator
 * 
 */

public class ProductInformationDialog extends javax.swing.JDialog {

    private JScrollPane scrollPane;
    private JTable table;
    private ArrayList<IGeoKeyInfo> geoKeyInfoList;
    private ProductInformationTableModel tableModel;

    /** Creates new form ProductInformationDialog 
     * 
     * @param parent
     * @param modal
     * @param tiffFields
     */
    public ProductInformationDialog(java.awt.Frame parent, boolean modal, TIFFField tiffFields[]) {
        super(parent, modal);
        initComponents();
        geoKeyInfoList = new ArrayList<IGeoKeyInfo>();
        addGeoKeyPanel(geoKeyInfoList, tiffFields);
        int tableRowHeight = getMaximumPanelHeight(geoKeyInfoList);
        tableModel = new ProductInformationTableModel(geoKeyInfoList);
        table = new JTable(tableModel);
        table.setRowHeight(tableRowHeight);
        table.setDefaultRenderer(JPanel.class, new ProductInformationTableCellRenderer());
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        scrollPane.setPreferredSize(new Dimension(getPreferredSize().width,tableRowHeight*table.getRowCount()));
        addRemainingGeoKeyPanels(tiffFields);
        pack();
    }

    /**
     * 
     * @param geoKeyInfoList
     * @param tIFFFields
     */
    private void addGeoKeyPanel(ArrayList<IGeoKeyInfo> geoKeyInfoList, TIFFField tIFFFields[]) {
//        GeogCitationGeoKey geogCitationGeoKey = new GeogCitationGeoKey(tIFFFields);
//        GeogSemiMajorAxisGeoKey semiMajorAxisGeoKey = new GeogSemiMajorAxisGeoKey(tIFFFields);
//        GeogSemiMinorAxisGeoKey semiMinorAxisGeoKey = new GeogSemiMinorAxisGeoKey(tIFFFields);
//        GTModelTypeGeoKey gTModelTypeGeoKey = new GTModelTypeGeoKey(tIFFFields);
//        GTRasterTypeGeoKey gTRasterTypeGeoKey = new GTRasterTypeGeoKey(tIFFFields);
//        ModelPixelScaleTag modelPixelScaleTag = new ModelPixelScaleTag(tIFFFields);
//        ProjCenterLatGeoKey centerLatGeoKey = new ProjCenterLatGeoKey(tIFFFields);
//        ProjCenterLongGeoKey centerLongGeoKey = new ProjCenterLongGeoKey(tIFFFields);
//        ProjCoordTransGeoKey coordTransGeoKey = new ProjCoordTransGeoKey(tIFFFields);
//        ProjectedCSTypeGeoKey cSTypeGeoKey = new ProjectedCSTypeGeoKey(tIFFFields);
//        ProjFalseEastingGeoKey projFalseEastingGeoKey = new ProjFalseEastingGeoKey(tIFFFields);
//        ProjFalseNorthingGeoKey projFalseNorthingGeoKey = new ProjFalseNorthingGeoKey(tIFFFields);
//        ProjLinearUnitsGeoKey projLinearUnitsGeoKey = new ProjLinearUnitsGeoKey(tIFFFields);
//        ProjNatOriginLatGeoKey projNatOriginLatGeoKey = new ProjNatOriginLatGeoKey(tIFFFields);
//        ProjNatOriginLongGeoKey projNatOriginLongGeoKey = new ProjNatOriginLongGeoKey(tIFFFields);
//        ProjScaleAtCenterGeoKey projScaleAtCenterGeoKey = new ProjScaleAtCenterGeoKey(tIFFFields);
//        ProjScaleAtNatOriginGeoKey projScaleAtNatOriginGeoKey = new ProjScaleAtNatOriginGeoKey(tIFFFields);
//        if (geogCitationGeoKey.isIsAvailable()) {
//            geoKeyInfoList.add(geogCitationGeoKey);
//        }
//        if (semiMajorAxisGeoKey.isIsAvailable()) {
//            geoKeyInfoList.add(semiMajorAxisGeoKey);
//        }
//        if (semiMinorAxisGeoKey.isIsAvailable()) {
//            geoKeyInfoList.add(semiMinorAxisGeoKey);
//        }
//        if (gTModelTypeGeoKey.isAvailable()) {
//            geoKeyInfoList.add(gTModelTypeGeoKey);
//        }
//        if (gTRasterTypeGeoKey.isAvailable()) {
//            geoKeyInfoList.add(gTRasterTypeGeoKey);
//        }
//        if (modelPixelScaleTag.isAvailable()) {
//            geoKeyInfoList.add(modelPixelScaleTag);
//        }
//        if (centerLatGeoKey.isIsAvailable()) {
//            geoKeyInfoList.add(centerLatGeoKey);
//        }
//        if (centerLongGeoKey.isIsAvailable()) {
//            geoKeyInfoList.add(centerLongGeoKey);
//        }
//        if (coordTransGeoKey.isIsAvailable()) {
//            geoKeyInfoList.add(coordTransGeoKey);
//        }
//        if (cSTypeGeoKey.isAvailable()) {
//            geoKeyInfoList.add(cSTypeGeoKey);
//        }
//        if (projFalseEastingGeoKey.isIsAvailable()) {
//            geoKeyInfoList.add(projFalseEastingGeoKey);
//        }
//        if (projFalseNorthingGeoKey.isIsAvailable()) {
//            geoKeyInfoList.add(projFalseNorthingGeoKey);
//        }
//        if (projLinearUnitsGeoKey.isAvailable()) {
//            geoKeyInfoList.add(projLinearUnitsGeoKey);
//        }
//        if (projNatOriginLatGeoKey.isIsAvailable()) {
//            geoKeyInfoList.add(projNatOriginLatGeoKey);
//        }
//        if (projNatOriginLongGeoKey.isIsAvailable()) {
//            geoKeyInfoList.add(projNatOriginLongGeoKey);
//        }
//        if (projScaleAtCenterGeoKey.isIsAvailable()) {
//            geoKeyInfoList.add(projScaleAtCenterGeoKey);
//        }
//        if (projScaleAtNatOriginGeoKey.isIsAvailable()) {
//            geoKeyInfoList.add(projScaleAtNatOriginGeoKey);
//        }
    }

    /**
     * 
     * @param tiffFields
     */
    private void addRemainingGeoKeyPanels(TIFFField[] tiffFields) {
        
//        ModelTiePointTag modelTiePointTag = new ModelTiePointTag(tiffFields);
//        if (modelTiePointTag.isAvailable()) {
//            if (modelTiePointTag.getPanel() != null) {
//                JScrollPane scrollPane1 = new JScrollPane(modelTiePointTag.getPanel()) ;
//                add(scrollPane1, BorderLayout.PAGE_END);
//            }
//        }
//        GeogEllipsoidGeoKey geogEllipsoidGeoKey = new GeogEllipsoidGeoKey(tiffFields);
//        if (geogEllipsoidGeoKey.isIsAvailable()) {
//            add(geogEllipsoidGeoKey.getPanel(), BorderLayout.PAGE_END);
//        }
//        GeogGeodeticDatumGeoKey geogGeodeticDatumGeoKey = new GeogGeodeticDatumGeoKey(tiffFields);
//        if (geogGeodeticDatumGeoKey.isIsAvailable()) {
//            add(geogGeodeticDatumGeoKey.getPanel(), BorderLayout.PAGE_END);
//        }
//        GTCitationGeoKey gTCitationGeoKey = new GTCitationGeoKey(tiffFields);
//        if (gTCitationGeoKey.isIsAvailable()) {
//            add(gTCitationGeoKey.getPanel(), BorderLayout.PAGE_END);
//        }
//        ProjectionGeoKey projectionGeoKey = new ProjectionGeoKey(tiffFields);
//        if (projectionGeoKey.isAvailable()) {
//            add(projectionGeoKey.getPanel(), BorderLayout.PAGE_END);
//        }
    }

    /**
     * 
     * @param geoKeyInfoList
     * @return
     */
    private int getMaximumPanelHeight(ArrayList<IGeoKeyInfo> geoKeyInfoList) {
        int maximumHeight = 0;
        for (IGeoKeyInfo geoKeyInfo : geoKeyInfoList) {
            JPanel panel = geoKeyInfo.getPanel();
            Dimension preferredSize = panel.getPreferredSize();
            if (preferredSize.height > maximumHeight) {
                maximumHeight = preferredSize.height;
            }
        }
        return maximumHeight;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("");

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-408)/2, (screenSize.height-334)/2, 408, 334);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
