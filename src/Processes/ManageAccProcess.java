package Processes;

import Classes.User;
import DAO.UserDao;

public class ManageAccProcess {
    UserDao userDao = new UserDao();
    User user = new User();
    private String icno, username, password, role, email, phone, gender, address1, address2, city, zip, state,
            registered, credit_balance, approval;

    public void setAcc(String icno, String username, String password, String role, String email, String phone,
            String gender, String address1, String address2, String city, String zip, String state, String registered,
            String credit_balance, String approval) {
        this.icno = icno;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.registered = registered;
        this.credit_balance = credit_balance;
        this.approval = approval;
    }

    public boolean updateAcc() {
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

        return userDao.update(icno, user);
    }

    public boolean removeAcc(String ic) {
        return userDao.delete(ic);
    }

    public boolean approveAcc(String icno) {
        user = userDao.get(icno);
        String approved = "YES";
        user.setApproval(approved);

        return userDao.update(icno, user);
    }
}