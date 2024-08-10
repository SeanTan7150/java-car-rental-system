package UserInterface;

import Classes.Booking;
import Classes.Car;
import DAO.BookingDao;
import Processes.BookingProcess;
import Validator.DateTimeValidator;
import java.awt.CardLayout;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class BookingEditingPanel extends javax.swing.JPanel {
    private String originalBookingDate;
    private String originalBookingDuration;
    private String originalCarId;
    BookingProcess bookingProcess = new BookingProcess();
    BookingDao bd = new BookingDao();
    
    public BookingEditingPanel() {
        initComponents();

        bookingDateInput.getDocument().addDocumentListener(new DocumentListener() {
            // implement the methods
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (bookingDateInput.getText().length() == 10){
                    bookingDateLabel.setText("Booking Date (original: " + originalBookingDate + ")");
                    try {
                        handleBookingDateInput();
                    } catch (ParseException ex) {}
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (bookingDateInput.getText().length() == 10){
                    bookingDateLabel.setText("Booking Date (original: " + originalBookingDate + ")");
                    try {
                        handleBookingDateInput();
                    } catch (ParseException ex) {}
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
        
        bookingDurationInput.getDocument().addDocumentListener(new DocumentListener() {
            // implement the methods
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    bookingDurationLabel.setText("Booking Duration (original: " + originalBookingDuration + " days)");
                    handleBookingDurationInput();
                } 
                catch (ParseException | IllegalArgumentException ex) {}
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    bookingDurationLabel.setText("Booking Duration (original: " + originalBookingDuration + " days)");
                    handleBookingDurationInput();
                }
                catch (ParseException | IllegalArgumentException ex) {}
            }
            

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
    }
    
    private void handleBookingDateInput() throws ParseException {
        boolean bookingDateAndDurationIsVerified = false;
        String bookingDate = bookingDateInput.getText();
        String duration = bookingDurationInput.getText();
        DateTimeValidator dtValidator = new DateTimeValidator();

        try {
            dtValidator.validateDate(bookingDate);
            Integer.valueOf(bookingDurationInput.getText());
            bookingDateAndDurationIsVerified = true;
        }
        catch (IllegalArgumentException ex) {}

        if (bookingDateAndDurationIsVerified) {
            clearCarsInComboBox();
            addCarsToComboBox(bookingDate, duration);
        }
    }
    
    private void handleBookingDurationInput() throws NumberFormatException, ParseException {
        boolean bookingDateAndDurationIsVerified = false;
        String bookingDate = bookingDateInput.getText();
        String duration = bookingDurationInput.getText();
        DateTimeValidator dtValidator = new DateTimeValidator();
        
        dtValidator.validateDate(bookingDate);
        Integer.valueOf(bookingDurationInput.getText());
        
        clearCarsInComboBox();
        addCarsToComboBox(bookingDate, duration);
    }
    
    private void clearCarsInComboBox() {
        carComboBox.removeAllItems();
    }
    
    private void addCarsToComboBox (String startDate, String duration) throws ParseException {
        ArrayList<Car> cars = bookingProcess.getAvailableCars(startDate, duration, bd.get(bookingIdInput.getText()));
            
        for (Car car : cars) {
            //WTF8888 - Tesla Model X (White) - Price: RM 200/day
            String item = car.getCarId() + " - " + car.getBrand() + " " + car.getModel() + " (" + car.getColor() + ") - RM " + car.getRentalPerDay() + "/day";
            carComboBox.addItem(item);
        }
    }
    
    public void setBookingDetail(String bookingId) {
        Booking booking = new Booking(bookingId);
        originalBookingDate = booking.getBookingDate();
        originalBookingDuration = booking.getBookingDuration();
        originalCarId = booking.getCarId();
        carIdLabel.setText("Car ID (original: " + booking.getCarId() + ")");
        
        bookingIdInput.setText(booking.getBookingId());
        customerIdInput.setText(booking.getCustomerId());
        adminNameInput.setText(booking.getAdminId());
        bookingDurationInput.setText(booking.getBookingDuration());
        statusInput.setText(booking.getStatus());
        bookingDateInput.setText(booking.getBookingDate());
        
        clearCarsInComboBox();
        try {
            addCarsToComboBox(booking.getBookingDate(), booking.getBookingDuration());
        } catch (ParseException ex) {}
        Car car = new Car(originalCarId);
        carComboBox.setSelectedItem(car.getCarId() + " - " + car.getBrand() + " " + car.getModel() + " (" + car.getColor() + ") - RM " + car.getRentalPerDay() + "/day");
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
        bookingIdInput = new javax.swing.JTextField();
        customerIdInput = new javax.swing.JTextField();
        adminNameInput = new javax.swing.JTextField();
        bookingDateInput = new javax.swing.JTextField();
        bookingDurationInput = new javax.swing.JTextField();
        carComboBox = new javax.swing.JComboBox<>();
        statusInput = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        confirmButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        bookingDateLabel = new javax.swing.JLabel();
        bookingDurationLabel = new javax.swing.JLabel();
        carIdLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Edit Booking");

        jPanel2.setLayout(new java.awt.GridLayout(7, 1));

        bookingIdInput.setEditable(false);
        bookingIdInput.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bookingIdInput.setToolTipText("");
        jPanel2.add(bookingIdInput);

        customerIdInput.setEditable(false);
        customerIdInput.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        customerIdInput.setToolTipText("");
        jPanel2.add(customerIdInput);

        adminNameInput.setEditable(false);
        adminNameInput.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        adminNameInput.setToolTipText("");
        adminNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminNameInputActionPerformed(evt);
            }
        });
        jPanel2.add(adminNameInput);

        bookingDateInput.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bookingDateInput.setToolTipText("");
        jPanel2.add(bookingDateInput);

        bookingDurationInput.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bookingDurationInput.setToolTipText("");
        jPanel2.add(bookingDurationInput);

        carComboBox.setEditable(true);
        carComboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        carComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(carComboBox);

        statusInput.setEditable(false);
        statusInput.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        statusInput.setToolTipText("");
        jPanel2.add(statusInput);

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

        confirmButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 25;
        jPanel3.add(confirmButton, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridLayout(7, 1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Booking ID");
        jPanel5.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Customer ID");
        jPanel5.add(jLabel10);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("Admin Name");
        jPanel5.add(jLabel11);

        bookingDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bookingDateLabel.setText("Booking Date");
        jPanel5.add(bookingDateLabel);

        bookingDurationLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bookingDurationLabel.setText("Booking Duration");
        jPanel5.add(bookingDurationLabel);

        carIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        carIdLabel.setText("Car ID");
        jPanel5.add(carIdLabel);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setText("Status");
        jPanel5.add(jLabel14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        Frame currentJFrame = (Frame) SwingUtilities.getWindowAncestor(this);
        JPanel controlPanel = currentJFrame.getControlPanel();
        CardLayout layout = (CardLayout) controlPanel.getLayout();

        clearInput();
        layout.show(controlPanel, "bookingDetailPanel");
    }//GEN-LAST:event_backButtonActionPerformed

    private void clearInput() {
        bookingIdInput.setText("");
        customerIdInput.setText("");
        adminNameInput.setText("");
        clearCarsInComboBox();
        bookingDurationInput.setText("");
        statusInput.setText("");
        bookingDateInput.setText("");
    }
    
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        // TODO add your handling code here:
        Frame currentJFrame = (Frame) SwingUtilities.getWindowAncestor(this);
        JPanel controlPanel = currentJFrame.getControlPanel();
        CardLayout layout = (CardLayout) controlPanel.getLayout();

        String[] input = new String[7];
        input[0] = bookingIdInput.getText();
        input[1] = customerIdInput.getText();
        input[2] = adminNameInput.getText();
        input[3] = String.valueOf(carComboBox.getSelectedItem()).split(" ")[0];
        input[4] = bookingDurationInput.getText();
        input[5] = statusInput.getText();
        input[6] = bookingDateInput.getText();
        
        Booking booking = new Booking();
        boolean isBookingUpdateSuccessful = booking.update(bookingIdInput.getText(), input);
        if (isBookingUpdateSuccessful) {
            clearInput();
            currentJFrame.bookingListingPanel.buildTable(null, false, false);
            layout.show(controlPanel, "bookingListingPanel");
            JOptionPane.showMessageDialog(currentJFrame, "The booking has been edited successfully.");
        } else {
            JOptionPane.showMessageDialog(currentJFrame, booking.getValidationFailMessage());
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void adminNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminNameInputActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adminNameInput;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField bookingDateInput;
    private javax.swing.JLabel bookingDateLabel;
    private javax.swing.JTextField bookingDurationInput;
    private javax.swing.JLabel bookingDurationLabel;
    private javax.swing.JTextField bookingIdInput;
    private javax.swing.JComboBox<String> carComboBox;
    private javax.swing.JLabel carIdLabel;
    private javax.swing.JButton confirmButton;
    private javax.swing.JTextField customerIdInput;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField statusInput;
    // End of variables declaration//GEN-END:variables
}
