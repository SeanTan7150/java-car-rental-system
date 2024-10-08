/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Panel.java to edit this template
 */
package UserInterface;

import Classes.Car;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author user
 */
public class CarCreatingPanel extends java.awt.Panel {

    /**
     * Creates new form CarCreatingPanel
     */
    public CarCreatingPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        carIdInput = new javax.swing.JTextField();
        brandInput = new javax.swing.JTextField();
        modelInput = new javax.swing.JTextField();
        colorInput = new javax.swing.JTextField();
        manufacturingYearInput = new javax.swing.JTextField();
        rentalPerDayInput = new javax.swing.JTextField();
        lastServiceDateInput = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Car");

        jPanel1.setLayout(new java.awt.GridLayout(7, 1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Car ID (Car Plate No.)");
        jPanel1.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Brand");
        jPanel1.add(jLabel4);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Model");
        jPanel1.add(jLabel1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Color");
        jPanel1.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Manufacturing Year");
        jPanel1.add(jLabel6);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Rental Price Per Day");
        jPanel1.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Last Service Date");
        jPanel1.add(jLabel8);

        jPanel2.setLayout(new java.awt.GridLayout(7, 1));

        carIdInput.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        carIdInput.setToolTipText("Car ID");
        jPanel2.add(carIdInput);

        brandInput.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        brandInput.setToolTipText("Brand");
        jPanel2.add(brandInput);

        modelInput.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        modelInput.setToolTipText("Model");
        jPanel2.add(modelInput);

        colorInput.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        colorInput.setToolTipText("Color");
        jPanel2.add(colorInput);

        manufacturingYearInput.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        manufacturingYearInput.setToolTipText("Manufacturing Year");
        jPanel2.add(manufacturingYearInput);

        rentalPerDayInput.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rentalPerDayInput.setToolTipText("Rental Price Per Day");
        jPanel2.add(rentalPerDayInput);

        lastServiceDateInput.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lastServiceDateInput.setToolTipText("Last Service Date");
        jPanel2.add(lastServiceDateInput);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        backButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 25;
        jPanel3.add(backButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        jPanel3.add(jPanel4, gridBagConstraints);

        addButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 25;
        jPanel3.add(addButton, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addButtonActionPerformed
        // prepare for navigation and JOptionPane triggers
        Frame currentJFrame = (Frame) SwingUtilities.getWindowAncestor(this);
        JPanel controlPanel = currentJFrame.getControlPanel();
        CardLayout layout = (CardLayout) controlPanel.getLayout();

        String[] input = new String[7];
        input[0] = carIdInput.getText();
        input[1] = brandInput.getText();
        input[2] = modelInput.getText();
        input[3] = colorInput.getText();
        input[4] = manufacturingYearInput.getText();
        input[5] = rentalPerDayInput.getText();
        input[6] = lastServiceDateInput.getText();

        Car car = new Car();
        boolean isCarCreationSuccessful = car.add(input);
        if (isCarCreationSuccessful) {
            clearInput();
            currentJFrame.carListingPanel.buildTable(null);
            layout.show(controlPanel, "carListingPanel");
            JOptionPane.showMessageDialog(currentJFrame, "The car has been added successfully.");
        } else {
            JOptionPane.showMessageDialog(currentJFrame, car.getValidationFailMessage());
        }
    }// GEN-LAST:event_addButtonActionPerformed

    private void clearInput() {
        carIdInput.setText("");
        brandInput.setText("");
        modelInput.setText("");
        colorInput.setText("");
        manufacturingYearInput.setText("");
        rentalPerDayInput.setText("");
        lastServiceDateInput.setText("");
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        Frame currentJFrame = (Frame) SwingUtilities.getWindowAncestor(this);
        JPanel controlPanel = currentJFrame.getControlPanel();
        CardLayout layout = (CardLayout) controlPanel.getLayout();

        clearInput();
        layout.show(controlPanel, "carListingPanel");
    }// GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField brandInput;
    private javax.swing.JTextField carIdInput;
    private javax.swing.JTextField colorInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField lastServiceDateInput;
    private javax.swing.JTextField manufacturingYearInput;
    private javax.swing.JTextField modelInput;
    private javax.swing.JTextField rentalPerDayInput;
    // End of variables declaration//GEN-END:variables
}
