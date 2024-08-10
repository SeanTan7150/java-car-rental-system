package carrentalsystem;

import DAO.BookingDao;
import DAO.BookingDateDao;
import UserInterface.*;
import java.util.HashMap;
import javax.swing.JPanel;

import DAO.CarDao;
import DAO.CreditBalanceDetailDao;
import DAO.PaymentDao;
import DAO.UserDao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Environment extends javax.swing.JFrame {
    // sean
    public final StartPanel HomePanel = new StartPanel();
    public final LoginPanel LoginPanel = new LoginPanel();
    public final RegisterPanel RegisterPanel = new RegisterPanel();
    public final AdminHomePanel AdminHomePanel = new AdminHomePanel();
    public final CustHomePanel CustHomePanel = new CustHomePanel();
    public final ProfilePanel ProfilePanel = new ProfilePanel();
    public final AdminViewUserPanel AdminViewUserPanel = new AdminViewUserPanel();
    public final AdminViewUserDetailsPanel AdminViewUserDetailsPanel = new AdminViewUserDetailsPanel();
    public final AdminRegisterUserPanel AdminRegisterUserPanel = new AdminRegisterUserPanel();
    public final CreditBalancePanel CreditBalancePanel = new CreditBalancePanel();
    public final ReloadCreditBalancePanel ReloadCreditBalancePanel = new ReloadCreditBalancePanel();
    public final AdminViewPaymentDetailsPanel AdminViewPaymentDetailsPanel = new AdminViewPaymentDetailsPanel();
    public final AdminReturnCarPanel AdminReturnCarPanel = new AdminReturnCarPanel();

    // wk
    public CarListingPanel carListingPanel = new CarListingPanel();
    public CarCreatingPanel carCreatingPanel = new CarCreatingPanel();
    public CarDetailPanel carDetailPanel = new CarDetailPanel();
    public CarEditingPanel carEditingPanel = new CarEditingPanel();
    public BookingListingPanel bookingListingPanel = new BookingListingPanel();
    public BookingCreatingPanel bookingCreatingPanel = new BookingCreatingPanel();
    public BookingDetailPanel bookingDetailPanel = new BookingDetailPanel();
    public BookingEditingPanel bookingEditingPanel = new BookingEditingPanel();
    public BookingHistoryPanel bookingHistoryPanel = new BookingHistoryPanel();
    public ReportMenuPanel reportMenuPanel = new ReportMenuPanel();
    public RentalBusinessReportPanel rentalBusinessReportPanel = new RentalBusinessReportPanel();

    // IMPORTANT! CONFIGURE PATH BEFORE BUILD
    public final static String pathToDataFileDirectory = "C:\\Users\\xiuha\\OneDrive\\Desktop\\CarRentalSystem\\src\\DataFiles\\";

    public HashMap<String, JPanel> getAllPanels() {
        HashMap panels = new HashMap<String, JPanel>();

        // sean
        panels.put("homePanel", HomePanel);
        panels.put("loginPanel", LoginPanel);
        panels.put("registerPanel", RegisterPanel);
        panels.put("adminHomePanel", AdminHomePanel);
        panels.put("custHomePanel", CustHomePanel);
        panels.put("profilePanel", ProfilePanel);
        panels.put("adminViewCustPanel", AdminViewUserPanel);
        panels.put("adminViewCustDetailsPanel", AdminViewUserDetailsPanel);
        panels.put("adminRegisterCustPanel", AdminRegisterUserPanel);
        panels.put("creditBalancePanel", CreditBalancePanel);
        panels.put("reloadCreditBalancePanel", ReloadCreditBalancePanel);
        panels.put("adminViewPaymentDetailsPanel", AdminViewPaymentDetailsPanel);
        panels.put("adminReturnCarPanel", AdminReturnCarPanel);

        // wk
        panels.put("carListingPanel", carListingPanel);
        panels.put("carCreatingPanel", carCreatingPanel);
        panels.put("carDetailPanel", carDetailPanel);
        panels.put("carEditingPanel", carEditingPanel);
        panels.put("bookingListingPanel", bookingListingPanel);
        panels.put("bookingCreatingPanel", bookingCreatingPanel);
        panels.put("bookingDetailPanel", bookingDetailPanel);
        panels.put("bookingEditingPanel", bookingEditingPanel);
        panels.put("bookingHistoryPanel", bookingHistoryPanel);
        panels.put("reportMenuPanel", reportMenuPanel);
        panels.put("rentalBusinessReportPanel", rentalBusinessReportPanel);

        return panels;
    }

    public static void initializeDB() {
        PaymentDao paymentDao = new PaymentDao();
        CarDao carDao = new CarDao();
        BookingDao bookingDao = new BookingDao();
        BookingDateDao bookingDateDao = new BookingDateDao();
        UserDao userDao = new UserDao();
        CreditBalanceDetailDao creditBalanceDetailDao = new CreditBalanceDetailDao();

        userDao.readDB();
        creditBalanceDetailDao.readDB();
        paymentDao.readDB();
        carDao.readDB();
        bookingDao.readDB();
        bookingDateDao.readDB();
    }
}
