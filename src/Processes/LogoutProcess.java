package Processes;

import DAO.UserDao;
import UserInterface.Frame;
import java.awt.CardLayout;

public class LogoutProcess {
    public void logout(Frame f) {
        UserDao.loggedIn = null;
        CardLayout cardLayout = (CardLayout) f.getControlPanel().getLayout();
        cardLayout.show(f.getControlPanel(), "loginPanel");
    }
}