package UserInterface;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestJFrame extends javax.swing.JFrame {
    public CarListingPanel carListingPanel = new CarListingPanel();
    public CarCreatingPanel carCreatingPanel = new CarCreatingPanel();
    public CarDetailPanel carDetailPanel = new CarDetailPanel();
    public CarEditingPanel carEditingPanel = new CarEditingPanel();
    public BookingListingPanel bookingListingPanel = new BookingListingPanel();
    public BookingCreatingPanel bookingCreatingPanel = new BookingCreatingPanel();
    public BookingDetailPanel bookingDetailPanel = new BookingDetailPanel();

    public TestJFrame() {
        initComponents();
        setTitle("Car Rental System");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ControlPanel.add("carListingPanel", carListingPanel);
        ControlPanel.add("carCreatingPanel", carCreatingPanel);
        ControlPanel.add("carDetailPanel", carDetailPanel);
        ControlPanel.add("carEditingPanel", carEditingPanel);
        ControlPanel.add("bookingListingPanel", bookingListingPanel);
        ControlPanel.add("bookingCreatingPanel", bookingCreatingPanel);
        ControlPanel.add("bookingDetailPanel", bookingDetailPanel);

        CardLayout cardLayout = (CardLayout)ControlPanel.getLayout();
        cardLayout.show(ControlPanel, "carListingPanel");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ControlPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ControlPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(ControlPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestJFrame().setVisible(true);
            }
        });
    }
    
    public JPanel getControlPanel() {
        return ControlPanel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ControlPanel;
    // End of variables declaration//GEN-END:variables
}
