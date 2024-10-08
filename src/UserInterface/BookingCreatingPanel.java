package UserInterface;

import Classes.Booking;
import Classes.Car;
import Classes.Current;
import Classes.User;
import DAO.CarDao;
import DAO.PaymentDao;
import DAO.UserDao;
import Processes.BookingProcess;
import Processes.PaymentProcess;
import Processes.ReloadCreditBalanceProcess;
import Validator.BookingValidator;
import Validator.DateTimeValidator;
import java.awt.CardLayout;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class BookingCreatingPanel extends javax.swing.JPanel {
    BookingProcess bookingProcess = new BookingProcess();

    public BookingCreatingPanel() {
        initComponents();
        clearCarsInComboBox();
        
        startDateInput.getDocument().addDocumentListener(new DocumentListener() {
            // implement the methods
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (startDateInput.getText().length() == 10){
                    try {
                        handleStartDateInput();
                        setCurrentUserIcNo();
                    } catch (ParseException ex) {}
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (startDateInput.getText().length() == 10){
                    try {
                        handleStartDateInput();
                        setCurrentUserIcNo();
                    } catch (ParseException ex) {}
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
        
        durationInput.getDocument().addDocumentListener(new DocumentListener() {
            // implement the methods
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    handleDurationInput();
                } 
                catch (NumberFormatException | ParseException ex) {
                    clearCarsInComboBox();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    handleDurationInput();
                }
                catch (NumberFormatException | ParseException ex) {
                    clearCarsInComboBox();
                }
            }
            

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
    }
    
    private void handleStartDateInput() throws ParseException {
        boolean startDateIsVerified = false;
        String startDate = startDateInput.getText();
        DateTimeValidator dtValidator = new DateTimeValidator();

        try {
            dtValidator.validateDate(startDate);
            startDateIsVerified = true;
        }
        catch (IllegalArgumentException ex) {}

        if (startDateIsVerified) {
            startDateInput.setEnabled(false);
            durationInput.setEnabled(true);
            iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/tick.png")));
        }
    }
    
    private void setCurrentUserIcNo() {
        Frame currentJFrame = (Frame) SwingUtilities.getWindowAncestor(this);
        //currentUserIcNoLabel.setText(currentJFrame.getLoggedIn().getIcno());
    };
    
    private void handleDurationInput() throws NumberFormatException, ParseException {
        String startDate = startDateInput.getText();
        String duration = durationInput.getText();
        
        // validate duration
        Integer.valueOf(durationInput.getText());
        
        clearCarsInComboBox();
        addCarsToComboBox(startDate, duration);
        carComboBox.setEnabled(true);
    }
    
    private void clearCarsInComboBox() {
        carComboBox.removeAllItems();
    }
    
    private void addCarsToComboBox (String startDate, String duration) throws ParseException {
        ArrayList<Car> cars = bookingProcess.getAvailableCars(startDate, duration);
            
        for (Car car : cars) {
            //WTF8888 - Tesla Model X (White) - Price: RM 200/day
            String item = car.getCarId() + " - " + car.getBrand() + " " + car.getModel() + " (" + car.getColor() + ") - RM " + car.getRentalPerDay() + "/day";
            carComboBox.addItem(item);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        startDateInput = new javax.swing.JTextField();
        durationInput = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        carComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cashButton = new javax.swing.JRadioButton();
        creditBalanceButton = new javax.swing.JRadioButton();
        bankTransferButton = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        iconLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        confirmButton = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Make Booking");

        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        startDateInput.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        startDateInput.setToolTipText("Start Date");
        startDateInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateInputActionPerformed(evt);
            }
        });
        startDateInput.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                startDateInputPropertyChange(evt);
            }
        });
        jPanel2.add(startDateInput);

        durationInput.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        durationInput.setToolTipText("Duration");
        durationInput.setEnabled(false);
        jPanel2.add(durationInput);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Start Date");
        jPanel1.add(jLabel3);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Duration (Number of Days)");
        jPanel1.add(jLabel8);

        carComboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        carComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        carComboBox.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Car");

        jPanel3.setLayout(new java.awt.GridLayout(3, 1));

        cashButton.setText("Cash (Car will only be reserved once payment has been made)");
        cashButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashButtonActionPerformed(evt);
            }
        });
        jPanel3.add(cashButton);

        creditBalanceButton.setText("Credit Balance");
        creditBalanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditBalanceButtonActionPerformed(evt);
            }
        });
        jPanel3.add(creditBalanceButton);

        bankTransferButton.setText("Bank Transfer (Transfer Reference ID will be prompted)");
        bankTransferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankTransferButtonActionPerformed(evt);
            }
        });
        jPanel3.add(bankTransferButton);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Payment Method");

        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cross.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconLabel)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel5.setLayout(new java.awt.GridBagLayout());

        backButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 25;
        jPanel5.add(backButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        jPanel5.add(jPanel6, gridBagConstraints);

        confirmButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 25;
        jPanel5.add(confirmButton, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(carComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void startDateInputPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_startDateInputPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_startDateInputPropertyChange

    private void startDateInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDateInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startDateInputActionPerformed

    private void cashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashButtonActionPerformed
        // TODO add your handling code here:
        creditBalanceButton.setSelected(false);
        bankTransferButton.setSelected(false);
    }//GEN-LAST:event_cashButtonActionPerformed

    private void creditBalanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditBalanceButtonActionPerformed
        // TODO add your handling code here:
        cashButton.setSelected(false);
        bankTransferButton.setSelected(false);
    }//GEN-LAST:event_creditBalanceButtonActionPerformed

    private void bankTransferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankTransferButtonActionPerformed
        // TODO add your handling code here:
        cashButton.setSelected(false);
        creditBalanceButton.setSelected(false);
    }//GEN-LAST:event_bankTransferButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        Frame currentJFrame = (Frame) SwingUtilities.getWindowAncestor(this);
        JPanel controlPanel = currentJFrame.getControlPanel();
        CardLayout layout = (CardLayout) controlPanel.getLayout();
        
        makeEverythingInitialized();
        
        layout.show(controlPanel, "custHomePanel");
    }//GEN-LAST:event_backButtonActionPerformed

    private void makeEverythingInitialized() {
        startDateInput.setText("");
        durationInput.setText("");
        clearCarsInComboBox();
        cashButton.setSelected(false);
        creditBalanceButton.setSelected(false);
        bankTransferButton.setSelected(false);
        startDateInput.setEnabled(true);
        durationInput.setEnabled(false);
        carComboBox.setEnabled(false);
        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cross.png")));
    }
    
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        Frame currentJFrame = (Frame) SwingUtilities.getWindowAncestor(this);
        JPanel controlPanel = currentJFrame.getControlPanel();
        CardLayout layout = (CardLayout) controlPanel.getLayout();
        DecimalFormat df = new DecimalFormat("0.00");
        
        String startDate = startDateInput.getText();
        String duration = durationInput.getText();
        String car = String.valueOf(carComboBox.getSelectedItem());
        String paymentMethod = null;
        String transferReferenceId = null;
        double price = 0.00;
        String total;
        String updatedBalance = UserDao.loggedIn.getCreditBalance();
        String paymentApproval = "Pending";
        
        CarDao carDao = new CarDao();
        Car carSelected = carDao.get(car.split(" ")[0]);
        
        BookingValidator bookingValidator = new BookingValidator();
        boolean validationSuccess = true;
        try {
            bookingValidator.validateBookingCreationInput(carSelected, duration, paymentMethod);
        } catch (IllegalArgumentException ex) {
            validationSuccess = false;
            JOptionPane.showMessageDialog(currentJFrame, ex.getMessage());
        }
        

        if (cashButton.isSelected()) {
            paymentMethod = "cash";
        } else if (creditBalanceButton.isSelected()) {
            paymentMethod = "credit balance";
        } else if (bankTransferButton.isSelected()) {
            paymentMethod = "bank transfer";
        } else {
            JOptionPane.showMessageDialog(currentJFrame, "Please select a payment method.");
            validationSuccess = false;
        }

        if (validationSuccess == true) {
            price = Double.parseDouble(carSelected.getRentalPerDay()) * Double.parseDouble(duration);
            total = df.format(price);
            String confirmMessage = "Confirm booking: \nCar: " + carSelected.getCarId() + "\nDuration: " + duration + "day(s) \nTotal: RM " + total;
            
            if (JOptionPane.showConfirmDialog(null, confirmMessage, "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                return;
            }

            if (paymentMethod.equals("bank transfer")) {
                transferReferenceId = JOptionPane.showInputDialog(currentJFrame, "Enter Bank Transfer Reference ID:");
                if (transferReferenceId == null) {
                    return;
                }
            }

            if (paymentMethod.equals("credit balance")) {
                double balance = Double.parseDouble(UserDao.loggedIn.getCreditBalance());
                if (balance < price) {
                    JOptionPane.showMessageDialog(null, "Credit balance not enough");
                    return;
                }
                else {
                    updatedBalance = String.valueOf(df.format(balance - price));
                    paymentApproval = "Verified";
                }
            }

            Booking booking = new Booking();
            boolean isBookingCreationSuccessful = booking.add(UserDao.loggedIn.getIcno(), startDate, duration, car, paymentMethod, transferReferenceId);
            if (isBookingCreationSuccessful == true) {
                Booking newBooking = booking.getLastBooking();
                String bookingId = newBooking.getBookingId();

                // add payment.txt
                PaymentProcess pp = new PaymentProcess();
                Current c = new Current();
                pp.setPayment(null, bookingId, "", c.datetime, paymentMethod, total, paymentApproval, transferReferenceId);
                pp.updatePayment();

                if (paymentMethod.equals("credit balance")) {
                    // update credit balance
                    User user = UserDao.loggedIn;
                    String[] updatedInfo = { user.getIcno(), user.getUsername(), user.getPassword(), user.getRole(),
                        user.getEmail(), user.getPhone(), user.getGender(), user.getAddress1(), user.getAddress2(),
                        user.getCity(), user.getZip(), user.getState(), user.getRegistered(), updatedBalance,
                        user.getApproval() };
                    ReloadCreditBalanceProcess rcbp = new ReloadCreditBalanceProcess(updatedInfo);

                    rcbp.updateCreditBalance(UserDao.loggedIn);
                    rcbp.updateOutCreditBalanceDetails(total);
                }

                PaymentDao pd = new PaymentDao();
                newBooking.setPayment(pd.searchBookingId(newBooking.getBookingId()));

                currentJFrame.bookingDetailPanel.setBookingDetail(bookingId);
                currentJFrame.bookingHistoryPanel.buildTable(null, false, false);
                layout.show(controlPanel, "bookingHistoryPanel");
                JOptionPane.showMessageDialog(currentJFrame, "Please wait for admin's confirmation patiently.");
            } else {
                layout.show(controlPanel, "custHomePanel");
                JOptionPane.showMessageDialog(currentJFrame, "Failed to create booking.");
            }
            makeEverythingInitialized();
            
        }
        
    }//GEN-LAST:event_confirmButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JRadioButton bankTransferButton;
    private javax.swing.JComboBox<String> carComboBox;
    private javax.swing.JRadioButton cashButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JRadioButton creditBalanceButton;
    private javax.swing.JTextField durationInput;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField startDateInput;
    // End of variables declaration//GEN-END:variables
}

