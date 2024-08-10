package DAO;

import Classes.Payment;
import carrentalsystem.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PaymentDao implements Dao<Payment> {
    public static ArrayList<Payment> payments = new ArrayList<>();
    private final String pathToDataFileDirectory, textFile;
    private static int currentBiggestId = 0;

    public PaymentDao() {
        this.pathToDataFileDirectory = Environment.pathToDataFileDirectory;
        this.textFile = "payment.txt";
    }

    @Override
    public Payment get(String id) {
        for (Payment payment : payments) {
            if (payment.getPaymentId().equals(id)) {
                return payment;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Payment> getAll() {
        if (payments.isEmpty()) {
            return null;
        } else {
            return payments;
        }
    }

    @Override
    public boolean add(Payment payment, boolean isIdProvided) {
        if (!isIdProvided) {
            payment.setPaymentId(Integer.toString(++currentBiggestId));
        }
        payments.add(payment);
        writeDB();
        return true;
    }

    @Override
    public boolean update(String id, Payment updatedPayment) {
        for (Payment payment : payments) {
            if (payment.getPaymentId().equals(id)) {
                int index = payments.indexOf(payment);
                payments.set(index, updatedPayment);
                writeDB();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (Payment payment : payments) {
            if (payment.getPaymentId().equals(id)) {
                int index = payments.indexOf(payment);
                payments.remove(index);
                writeDB();
                return true;
            }
        }
        return false;
    }

    @Override
    public void readDB() {
        File file = new File(this.pathToDataFileDirectory + this.textFile);
        int biggestId = this.currentBiggestId;
        try {
            FileReader fr = new FileReader(file);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = br.readLine();

                while (line != null) {
                    String[] items = line.split(",");
                    payments.add(new Payment(items[0], items[1], items[2], items[3], items[4], items[5], items[6],
                            items[7]));

                    try {
                        int currentId = Integer.valueOf(items[0]);
                        if (currentId > biggestId) {
                            biggestId = currentId;
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Error: readDB of PaymentDao");
                    }

                    line = br.readLine();
                }
                this.currentBiggestId = biggestId;
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

            for (Payment payment : payments) {
                pw.println(payment.getPaymentId() + ","
                        + payment.getBookingId() + ","
                        + payment.getAdminId() + ","
                        + payment.getDatetime() + ","
                        + payment.getMethod() + ","
                        + payment.getAmount() + ","
                        + payment.getApproval() + ","
                        + payment.getBankId());
            }
            pw.close();
        } catch (IOException Ex) {
            System.out.println("File Not Found. (" + textFile + ")");
        }
    }

    public Payment searchBookingId(String id) {
        for (Payment payment : payments) {
            if (payment.getBookingId().equals(id)) {
                return payment;
            }
        }
        return null;
    }
}