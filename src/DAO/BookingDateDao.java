package DAO;

import Classes.Car;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import carrentalsystem.Environment;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class BookingDateDao {
    private static final HashMap<String, ArrayList<Car>> allBookingDates = new HashMap<>();
    private final String pathToDataFileDirectory, textFile;

    public BookingDateDao() {
        this.pathToDataFileDirectory = Environment.pathToDataFileDirectory;
        this.textFile = "booking_date.txt";
    }

    public ArrayList<Car> get(String dateInput) {
        return allBookingDates.get(dateInput);
    };

    public void add(String dateInput, Car car) {
        ArrayList<Car> cars;
        if (allBookingDates.containsKey(dateInput)) {
            cars = allBookingDates.get(dateInput);
        } else {
            cars = new ArrayList<>();
        }

        cars.add(car);
        allBookingDates.put(dateInput, cars);
        writeDB();
    };

    public void remove(String dateInput, Car car) {
        ArrayList<Car> cars;
        if (allBookingDates.containsKey(dateInput)) {
            cars = allBookingDates.get(dateInput);
            cars.remove(car);
            if (cars.isEmpty()) {
                allBookingDates.remove(dateInput);
            } else {
                allBookingDates.put(dateInput, cars);
            }
        }
        writeDB();
    };

    public void readDB() {
        CarDao carDao = new CarDao();
        File file = new File(this.pathToDataFileDirectory + this.textFile);

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                String[] splittedLine = line.split(":");
                String date = splittedLine[0];
                String carIdString = splittedLine[1];
                String[] carId = carIdString.split(",");
                ArrayList<Car> cars = new ArrayList<>();
                for (String id : carId) {
                    Car car = carDao.get(id);
                    cars.add(car);
                }
                allBookingDates.put(date, cars);

                line = br.readLine();
            }
            br.close();
        } catch (IOException Ex) {
            System.out.println("File Not Found.");
        }
    };

    public void writeDB() {
        try {
            FileWriter fileWriter = new FileWriter(this.pathToDataFileDirectory + this.textFile, false);
            PrintWriter pw = new PrintWriter(fileWriter);

            allBookingDates.forEach((date, cars) -> {
                String carIdString = "";
                for (Car car : cars) {
                    carIdString = carIdString + car.getCarId() + ",";
                }
                String finalizedCarIdString = carIdString.substring(0, carIdString.length() - 1);
                pw.println(date + ":" + finalizedCarIdString);
            });

            pw.close();
        } catch (IOException Ex) {
            System.out.println("File Not Found. (" + textFile + ")");
        }
    }
}
