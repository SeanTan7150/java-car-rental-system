package UserInterface;

import Processes.CarProcess;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CarListingPanel extends java.awt.Panel {
    private CarProcess cp = new CarProcess();

    public CarListingPanel() {
        initComponents();
        buildTable(null);
    }

    public final void buildTable(String idToBeSearched) {
        cp.buildTable(CarListingTable, idToBeSearched);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CarListingTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cars");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, -1));

        CarListingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        CarListingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CarListingTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CarListingTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 640, 340));

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 90, 30));

        searchTextField.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        searchTextField.setText("Search using Car ID (Car Plate Number)");
        add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 270, 30));

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 90, 30));

        BackButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BackButton.setText("Back");
        BackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 480, 110, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        Frame currentJFrame = (Frame) SwingUtilities.getWindowAncestor(this);
        JPanel controlPanel = currentJFrame.getControlPanel();
        CardLayout layout = (CardLayout) controlPanel.getLayout();
        layout.show(controlPanel, "adminHomePanel");
    }//GEN-LAST:event_BackButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        Frame currentJFrame = (Frame) SwingUtilities.getWindowAncestor(this);
        JPanel controlPanel = currentJFrame.getControlPanel();
        CardLayout layout = (CardLayout) controlPanel.getLayout();
        layout.show(controlPanel, "carCreatingPanel");
    }// GEN-LAST:event_addButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String searchText = searchTextField.getText();
        if (searchText.equals("")) {
            buildTable(null);
        } else {
            buildTable(searchText);
        }
    }// GEN-LAST:event_searchButtonActionPerformed

    private void CarListingTableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_CarListingTableMouseClicked
        // TODO add your handling code here:
        Frame currentJFrame = (Frame) SwingUtilities.getWindowAncestor(this);
        JPanel controlPanel = currentJFrame.getControlPanel();
        CardLayout layout = (CardLayout) controlPanel.getLayout();

        javax.swing.JTable target = (javax.swing.JTable) evt.getSource();
        int row = target.getSelectedRow();
        String carId = CarListingTable.getValueAt(row, 0).toString();

        currentJFrame.carDetailPanel.setCarDetail(carId);
        layout.show(controlPanel, "carDetailPanel");
    }// GEN-LAST:event_CarListingTableMouseClicked

    private void makeBookingButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_makeBookingButtonActionPerformed
        // TODO add your handling code here:
        Frame currentJFrame = (Frame) SwingUtilities.getWindowAncestor(this);
        JPanel controlPanel = currentJFrame.getControlPanel();
        CardLayout layout = (CardLayout) controlPanel.getLayout();
        layout.show(controlPanel, "bookingCreatingPanel");
    }// GEN-LAST:event_makeBookingButtonActionPerformed

    private void bookingButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bookingButton1ActionPerformed
        // TODO add your handling code here:
        Frame currentJFrame = (Frame) SwingUtilities.getWindowAncestor(this);
        JPanel controlPanel = currentJFrame.getControlPanel();
        CardLayout layout = (CardLayout) controlPanel.getLayout();
        layout.show(controlPanel, "bookingListingPanel");
    }// GEN-LAST:event_bookingButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JTable CarListingTable;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
