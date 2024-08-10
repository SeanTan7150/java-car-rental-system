package DAO;

import Classes.User;
import carrentalsystem.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UserDao implements Dao<User> {
    public static ArrayList<User> users = new ArrayList<>();
    public static User loggedIn = null;
    private final String pathToDataFileDirectory, textFile;

    public UserDao() {
        this.pathToDataFileDirectory = Environment.pathToDataFileDirectory;
        this.textFile = "user.txt";
    }

    @Override
    public User get(String id) {
        for (User user : users) {
            if (user.getIcno().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public ArrayList<User> getAll() {
        if (users.isEmpty()) {
            return null;
        } else {
            return users;
        }
    }

    @Override
    public boolean add(User user, boolean isIdProvided) {
        users.add(user);
        writeDB();
        return true;
    }

    @Override
    public boolean update(String id, User updatedUser) {
        for (User user : users) {
            if (user.getIcno().equals(id)) {
                int index = users.indexOf(user);
                users.set(index, updatedUser);
                writeDB();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (User user : users) {
            if (user.getIcno().equals(id)) {
                int index = users.indexOf(user);
                users.remove(index);
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
                    users.add(new User(items[0], items[1], items[2], items[3], items[4], items[5], items[6], items[7],
                            items[8], items[9], items[10], items[11], items[12], items[13], items[14]));
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

            for (User user : users) {
                pw.println(user.getIcno() + ","
                        + user.getUsername() + ","
                        + user.getPassword() + ","
                        + user.getRole() + ","
                        + user.getEmail() + ","
                        + user.getPhone() + ","
                        + user.getGender() + ","
                        + user.getAddress1() + ","
                        + user.getAddress2() + ","
                        + user.getCity() + ","
                        + user.getZip() + ","
                        + user.getState() + ","
                        + user.getRegistered() + ","
                        + user.getCreditBalance() + ","
                        + user.getApproval());
            }
            pw.close();
        } catch (IOException Ex) {
            System.out.println("File Not Found. (" + textFile + ")");
        }
    }

    public ArrayList<User> searchRole(String role) {
        ArrayList<User> searches = new ArrayList<>();
        for (User user : users) {
            if (user.getRole().equals(role)) {
                searches.add(user);
            }
        }
        return searches;
    }

    public ArrayList<User> searchRole(String role1, String role2) {
        ArrayList<User> searches = new ArrayList<>();
        for (User user : users) {
            if (user.getRole().equals(role1)) {
                searches.add(user);
            }
            if (user.getRole().equals(role2)) {
                searches.add(user);
            }
        }
        return searches;
    }
}