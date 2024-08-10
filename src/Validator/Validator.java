package Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    protected String dateRegex = "d-M-uuuu";
    protected String timeRegex = "([01]?[0-9]|2[0-3]):[0-5][0-9]"; // 24-hour format (Example: 23:00)

    protected String usernameRegex = "[a-zA-Z_]+";
    protected String icnoRegex = "(^[A-Z]{1}[0-9]{8}$)|(^[0-9]{12}$)";
    protected String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{0,}$";
    protected String emailRegex = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
    protected String phoneRegex = "((^010)[0-9]{7}$)|((^011)[0-9]{8}$)|((^01)[2-4]{1}[0-9]{7}$)|((^01)[6-9]{1}[0-9]{7})";
    protected String cityRegex = "[a-zA-Z ]{3,30}";
    protected String zipRegex = "[0-9]{5}";

    protected String creditAmountRegex = "[0-9]+[.]?[0-9]{0,2}";
    protected String fullNameRegex = "[a-zA-Z ]+";
    protected String cardNumberRegex = "[0-9]{16}";
    protected String expirationMonthRegex = "(^0){1}[1-9]{1}|[10-12]{2}";
    protected String expirationYearRegex = "[0-9]{2}";
    protected String securityCodeRegex = "[0-9]{3}";

    protected boolean validate(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public String required() {
        return "Please fill up the form.";
    }
}