package Processes;

import Classes.Current;
import Classes.User;
import DAO.UserDao;
import java.util.ArrayList;

public class RegisterProcess {
    UserDao userDao = new UserDao();
    User user = new User();
    Current c = new Current();

    private final String username, icno, password, email, phone, gender, address1, address2, city, zip, state;
    private boolean exist;

    public RegisterProcess(String username, String icno, String password, String email, String phone, String gender,
            String address1, String address2, String city, String zip, String state) {
        this.username = username;
        this.icno = icno;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.exist = false;
    }

    public boolean userExisted() {
        ArrayList<User> userDetails = userDao.getAll();
        if (userDetails != null) {
            for (User userDetail : userDetails) {
                if ((icno.equals(userDetail.getIcno()))) {
                    exist = true;
                    break;
                }
            }
        }
        return exist;
    }

    public String userExistedMessage() {
        return "User existed!";
    }

    public boolean registerSuccess(String role, String approval) {
        String registered = c.datetime;
        String credit_balance = "0.00";

        user.setIcno(icno);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        user.setEmail(email);
        user.setPhone(phone);
        user.setGender(gender);
        user.setAddress1(address1);
        user.setAddress2(address2);
        user.setCity(city);
        user.setZip(zip);
        user.setState(state);
        user.setRegistered(registered);
        user.setCreditBalance(credit_balance);
        user.setApproval(approval);

        return userDao.add(user, true);
    }
}