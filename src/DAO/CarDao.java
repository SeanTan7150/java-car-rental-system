package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Classes.Car;
import carrentalsystem.Environment;

public class CarDao implements Dao<Car> {
    public static ArrayList<Car> cars = new ArrayList<>();
    private final String pathToDataFileDirectory, textFile;

    public CarDao() {
        this.pathToDataFileDirectory = Environment.pathToDataFileDirectory;
        this.textFile = "car.txt";
    }

    @Override
    public Car get(String id) {
        for (Car car : cars) {
            if (car.getCarId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Car> getAll() {
        if (cars.isEmpty())
            return null;
        else
            return cars;
    }

    @Override
    public boolean add(Car car, boolean isIdProvided) {
        cars.add(car);
        writeDB();
        return true;
    }

    @Override
    public boolean update(String id, Car updatedCar) {
        for (Car car : cars) {
            if (car.getCarId().equals(id)) {
                int index = cars.indexOf(car);
                cars.set(index, updatedCar);
                writeDB();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (Car car : cars) {
            if (car.getCarId().equals(id)) {
                int index = cars.indexOf(car);
                cars.remove(index);
                writeDB();
                return true;
            }
        }
        return false;
    }

    @Override
    public void readDB() {
        File file = new File(this.pathToDataFileDirectory + this.textFile);
        try {
            FileReader fr = new FileReader(file);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = br.readLine();

                while (line != null) {
                    String[] items = line.split(",");
                    cars.add(new Car(items[0], items[1], items[2], items[3], items[4], items[5], items[6]));
                    line = br.readLine();
                }
            }
        } catch (IOException ex) {
            System.out.println(ex + pathToDataFileDirectory + textFile);
        }
    }

    @Override
    public void writeDB() {
        try {
            FileWriter fileWriter = new FileWriter(this.pathToDataFileDirectory + this.textFile, false);
            PrintWriter pw = new PrintWriter(fileWriter);

            for (Car car : cars) {
                pw.println(
                        car.getCarId() + "," + car.getBrand() + "," + car.getModel() + "," + car.getColor() + ","
                                + car.getManufacturingYear()
                                + "," + car.getRentalPerDay() + "," + car.getLastServiceDate());
            }
            pw.close();
        } catch (IOException Ex) {
            System.out.println("File Not Found. (" + textFile + ")");
        }
    }
}