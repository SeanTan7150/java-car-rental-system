package Classes;

import DAO.CarDao;
import Validator.CarValidator;

public class Car {
    private String carId = null;
    private String brand = null;
    private String model = null;
    private String color = null;
    private String manufacturingYear = null;
    private String rentalPerDay = null;
    private String lastServiceDate = null;

    private String validationFailMessage = "Failed to add car.";

    public Car() {
    }

    public Car(String id) {
        CarDao carDao = new CarDao();
        Car car = carDao.get(id);

        if (car != null) {
            setCarId(car.getCarId());
            setBrand(car.getBrand());
            setModel(car.getModel());
            setColor(car.getColor());
            setManufacturingYear(car.getManufacturingYear());
            setRentalPerDay(car.getRentalPerDay());
            setLastServiceDate(car.getLastServiceDate());
        }
    }

    public Car(String id, String brand, String model, String color, String manufacturingYear, String rentalPerDay,
            String lastServiceDate) {
        this.carId = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.manufacturingYear = manufacturingYear;
        this.rentalPerDay = rentalPerDay;
        this.lastServiceDate = lastServiceDate;
    }

    public boolean add(String[] input) {
        CarValidator carValidator = new CarValidator();

        try {
            carValidator.validateCarCreationInput(input);
        } catch (IllegalArgumentException e) {
            setValidationFailMessage(e.getMessage());
            return false;
        }

        CarDao carDao = new CarDao();
        Car car = new Car(input[0], input[1], input[2], input[3], input[4], input[5], input[6]);
        boolean isCarCreationSuccessful = carDao.add(car, true);
        return isCarCreationSuccessful;
    }

    public boolean update(String carId, String[] input) {
        CarValidator carValidator = new CarValidator();

        try {
            carValidator.validateCarEditInput(input);
        } catch (IllegalArgumentException e) {
            setValidationFailMessage(e.getMessage());
            return false;
        }

        CarDao carDao = new CarDao();
        Car car = new Car(input[0], input[1], input[2], input[3], input[4], input[5], input[6]);
        boolean isCarUpdateSuccessful = carDao.update(carId, car);
        return isCarUpdateSuccessful;
    }

    public boolean delete(String carId) {
        CarDao carDao = new CarDao();
        boolean isCarDeletionSuccessful = carDao.delete(carId);
        return isCarDeletionSuccessful;
    }

    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getManufacturingYear() {
        return manufacturingYear;
    }

    public String getRentalPerDay() {
        return rentalPerDay;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public String getValidationFailMessage() {
        return validationFailMessage;
    }

    private void setCarId(String input) {
        carId = input;
    }

    private void setBrand(String input) {
        brand = input;
    }

    private void setModel(String input) {
        model = input;
    }

    private void setColor(String input) {
        color = input;
    }

    private void setManufacturingYear(String input) {
        manufacturingYear = input;
    }

    private void setRentalPerDay(String input) {
        rentalPerDay = input;
    }

    private void setLastServiceDate(String input) {
        lastServiceDate = input;
    }

    private void setValidationFailMessage(String input) {
        validationFailMessage = input;
    }
}
