package Processes;

import Classes.User;
import DAO.UserDao;

public class ProfileProcess {
    UserDao userDao = new UserDao();
    User user = new User();
    private final String uid, username, password, role, email, phone, gender, address1, address2, city, zip, state,
            registered, credit_balance, approval;

    public ProfileProcess(String[] user) {
        this.uid = user[0];
        this.username = user[1];
        this.password = user[2];
        this.role = user[3];
        this.email = user[4];
        this.phone = user[5];
        this.gender = user[6];
        this.address1 = user[7];
        this.address2 = user[8];
        this.city = user[9];
        this.zip = user[10];
        this.state = user[11];
        this.registered = user[12];
        this.credit_balance = user[13];
        this.approval = user[14];
    }

    public boolean updateProfile(User user) {
        user.setIcno(uid);
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

        UserDao.loggedIn = user;
        return userDao.update(uid, user);
    }
}