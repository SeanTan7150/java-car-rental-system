package Processes;

import Classes.User;
import DAO.UserDao;

public class LoginProcess {
    UserDao userDao = new UserDao();
    private String icno, password;
    private boolean exist;

    public void setLogin(String icno, String password) {
        this.icno = icno;
        this.password = password;
        this.exist = false;
    }

    public boolean getLogin() {
        for (User user : userDao.getAll()) {
            if ((icno.equals(user.getIcno())) && (password.equals(user.getPassword()))
                    && (user.getApproval().equals("YES"))) {
                UserDao.loggedIn = user;
                exist = true;
                break;
            }
        }
        return exist;
    }
}