package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Classes.Booking;
import carrentalsystem.Environment;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookingDao implements Dao<Booking> {
    public static ArrayList<Booking> bookings = new ArrayList<>();
    private final String pathToDataFileDirectory, textFile;
    private static int currentBiggestId = 0;

    public BookingDao() {
        this.pathToDataFileDirectory = Environment.pathToDataFileDirectory;
        this.textFile = "booking.txt";
    }

    @Override
    public Booking get(String id) {
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(id)) {
                return booking;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Booking> getAll() {
        if (bookings.isEmpty())
            return null;
        else
            return bookings;
    }

    @Override
    public boolean add(Booking booking, boolean isIdProvided) {
        if (!isIdProvided) {
            booking.setBookingId(Integer.toString(++currentBiggestId));
        }
        bookings.add(booking);
        writeDB();
        return true;
    }

    @Override
    public boolean update(String id, Booking updatedBooking) {
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(id)) {
                int index = bookings.indexOf(booking);
                bookings.set(index, updatedBooking);
                writeDB();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(id)) {
                int index = bookings.indexOf(booking);
                bookings.remove(index);
                writeDB();
                return true;
            }
        }
        return false;
    }

    public boolean approve(String id) {
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(id)) {
                booking.setAdminId(UserDao.loggedIn.getIcno());
                booking.setStatus("approved");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                booking.setConfirmedDateTime(dtf.format(now));
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
        PaymentDao pd = new PaymentDao();

        try {
            FileReader fr = new FileReader(file);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = br.readLine();

                while (line != null) {
                    String[] items = line.split(",");
                    bookings.add(new Booking(items[0], items[1], items[2], items[3], items[4], items[5], items[6],
                            items[7], items[8], pd.searchBookingId(items[0])));
                    try {
                        int currentId = Integer.valueOf(items[0]);
                        if (currentId > biggestId) {
                            biggestId = currentId;
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Error: readDB of BookingDao");
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

            for (Booking booking : bookings) {
                pw.println(
                        booking.getBookingId() + "," + booking.getCustomerId() + "," + booking.getAdminId() + ","
                                + booking.getCarId()
                                + "," + booking.getBookingDuration() + "," + booking.getStatus() + ","
                                + booking.getBookingDate() + "," + booking.getRating() + ","
                                + booking.getConfirmedDateTime());
            }
            pw.close();
        } catch (IOException Ex) {
            System.out.println("File Not Found. (" + textFile + ")");
        }
    }

    public Booking getLastBooking() {
        int i = currentBiggestId;
        Booking booking = null;
        while (i >= 0) {
            try {
                booking = bookings.get(i);
                return booking;
            } catch (IndexOutOfBoundsException ex) {
                i--;
            }
        }
        return booking;
    }

    public ArrayList<Booking> getApproved() {
        ArrayList<Booking> searches = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getStatus().equals("approved")) {
                searches.add(booking);
            }
        }
        return searches;
    }
}
