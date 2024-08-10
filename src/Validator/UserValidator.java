package Validator;

public class UserValidator extends Validator {
    public boolean validateUsername(String username) {
        return validate(username, usernameRegex);
    }

    public String invalidUsername() {
        return "Username only accepts letters and underscores.";
    }

    public boolean validateUsernameLength(String username) {
        return (username.length() >= 4) && (username.length() <= 30);
    }

    public String invalidUsernameLength() {
        return "Username must be 4-30 characters long.";
    }

    public boolean validateICNO(String icno) {
        return validate(icno, icnoRegex);
    }

    public String invalidICNO() {
        return "Invalid passport / IC number.";
    }

    public boolean validatePassword(String password) {
        return validate(password, passwordRegex);
    }

    public String invalidPassword() {
        return "Password must contain at least one digit, lowercase and uppercase letter.";
    }

    public boolean validatePasswordLength(String password) {
        return (password.length() >= 8) && (password.length() <= 15);
    }

    public String invalidPasswordLength() {
        return "Password must be 8-15 characters long.";
    }

    public boolean validateConfirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public String invalidConfirmPassword() {
        return "Please reconfirm password.";
    }

    public boolean validateEmail(String email) {
        return validate(email, emailRegex);
    }

    public String invalidEmail() {
        return "Invalid email.";
    }

    public boolean validatePhone(String phone) {
        return validate(phone, phoneRegex);
    }

    public String invalidPhone() {
        return "Invalid phone number.";
    }

    public boolean validateCity(String city) {
        return validate(city, cityRegex);
    }

    public String invalidCity() {
        return "Invalid city.";
    }

    public boolean validateZIP(String zip) {
        return validate(zip, zipRegex);
    }

    public String invalidZIP() {
        return "Invalid ZIP code.";
    }

    // @Override
    // public String required() {
    // return super.required();
    // }
}