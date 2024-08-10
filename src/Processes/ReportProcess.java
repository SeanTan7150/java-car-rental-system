package Processes;

import Classes.Booking;
import Classes.CreditBalanceDetail;
import Classes.User;
import DAO.BookingDao;
import DAO.CreditBalanceDetailDao;
import DAO.UserDao;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class ReportProcess {
    int currentMonth;
    int currentYear;
    
    BookingDao bookingDao;
    CreditBalanceDetailDao cbdd;
    UserDao ud;
    
    public ReportProcess() {
        Date today = new Date();
        SimpleDateFormat monthFormatter = new SimpleDateFormat("MM");  
        SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy");  
        currentMonth = Integer.parseInt(monthFormatter.format(today));
        currentYear = Integer.parseInt(yearFormatter.format(today));

        this.bookingDao = new BookingDao();
        this.cbdd = new CreditBalanceDetailDao();
        this.ud = new UserDao();
    }
    
    public void generateRentalBusinessReport() {
        ArrayList<Booking> bookings = bookingDao.getAll();
        
        if (bookings == null) {
            bookings = new ArrayList<>();
        }
        
        TimeSeriesCollection dataset = new TimeSeriesCollection(); 
        TimeSeries revenue = new TimeSeries("Revenue");  
        
        ArrayList<int[]> monthYear = this.getPast12Months();
        
        for (int[] data : monthYear) {
            double sum = 0;
            String month = Integer.toString(data[0]);
            String year = Integer.toString(data[1]);
            
            if (month.length() == 1) {
                month = "0" + month;
            }
            
            for (Booking booking : bookings) {
                String[] bookingDate = booking.getBookingDate().split("-");
                
                if (bookingDate[1].equals(month) && bookingDate[2].equals(year)) {
                    double amount = Double.parseDouble(booking.getPayment().getAmount());
                    sum = sum + amount;
                }
            }
            
            revenue.add(new Month(data[0], data[1]), sum);
        }

//        revenue.add(new Month(1, 2022), 50);
//        revenue.add(new Month(2, 2022), 60);
//        revenue.add(new Month(3, 2022), 70);
//        revenue.add(new Month(4, 2022), 40);
//        revenue.add(new Month(5, 2022), 30);
//        revenue.add(new Month(6, 2022), 60);
//        revenue.add(new Month(7, 2022), 70);
//        revenue.add(new Month(8, 2022), 50);
//        revenue.add(new Month(9, 2022), 90);
//        revenue.add(new Month(10, 2022), 100);
//        revenue.add(new Month(11, 2022), 50);
//        revenue.add(new Month(12, 2022), 50);
        dataset.addSeries(revenue);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(  
            "Rental Business Report", // Chart  
            "Month", // X-Axis Label  
            "Revenue (RM)", // Y-Axis Label  
            (XYDataset) dataset);
        
        ChartFrame chartFrame = new ChartFrame("Rental Business Report", chart, true);
        chartFrame.setVisible(true);
        chartFrame.setSize(900, 600);
    }
    
    private ArrayList<int[]> getPast12Months () {
        ArrayList<int[]> result = new ArrayList<>();
        int i = 0;
        int month;
        int year;
        
        if (currentMonth != 12) {
            month = currentMonth + 1;
            year = currentYear - 1;
        } else {
            month = 1;
            year = currentYear;
        }
        
        while (i < 12) {
            
            if (month > 12) {
                month = 1;
                year++;
            }
            
            int[] monthYear = {month, year};
            result.add(monthYear);
            
            month++;
            i++;
        }
        return result;
    }
    
    public void generatePopularCarReport() {
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        ArrayList<Booking> bookings = bookingDao.getAll();
        Map<String, Integer> cars = new HashMap<String, Integer>();
        
        if (bookings == null) {
            bookings = new ArrayList<>();
        }

        // put all cars into hashmap
        for (Booking booking : bookings) {
            String carId = booking.getCarId();
            
            if (cars.containsKey(carId)) {
                int oldValue = cars.get(booking.getCarId());
                cars.put(carId, oldValue + 1);
            } else {
                cars.put(carId, 1);
            }
        }
        
        int i = 0;
        while (i < 5) {
            ArrayList<String> carsToBeRemovedFromMap = new ArrayList<>();
            int maxValueInMap = 0;
            
            // try to find the biggest value aka the most popular car
            try {
                maxValueInMap = (Collections.max(cars.values()));
            } catch (NoSuchElementException ex) {
                break;
            }
            
            // put the most popular cars into dataset for chart
            for (Map.Entry<String, Integer> car : cars.entrySet()) {
                if (car.getValue() == maxValueInMap) {
                    String carId = car.getKey();
                    int numBooking = car.getValue();
 
                    dcd.setValue(numBooking, "Booking Count", carId);
                    carsToBeRemovedFromMap.add(carId);
                }
            }
            
            // remove the most popular cars
            for (String car : carsToBeRemovedFromMap) {
                cars.remove(car);
                i++;
            }
        }
        
//        dcd.setValue(100, "Booking Count", "Tesla Model X");
//        dcd.setValue(90, "Booking Count", "Tesla Model Y");
//        dcd.setValue(70, "Booking Count", "Toyota Vios");
//        dcd.setValue(50, "Booking Count", "Perodua Axia");
//        dcd.setValue(40, "Booking Count", "Proton X50");
        
        JFreeChart chart = ChartFactory.createBarChart("Popular Car Report", "Car Model", "Booking Count", dcd, PlotOrientation.VERTICAL, true, true, true);
        
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        
        ChartFrame chartFrame = new ChartFrame("Popular Car Report", chart, true);
        chartFrame.setVisible(true);
        chartFrame.setSize(900, 600);
    }
    
    public void generateCustomerGenderReport() {
        DefaultPieDataset dataset = new DefaultPieDataset();  
        ArrayList<User> users = ud.getAll();
        
        if (users == null) {
            users = new ArrayList<>();
        }
        
        int numMale = 0;
        int numFemale = 0;
        for (User user : users) {
            if (user.getGender().equals("F")) {
                numFemale++;
            } else if (user.getGender().equals("M")) {
                numMale++;
            }
        }
        
        dataset.setValue("Female", numFemale);
        dataset.setValue("Male", numMale);
        
//        dataset.setValue("80-100", 120);  
//        dataset.setValue("60-79", 80);  
//        dataset.setValue("40-59", 20);  
//        dataset.setValue("20-39", 7);  
//        dataset.setValue("0-19", 3);  
        
        JFreeChart chart = ChartFactory.createPieChart(  
        "Customer Gender Report",  
        (PieDataset) dataset,  
        true,   
        true,  
        false);  
        
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(  
            "{0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));  
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);  
        
        ChartFrame chartFrame = new ChartFrame("Customer Gender Report", chart, true);
        chartFrame.setVisible(true);
        chartFrame.setSize(900, 600);
    }
    
    public void generateCreditReloadReport() {
        ArrayList<CreditBalanceDetail> cbd = cbdd.getAll();
        TimeSeriesCollection dataset = new TimeSeriesCollection(); 
        TimeSeries revenue = new TimeSeries("Credit Reload");  
        
        if (cbd == null) {
            cbd = new ArrayList<>();
        }
        
        ArrayList<int[]> monthYear = this.getPast12Months();
        
        for (int[] data : monthYear) {
            double sum = 0;
            String month = Integer.toString(data[0]);
            String year = Integer.toString(data[1]);
            
            if (month.length() == 1) {
                month = "0" + month;
            }
            
            for (CreditBalanceDetail detail : cbd) {
                
                if (detail.getFlow().equals("IN")) {
                    String[] date = detail.getDatetime().split(" ")[0].split("/");

                    if (date[1].equals(month) && date[2].equals(year)) {
                        double amount = Double.parseDouble(detail.getAmount());
                        sum = sum + amount;
                    }
                }
            }
            
            revenue.add(new Month(data[0], data[1]), sum);
        }
        
//        revenue.add(new Month(1, 2022), 50);
//        revenue.add(new Month(2, 2022), 60);
//        revenue.add(new Month(3, 2022), 70);
//        revenue.add(new Month(4, 2022), 40);
//        revenue.add(new Month(5, 2022), 30);
//        revenue.add(new Month(6, 2022), 60);
//        revenue.add(new Month(7, 2022), 70);
//        revenue.add(new Month(8, 2022), 50);
//        revenue.add(new Month(9, 2022), 90);
//        revenue.add(new Month(10, 2022), 100);
//        revenue.add(new Month(11, 2022), 50);
//        revenue.add(new Month(12, 2022), 50);
        dataset.addSeries(revenue);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(  
            "Credit Reload Report", // Chart  
            "Month", // X-Axis Label  
            "Reload Amount (RM)", // Y-Axis Label  
            (XYDataset) dataset);
        
        ChartFrame chartFrame = new ChartFrame("Credit Reload Report", chart, true);
        chartFrame.setVisible(true);
        chartFrame.setSize(900, 600);
    }
    
    public void generateCustomerRatingReport() {
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        ArrayList<Booking> bookings = bookingDao.getAll();
        ArrayList<String> allRating = new ArrayList<>();
        
        if (bookings == null) {
            bookings = new ArrayList<>();
        }
        
        for (Booking booking : bookings) {
            allRating.add(booking.getRating());
        }
        
        int count_1 = Collections.frequency(allRating,"1"); 
        int count_2 = Collections.frequency(allRating,"2"); 
        int count_3 = Collections.frequency(allRating,"3"); 
        int count_4 = Collections.frequency(allRating,"4"); 
        int count_5 = Collections.frequency(allRating,"5"); 
        
        dcd.setValue(count_1, "Count", "1");
        dcd.setValue(count_2, "Count", "2");
        dcd.setValue(count_3, "Count", "3");
        dcd.setValue(count_4, "Count", "4");
        dcd.setValue(count_5, "Count", "5");
        
//        dcd.setValue(100, "Booking Count", "Ali");
//        dcd.setValue(90, "Booking Count", "Akau");
//        dcd.setValue(70, "Booking Count", "Muthu");
//        dcd.setValue(50, "Booking Count", "Jessica");
//        dcd.setValue(40, "Booking Count", "Felicia");
        
        JFreeChart chart = ChartFactory.createBarChart("Customer Rating Report", "Rating", "Count", dcd, PlotOrientation.VERTICAL, true, true, true);
        
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        
        ChartFrame chartFrame = new ChartFrame("Customer Rating Report", chart, true);
        chartFrame.setVisible(true);
        chartFrame.setSize(900, 600);
    }
}
