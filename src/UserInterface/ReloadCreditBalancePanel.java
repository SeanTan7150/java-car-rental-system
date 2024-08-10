package UserInterface;

import Classes.User;
import DAO.UserDao;
import Processes.ReloadCreditBalanceProcess;
import Validator.PaymentValidator;
import java.awt.CardLayout;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.text.ParseException;

public class ReloadCreditBalancePanel extends javax.swing.JPanel {
    private final DecimalFormat df = new DecimalFormat("0.00");
    private String reloadAmount;

    public ReloadCreditBalancePanel() {
        initComponents();
    }

    public void setReloadAmount(String reloadAmount) {
        double reload = Double.parseDouble(reloadAmount);
        this.reloadAmount = String.valueOf(reload);
    }

    public void reset() {
        FullNameTextField.setText("");
        CardNOTextField.setText("");
        ExpirationMonthTextField.setText("");
        ExpirationYearTextField.setText("");
        SecurityCodeTextField.setText("");
        ErrorLabel.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PaymentDetailsLabel = new javax.swing.JLabel();
        CardNOLabel = new javax.swing.JLabel();
        CardNOTextField = new javax.swing.JTextField();
        ExpirationDateLabel = new javax.swing.JLabel();
        ExpirationMonthTextField = new javax.swing.JTextField();
        ExpirationDateSeperatorLabel = new javax.swing.JLabel();
        ExpirationYearTextField = new javax.swing.JTextField();
        SecurityCodeLabel = new javax.swing.JLabel();
        SecurityCodeTextField = new javax.swing.JTextField();
        ConfirmButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        ErrorLabel = new javax.swing.JLabel();
        FullNameLabel = new javax.swing.JLabel();
        FullNameTextField = new javax.swing.JTextField();

        PaymentDetailsLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PaymentDetailsLabel.setText("Payment Details");

        CardNOLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CardNOLabel.setText("Card No.");

        CardNOTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        ExpirationDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ExpirationDateLabel.setText("Expiration Date");

        ExpirationMonthTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        ExpirationDateSeperatorLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ExpirationDateSeperatorLabel.setText("/");

        ExpirationYearTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        SecurityCodeLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SecurityCodeLabel.setText("Security Code");

        SecurityCodeTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        ConfirmButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ConfirmButton.setText("Confirm");
        ConfirmButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });

        BackButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BackButton.setText("Back");
        BackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        ErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ErrorLabel.setForeground(new java.awt.Color(255, 51, 51));

        FullNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        FullNameLabel.setText("Full Name");

        FullNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(264, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 377,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(99, 99, 99)
                                                        .addComponent(PaymentDetailsLabel))
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(BackButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 377,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ConfirmButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 377,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(ExpirationDateLabel)
                                                                .addComponent(CardNOLabel)
                                                                .addComponent(SecurityCodeLabel)
                                                                .addComponent(FullNameLabel))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(CardNOTextField,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 189,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        false)
                                                                        .addComponent(SecurityCodeTextField,
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                layout.createSequentialGroup()
                                                                                        .addComponent(
                                                                                                ExpirationMonthTextField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                38,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(
                                                                                                ExpirationDateSeperatorLabel)
                                                                                        .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(
                                                                                                ExpirationYearTextField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                38,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addComponent(FullNameTextField,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 239,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(259, 259, 259)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(PaymentDetailsLabel)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(FullNameLabel)
                                        .addComponent(FullNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CardNOLabel)
                                        .addComponent(CardNOTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ExpirationDateLabel)
                                        .addComponent(ExpirationMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ExpirationDateSeperatorLabel)
                                        .addComponent(ExpirationYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(SecurityCodeLabel)
                                        .addComponent(SecurityCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ConfirmButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BackButton)
                                .addContainerGap(202, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BackButtonActionPerformed
        reset();
        Frame f = (Frame) SwingUtilities.getWindowAncestor(this);
        f.CreditBalancePanel.setCreditBalance(UserDao.loggedIn);
        try {
            f.CreditBalancePanel.setCreditBalanceDetails();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        CardLayout cardLayout = (CardLayout) f.getControlPanel().getLayout();
        cardLayout.show(f.getControlPanel(), "creditBalancePanel");
    }// GEN-LAST:event_BackButtonActionPerformed

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ConfirmButtonActionPerformed
        String fullName = FullNameTextField.getText();
        String card = CardNOTextField.getText();
        String exp_month = ExpirationMonthTextField.getText();
        String exp_year = ExpirationYearTextField.getText();
        String cvv = SecurityCodeTextField.getText();

        PaymentValidator pv = new PaymentValidator();
        if (!fullName.trim().equals("") || !card.trim().equals("") || !exp_month.trim().equals("")
                || !exp_year.trim().equals("") || !cvv.trim().equals("")) {
            ErrorLabel.setText("");

            if (!pv.validateFullName(fullName)) {
                ErrorLabel.setText(pv.invalidFullName());
            } else if (!pv.validateCardNO(card)) {
                ErrorLabel.setText(pv.invalidCardNO());
            } else if (!pv.validateExpirationMonth(exp_month)) {
                ErrorLabel.setText(pv.invalidExpirationMonth());
            } else if (!pv.validateExpirationYear(exp_year)) {
                ErrorLabel.setText(pv.invalidExpirationYear());
            } else if (!pv.validateSecurityCode(cvv)) {
                ErrorLabel.setText(pv.invalidSecurityCode());
            } else {
                ErrorLabel.setText("");
                Frame f = (Frame) SwingUtilities.getWindowAncestor(this);
                User user = UserDao.loggedIn;

                String updatedAmount = String
                        .valueOf(df.format(Double.valueOf(user.getCreditBalance()) + Double.valueOf(reloadAmount)));
                String[] updatedInfo = { user.getIcno(), user.getUsername(), user.getPassword(), user.getRole(),
                        user.getEmail(), user.getPhone(), user.getGender(), user.getAddress1(), user.getAddress2(),
                        user.getCity(), user.getZip(), user.getState(), user.getRegistered(), updatedAmount,
                        user.getApproval() };
                ReloadCreditBalanceProcess rcbp = new ReloadCreditBalanceProcess(updatedInfo);

                if (rcbp.updateCreditBalance(UserDao.loggedIn)
                        && rcbp.updateInCreditBalanceDetails(String.valueOf(df.format(Double.valueOf(reloadAmount))))) {
                    reset();

                    f.CreditBalancePanel.setCreditBalance(user);
                    try {
                        f.CreditBalancePanel.setCreditBalanceDetails();
                    } catch (ParseException e) {
                        e.printStackTrace(); 
                    }
                    CardLayout cardLayout = (CardLayout) f.getControlPanel().getLayout();
                    cardLayout.show(f.getControlPanel(), "creditBalancePanel");
                } else {
                    reset();
                    JOptionPane.showMessageDialog(null, "Failed to reload credit balance.");
                }
            }
        } else {
            ErrorLabel.setText(pv.required());
        }
    }// GEN-LAST:event_ConfirmButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel CardNOLabel;
    private javax.swing.JTextField CardNOTextField;
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JLabel ExpirationDateLabel;
    private javax.swing.JLabel ExpirationDateSeperatorLabel;
    private javax.swing.JTextField ExpirationMonthTextField;
    private javax.swing.JTextField ExpirationYearTextField;
    private javax.swing.JLabel FullNameLabel;
    private javax.swing.JTextField FullNameTextField;
    private javax.swing.JLabel PaymentDetailsLabel;
    private javax.swing.JLabel SecurityCodeLabel;
    private javax.swing.JTextField SecurityCodeTextField;
    // End of variables declaration//GEN-END:variables
}