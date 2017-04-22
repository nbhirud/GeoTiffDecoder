/*
 * KeyInfoPanel.java
 *
 * Created on August 26, 2008, 12:52 PM
 */
package gui.window;

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
import reader.IGeoTiffTag;

/**
 *
 * @author  kamlesh.paunikar
 */
public class KeyInfoPanel extends javax.swing.JPanel {

    private JScrollPane scrollPane;
    private ArrayList<IGeoKeyInfo> geoKeyInfoList;
    private JTable table;
    private KeyInfoTableModel tableModel;

    /** Creates new form KeyInfoPanel */
    public KeyInfoPanel(IGeoTiffTag geoTiffTag) {
        initComponents();
        geoKeyInfoList = new ArrayList<IGeoKeyInfo>();
        addGeoKeyPanel(geoKeyInfoList, geoTiffTag);
        int tableRowHeight = getMaximumPanelHeight(geoKeyInfoList);
        System.out.println("TableRowHeight = " + tableRowHeight);
        tableModel = new KeyInfoTableModel(geoKeyInfoList);
        table = new JTable(tableModel);
        table.setRowHeight(tableRowHeight);
        table.setDefaultRenderer(JPanel.class, new KeyInfoTableCellRenderer());
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(table);
//        scrollPane.setPreferredSize(new Dimension(getPreferredSize().width,(int) ( tableRowHeight * (table.getRowCount() + 0.5))));
        scrollPane.setPreferredSize(new Dimension(getPreferredSize().width, (int) (tableRowHeight * 5 + tableRowHeight * .4)));
        addRemainingGeoKeyPanels(geoTiffTag);
        add(scrollPane, BorderLayout.CENTER);
//        setPreferredSize(scrollPane.getPreferredSize());

    }

    void refresh() {
    }

    /**
     * 
     * @param geoKeyInfoList
     * @param tIFFFields
     */
    private void addGeoKeyPanel(ArrayList<IGeoKeyInfo> geoKeyInfoList, IGeoTiffTag iGeoTiffTag) {
        GTCitationGeoKey gTCitationGeoKey = new GTCitationGeoKey(iGeoTiffTag);
        GeogCitationGeoKey geogCitationGeoKey = new GeogCitationGeoKey(iGeoTiffTag);
        GeogSemiMajorAxisGeoKey semiMajorAxisGeoKey = new GeogSemiMajorAxisGeoKey(iGeoTiffTag);
        GeogSemiMinorAxisGeoKey semiMinorAxisGeoKey = new GeogSemiMinorAxisGeoKey(iGeoTiffTag);
        GTModelTypeGeoKey gTModelTypeGeoKey = new GTModelTypeGeoKey(iGeoTiffTag);
        GTRasterTypeGeoKey gTRasterTypeGeoKey = new GTRasterTypeGeoKey(iGeoTiffTag);
        ProjCenterLatGeoKey centerLatGeoKey = new ProjCenterLatGeoKey(iGeoTiffTag);
        ProjCenterLongGeoKey centerLongGeoKey = new ProjCenterLongGeoKey(iGeoTiffTag);
        ProjCoordTransGeoKey coordTransGeoKey = new ProjCoordTransGeoKey(iGeoTiffTag);
        ProjectedCSTypeGeoKey cSTypeGeoKey = new ProjectedCSTypeGeoKey(iGeoTiffTag);
        ProjFalseEastingGeoKey projFalseEastingGeoKey = new ProjFalseEastingGeoKey(iGeoTiffTag);
        ProjFalseNorthingGeoKey projFalseNorthingGeoKey = new ProjFalseNorthingGeoKey(iGeoTiffTag);
        ProjLinearUnitsGeoKey projLinearUnitsGeoKey = new ProjLinearUnitsGeoKey(iGeoTiffTag);
        ProjNatOriginLatGeoKey projNatOriginLatGeoKey = new ProjNatOriginLatGeoKey(iGeoTiffTag);
        ProjNatOriginLongGeoKey projNatOriginLongGeoKey = new ProjNatOriginLongGeoKey(iGeoTiffTag);
        ProjScaleAtCenterGeoKey projScaleAtCenterGeoKey = new ProjScaleAtCenterGeoKey(iGeoTiffTag);
        ProjScaleAtNatOriginGeoKey projScaleAtNatOriginGeoKey = new ProjScaleAtNatOriginGeoKey(iGeoTiffTag);
        if (gTCitationGeoKey.isAvailable()) {
            geoKeyInfoList.add(gTCitationGeoKey);
        }
        if (geogCitationGeoKey.isAvailable()) {
            geoKeyInfoList.add(geogCitationGeoKey);
        }
        if (semiMajorAxisGeoKey.isAvailable()) {
            geoKeyInfoList.add(semiMajorAxisGeoKey);
        }
        if (semiMinorAxisGeoKey.isAvailable()) {
            geoKeyInfoList.add(semiMinorAxisGeoKey);
        }
        if (gTModelTypeGeoKey.isAvailable()) {

            geoKeyInfoList.add(gTModelTypeGeoKey);
        }
        if (gTRasterTypeGeoKey.isAvailable()) {
            geoKeyInfoList.add(gTRasterTypeGeoKey);
        }
        if (centerLatGeoKey.isAvailable()) {
            geoKeyInfoList.add(centerLatGeoKey);
        }
        if (centerLongGeoKey.isAvailable()) {
            geoKeyInfoList.add(centerLongGeoKey);
        }
        if (coordTransGeoKey.isAvailable()) {
            geoKeyInfoList.add(coordTransGeoKey);
        }
        if (cSTypeGeoKey.isAvailable()) {
            geoKeyInfoList.add(cSTypeGeoKey);
        }
        if (projFalseEastingGeoKey.isAvailable()) {
            geoKeyInfoList.add(projFalseEastingGeoKey);
        }
        if (projFalseNorthingGeoKey.isAvailable()) {
            geoKeyInfoList.add(projFalseNorthingGeoKey);
        }
        if (projLinearUnitsGeoKey.isAvailable()) {
            geoKeyInfoList.add(projLinearUnitsGeoKey);
        }
        if (projNatOriginLatGeoKey.isAvailable()) {
            geoKeyInfoList.add(projNatOriginLatGeoKey);
        }
        if (projNatOriginLongGeoKey.isAvailable()) {
            geoKeyInfoList.add(projNatOriginLongGeoKey);
        }
        if (projScaleAtCenterGeoKey.isAvailable()) {
            geoKeyInfoList.add(projScaleAtCenterGeoKey);
        }
        if (projScaleAtNatOriginGeoKey.isAvailable()) {
            geoKeyInfoList.add(projScaleAtNatOriginGeoKey);
        }
    }

    /**
     * 
     * @param tiffFields
     */
    private void addRemainingGeoKeyPanels(IGeoTiffTag iGeoTiffTag) {


        GeogEllipsoidGeoKey geogEllipsoidGeoKey = new GeogEllipsoidGeoKey(iGeoTiffTag);
        if (geogEllipsoidGeoKey.isAvailable()) {
            add(geogEllipsoidGeoKey.getPanel(), BorderLayout.PAGE_END);
        }
        GeogGeodeticDatumGeoKey geogGeodeticDatumGeoKey = new GeogGeodeticDatumGeoKey(iGeoTiffTag);
        if (geogGeodeticDatumGeoKey.isIsAvailable()) {
            add(geogGeodeticDatumGeoKey.getPanel(), BorderLayout.PAGE_END);
        }
        ProjectionGeoKey projectionGeoKey = new ProjectionGeoKey(iGeoTiffTag);
        if (projectionGeoKey.isAvailable()) {
            add(projectionGeoKey.getPanel(), BorderLayout.PAGE_END);
        }
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

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
