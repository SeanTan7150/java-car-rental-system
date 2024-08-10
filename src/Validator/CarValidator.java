package Validator;

import Classes.Car;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarValidator {
    private final String validCarIdRegex = "[a-zA-Z]{3}[0-9]{4}";

    public void validateCarCreationInput(String[] input) {
        DateTimeValidator dateTimeValidator = new DateTimeValidator();
        String id = input[0];
        String manufacturingYear = input[4];
        String rentalPerDay = input[5];
        String lastServiceDate = input[6];

        try {
            validateCarId(id);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Car ID.");
        }

        try {
            dateTimeValidator.validateYear(manufacturingYear);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Manufacturing Year.");
        }

        try {
            validateRentalPerDay(rentalPerDay);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Rental Per Day.");
        }

        try {
            dateTimeValidator.validateDate(lastServiceDate);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Last Service Date.");
        }
    }

    private void validateCarId(String carId) {
        if (isCarIdTaken(carId) || !isCarIdInlineWithFormat(carId)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isCarIdInlineWithFormat(String carId) {
        Pattern p = Pattern.compile(validCarIdRegex);
        Matcher m = p.matcher(carId);
        return m.matches();
    }

    private boolean isCarIdTaken(String carId) {
        Car car = new Car(carId);

        if (car.getCarId() == null) {
            return false;
        }
        return true;
    }

    private void validateRentalPerDay(String rentalPerDay) {
        if (Integer.valueOf(rentalPerDay) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public void validateCarEditInput(String[] input) {
        DateTimeValidator dateTimeValidator = new DateTimeValidator();
        String manufacturingYear = input[4];
        String lastServiceDate = input[6];

        try {
            dateTimeValidator.validateYear(manufacturingYear);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Manufacturing Year.");
        }

        try {
            dateTimeValidator.validateDate(lastServiceDate);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Last Service Date.");
        }
    }
}
