package carrentalsystem;

import UserInterface.Frame;

public class CarRentalSystem {
    public static void main(String[] args) throws InterruptedException {
        Environment.initializeDB();
        Frame f = new Frame();
        f.setVisible(true);
    }
}