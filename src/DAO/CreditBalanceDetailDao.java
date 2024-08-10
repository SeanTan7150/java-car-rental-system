package DAO;

import Classes.CreditBalanceDetail;
import carrentalsystem.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CreditBalanceDetailDao implements Dao<CreditBalanceDetail> {
    public static ArrayList<CreditBalanceDetail> creditBalanceDetails = new ArrayList<>();
    private final String pathToDataFileDirectory, textFile;
    private static int currentBiggestId = 0;

    public CreditBalanceDetailDao() {
        this.pathToDataFileDirectory = Environment.pathToDataFileDirectory;
        this.textFile = "creditBalanceDetails.txt";
    }

    @Override
    public CreditBalanceDetail get(String id) {
        for (CreditBalanceDetail creditBalanceDetail : creditBalanceDetails) {
            if (creditBalanceDetail.getCreditBalanceDetailId().equals(id)) {
                return creditBalanceDetail;
            }
        }
        return null;
    }

    @Override
    public ArrayList<CreditBalanceDetail> getAll() {
        if (creditBalanceDetails.isEmpty()) {
            return null;
        } else {
            return creditBalanceDetails;
        }
    }

    @Override
    public boolean add(CreditBalanceDetail creditBalanceDetail, boolean isIdProvided) {
        if (!isIdProvided) {
            creditBalanceDetail.setCreditBalanceDetailId(Integer.toString(++currentBiggestId));
        }
        creditBalanceDetails.add(creditBalanceDetail);
        writeDB();
        return true;
    }

    @Override
    public boolean update(String id, CreditBalanceDetail updatedCreditBalanceDetail) {
        for (CreditBalanceDetail creditBalanceDetail : creditBalanceDetails) {
            if (creditBalanceDetail.getCreditBalanceDetailId().equals(id)) {
                int index = creditBalanceDetails.indexOf(creditBalanceDetail);
                creditBalanceDetails.set(index, updatedCreditBalanceDetail);
                writeDB();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (CreditBalanceDetail creditBalanceDetail : creditBalanceDetails) {
            if (creditBalanceDetail.getCreditBalanceDetailId().equals(id)) {
                int index = creditBalanceDetails.indexOf(creditBalanceDetail);
                creditBalanceDetails.remove(index);
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
                    creditBalanceDetails
                            .add(new CreditBalanceDetail(items[0], items[1], items[2], items[3], items[4], items[5]));

                    try {
                        int currentId = Integer.valueOf(items[0]);
                        if (currentId > biggestId) {
                            biggestId = currentId;
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Error: readDB of CreditBalanceDetailDao");
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

            for (CreditBalanceDetail creditBalanceDetail : creditBalanceDetails) {
                pw.println(creditBalanceDetail.getCreditBalanceDetailId() + ","
                        + creditBalanceDetail.getIcno() + ","
                        + creditBalanceDetail.getDatetime() + ","
                        + creditBalanceDetail.getFlow() + ","
                        + creditBalanceDetail.getAmount() + ","
                        + creditBalanceDetail.getFinalAmount());
            }
            pw.close();
        } catch (IOException Ex) {
            System.out.println("File Not Found. (" + textFile + ")");
        }
    }

    public ArrayList<CreditBalanceDetail> searchUser(String icno) {
        ArrayList<CreditBalanceDetail> searches = new ArrayList<>();
        for (CreditBalanceDetail creditBalanceDetail : creditBalanceDetails) {
            if (creditBalanceDetail.getIcno().equals(icno)) {
                searches.add(creditBalanceDetail);
            }
        }
        return searches;
    }
}