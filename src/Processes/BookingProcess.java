package Processes;

import DAO.BookingDao;
import DAO.BookingDateDao;
import DAO.CarDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classes.Booking;
import Classes.Car;
import DAO.UserDao;

public class BookingProcess {
    public void buildTable(JTable table, String source, String idToBeSearched, boolean filterPendingApproval, boolean filterUnpaid) {
        ArrayList<Booking> bookings = new ArrayList<>();

        initializeTable(table);

        if (idToBeSearched == null) {
            BookingDao bookingDao = new BookingDao();
            ArrayList<Booking> allBookings = bookingDao.getAll();
            if (allBookings != null) {
                for (int i = 0; i < allBookings.size(); ++i) {
                    bookings.add(allBookings.get(i));
                }
            }
        } else {
            BookingDao bookingDao = new BookingDao();
            Booking booking = bookingDao.get(idToBeSearched);
            if (booking != null) {
                bookings.add(booking);
            }
        }
        
        if (filterPendingApproval) {
            bookings.removeIf(booking -> ! booking.getStatus().equals("pending for confirmation"));
        }

        if (filterUnpaid) {
            bookings.removeIf(booking -> booking.getPayment().getApproval().equals("Verified"));
        }
        
        if (source.equals("Booking History")) {
            bookings.removeIf(booking -> ! booking.getCustomerId().equals(UserDao.loggedIn.getIcno()));
        }
        
        tabulateBookings(table, bookings);
    }

    private void initializeTable(JTable table) {
        configureTableHeaders(table);
        makeTableEmpty(table);
    }

    private void configureTableHeaders(JTable table) {
        DefaultTableModel objModel = (DefaultTableModel) table.getModel();
        objModel.setColumnCount(0);
        objModel.addColumn("Booking ID");
        objModel.addColumn("Car ID");
        objModel.addColumn("Booking Date");
        objModel.addColumn("Customer Name");
        objModel.addColumn("Status");
        objModel.addColumn("Payment Status");
    }

    private void makeTableEmpty(JTable table) {
        DefaultTableModel objModel = (DefaultTableModel) table.getModel();
        objModel.setRowCount(0);
    }

    private void tabulateBookings(JTable table, ArrayList<Booking> bookings) {
        UserDao ud = new UserDao();
        DefaultTableModel objModel = (DefaultTableModel) table.getModel();
        String[] row = new String[6];

        for (Booking booking : bookings) {
            row[0] = booking.getBookingId();
            row[1] = booking.getCarId();
            row[2] = booking.getBookingDate();
            row[3] = ud.get(booking.getCustomerId()).getUsername();
            row[4] = booking.getStatus();
            row[5] = booking.getPayment().getApproval();

            objModel.addRow(row);
        }
    }

    public ArrayList<Car> getAvailableCars(String startDate, String duration) throws ParseException {
        CarDao carDao = new CarDao();
        BookingDateDao bookingDateDao = new BookingDateDao();

        ArrayList<Car> allUnavailableCars = new ArrayList<>();
        ArrayList<Car> availableCars = new ArrayList<>();
        ArrayList<Car> allCars = carDao.getAll();
        ArrayList<String> dates = generateAllDates(startDate, duration);

        for (String date : dates) {
            ArrayList<Car> unavailableCar = bookingDateDao.get(date);
            try {
                allUnavailableCars.addAll(unavailableCar);
            } catch (NullPointerException ex) {}
        }

        if (allCars != null) {
            for (Car car : allCars) {
                if (!allUnavailableCars.contains(car)) {
                    availableCars.add(car);
                }
            }
        }
        return availableCars;
    }
    
    public ArrayList<Car> getAvailableCars(String startDate, String duration, Booking bookingToBeIgnored) throws ParseException {
        CarDao carDao = new CarDao();
        BookingDateDao bookingDateDao = new BookingDateDao();

        ArrayList<Car> allUnavailableCars = new ArrayList<>();
        ArrayList<Car> availableCars = new ArrayList<>();
        ArrayList<Car> allCars = carDao.getAll();
        ArrayList<String> dates = generateAllDates(startDate, duration);
        ArrayList<String> datesToBeIgnored = generateAllDates(bookingToBeIgnored.getBookingDate(), bookingToBeIgnored.getBookingDuration());
        String carToBeIgnored = bookingToBeIgnored.getCarId();

        for (String date : dates) {
            ArrayList<Car> unavailableCar = bookingDateDao.get(date);
            try {
                allUnavailableCars.addAll(unavailableCar);
            } catch (NullPointerException ex) {}
            
            if (datesToBeIgnored.contains(date)) {
                allUnavailableCars.removeIf(car -> (car.getCarId().equals(carToBeIgnored)));
            }
        }

        if (allCars != null) {
            for (Car car : allCars) {
                if (!allUnavailableCars.contains(car)) {
                    availableCars.add(car);
                }
            }
        }
        return availableCars;
    }

    public ArrayList<String> generateAllDates(String startDate, String duration) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = format.parse(startDate);
        Calendar c = Calendar.getInstance();
        int durationInt = Integer.parseInt(duration);
        ArrayList<String> allDates = new ArrayList<>();

        c.setTime(date);

        for (int i = 0; i < durationInt; i++) {
            date = c.getTime();
            allDates.add(format.format(date));
            c.add(Calendar.DATE, 1);
        }

        return allDates;
    }
}
