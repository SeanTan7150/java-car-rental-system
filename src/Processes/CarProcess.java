package Processes;

import DAO.CarDao;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classes.Car;

public class CarProcess implements UserInterfaceInterface {
    public void buildTable(JTable table, String idToBeSearched) {
        ArrayList<Car> cars;

        initializeTable(table);

        if (idToBeSearched == null) {
            CarDao carDao = new CarDao();
            cars = carDao.getAll();
            if (cars == null) {
                cars = new ArrayList<Car>();
            }
        } else {
            CarDao carDao = new CarDao();
            Car car = carDao.get(idToBeSearched);
            cars = new ArrayList<Car>();
            if (car != null) {
                cars.add(car);
            }
        }

        tabulateCars(table, cars);
    }

    private void initializeTable(JTable table) {
        configureTableHeaders(table);
        makeTableEmpty(table);
    }

    private void configureTableHeaders(JTable table) {
        DefaultTableModel objModel = (DefaultTableModel) table.getModel();
        objModel.setColumnCount(0);
        objModel.addColumn("Car ID");
        objModel.addColumn("Car Model");
        objModel.addColumn("Car Manufacturing Year");
        objModel.addColumn("Rental Per Day");
    }

    private void makeTableEmpty(JTable table) {
        DefaultTableModel objModel = (DefaultTableModel) table.getModel();
        objModel.setRowCount(0);
    }

    private void tabulateCars(JTable table, ArrayList<Car> cars) {
        DefaultTableModel objModel = (DefaultTableModel) table.getModel();
        String[] row = new String[4];

        for (Car car : cars) {
            row[0] = car.getCarId();
            row[1] = car.getBrand() + " " + car.getModel() + " (" + car.getColor() + ")";
            row[2] = car.getManufacturingYear();
            row[3] = car.getRentalPerDay();

            objModel.addRow(row);
        }
    }
}
