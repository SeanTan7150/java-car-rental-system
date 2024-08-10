package Validator;

import Classes.Car;
import DAO.CarDao;
import Processes.BookingProcess;
import java.text.ParseException;
import java.util.ArrayList;

public class BookingValidator {
    private final int maxDuration = 10;
    
    public void validateBookingCreationInput(Car car, String duration, String paymentMethod) {
        try {
            validateCarId(car);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid Car.");
        }
        
        try {
            validateDuration(duration);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid Duration.");
        }
    }
    
    private void validateCarId(Car car) {
        if (car == null) {
            throw new IllegalArgumentException();
        }
    }
    
    private void validateDuration(String duration) {
        int durationInt;
        try {
            durationInt = Integer.valueOf(duration);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
        if (durationInt > 10) {
            throw new IllegalArgumentException();
        }
    }
    
    public void validateBookingEditInput(String[] input) {
        BookingProcess bp = new BookingProcess();
        String carId = input[3];
        String duration = input[4];
        String bookingDate = input[6];
        ArrayList<Car> availableCars = new ArrayList<>();
        
        try {
            validateCarId(carId);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid Car.");
        }
        
        try {
            validateDuration(duration);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid Duration.");
        }
        
        DateTimeValidator dtValidator = new DateTimeValidator();
        try {
            dtValidator.validateDate(bookingDate);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid Booking Date.");
        }
        
        try {
            availableCars = bp.getAvailableCars(bookingDate, duration);
        } catch (ParseException ex) {}
        
        CarDao carDao = new CarDao();
        Car selectedCar = carDao.get(carId);
        if (!availableCars.contains(selectedCar)) {
            throw new IllegalArgumentException("Unavailable Car.");
        }
    }
    
    private void validateCarId(String carId) {
        if (carId.equals("") || carId == null) {
            throw new IllegalArgumentException();
        }
    }
}
