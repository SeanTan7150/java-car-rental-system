package Classes;

import DAO.BookingDao;
import DAO.BookingDateDao;
import DAO.CarDao;
import Processes.BookingProcess;
import Validator.BookingValidator;
import java.text.ParseException;
import java.util.ArrayList;

public final class Booking {
    private String bookingId;
    private String customerId;
    private String adminId;
    private String carId;
    private String bookingDuration;
    private String status;
    private String date;
    private String rating;
    private String confirmedDateTime;
    private Payment payment;

    private String validationFailMessage = "Failed to add booking.";

    public Booking() {
    }

    public Booking(String id) {
        BookingDao bookingDao = new BookingDao();
        Booking booking = bookingDao.get(id);

        if (booking != null) {
            setBookingId(booking.getBookingId());
            setCustomerId(booking.getCustomerId());
            setAdminId(booking.getAdminId());
            setCarId(booking.getCarId());
            setBookingDuration(booking.getBookingDuration());
            setStatus(booking.getStatus());
            setBookingDate(booking.getBookingDate());
            setRating(booking.getRating());
            setConfirmedDateTime(booking.getConfirmedDateTime());
            setPayment(booking.getPayment());
        }
    }

    public Booking(String id, String customerId, String adminId, String carId, String bookingDuration, String status,
            String bookingDate, String rating, String confirmDateTime, Payment payment) {
        this.bookingId = id;
        this.customerId = customerId;
        this.adminId = adminId;
        this.carId = carId;
        this.bookingDuration = bookingDuration;
        this.status = status;
        this.date = bookingDate;
        this.rating = rating;
        this.confirmedDateTime = confirmDateTime;
        this.payment = payment;
    }

    public Booking getLastBooking() {
        BookingDao bookingDao = new BookingDao();
        Booking lastBooking = bookingDao.getLastBooking();
        return lastBooking;
    }

    public boolean add(String currentUserIcNo, String startDate, String duration, String selectedCar, String paymentMethod,
            String transferReferenceId) {
        BookingProcess bp = new BookingProcess();
        BookingDao bookingDao = new BookingDao();
        CarDao carDao = new CarDao();
        BookingDateDao bookingDateDao = new BookingDateDao();
        String carId = selectedCar.split(" ")[0];
        Car car = carDao.get(carId);
        
        try {
            ArrayList<String> dates = bp.generateAllDates(startDate, duration);
            
            for (String date : dates) {
                bookingDateDao.add(date, car);
            }
        } catch (ParseException ex) {}

        Booking booking = new Booking("", currentUserIcNo, "", carId, duration, "pending for confirmation",
                startDate, "", "null", new Payment());
        boolean isBookingCreationSuccessful = bookingDao.add(booking, false);


        return isBookingCreationSuccessful;
    }

    public boolean update(String bookingId, String[] input) {
        BookingValidator bookingValidator = new BookingValidator();

        try {
            bookingValidator.validateBookingEditInput(input);
        } catch (IllegalArgumentException e) {
            setValidationFailMessage(e.getMessage());
            return false;
        }

        BookingDao bookingDao = new BookingDao();
        CarDao carDao = new CarDao();
        Booking booking = bookingDao.get(input[0]);

        Car originalCar = carDao.get(booking.getCarId());
        String originalBookingDuration = booking.getBookingDuration();
        String originalBookingDate = booking.getBookingDate();

        booking.setCarId(input[3]);
        Car newCar = carDao.get(input[3]);
        booking.setBookingDuration(input[4]);
        booking.setBookingDate(input[6]);
        boolean isBookingUpdateSuccessful = bookingDao.update(bookingId, booking);

        BookingProcess bp = new BookingProcess();
        try {
            BookingDateDao bookingDateDao = new BookingDateDao();

            ArrayList<String> originalDates = bp.generateAllDates(originalBookingDate, originalBookingDuration);
            ArrayList<String> newDates = bp.generateAllDates(input[6], input[4]);

            originalDates.forEach((date) -> {
                bookingDateDao.remove(date, originalCar);
            });

            newDates.forEach((date) -> {
                bookingDateDao.add(date, newCar);
            });

            bookingDateDao.writeDB();
        } catch (ParseException ex) {
        }

        return isBookingUpdateSuccessful;
    }

    public boolean delete(String bookingId) {
        BookingDao bookingDao = new BookingDao();
        boolean isBookingDeletionSuccessful = bookingDao.delete(bookingId);
        return isBookingDeletionSuccessful;
    }

    public boolean approve(String bookingId) {
        BookingDao bookingDao = new BookingDao();
        boolean isBookingApprovalSuccessful = bookingDao.approve(bookingId);
        return isBookingApprovalSuccessful;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getCarId() {
        return carId;
    }

    public String getBookingDuration() {
        return bookingDuration;
    }

    public String getStatus() {
        return status;
    }

    public String getBookingDate() {
        return date;
    }
    
    public String getRating() {
        return rating;
    }

    public String getConfirmedDateTime() {
        return confirmedDateTime;
    }

    public Payment getPayment() {
        return payment;
    }

    public String getValidationFailMessage() {
        return validationFailMessage;
    }

    public void setBookingId(String input) {
        bookingId = input;
    }

    public void setCustomerId(String input) {
        customerId = input;
    }

    public void setAdminId(String input) {
        adminId = input;
    }

    public void setCarId(String input) {
        carId = input;
    }

    public void setBookingDuration(String input) {
        bookingDuration = input;
    }

    public void setStatus(String input) {
        status = input;
    }

    public void setBookingDate(String input) {
        date = input;
    }
    
    public void setRating(String input) {
        rating = input;
    }

    public void setConfirmedDateTime(String input) {
        confirmedDateTime = input;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setValidationFailMessage(String input) {
        validationFailMessage = input;
    }
}
