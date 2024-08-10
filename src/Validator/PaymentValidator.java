package Validator;

public class PaymentValidator extends Validator {
    public boolean validateCreditAmount(String creditAmount) {
        return validate(creditAmount, creditAmountRegex);
    }

    public String invalidCreditAmount() {
        return "Invalid credit amount.";
    }

    public boolean validateFullName(String fullName) {
        return validate(fullName, fullNameRegex);
    }

    public String invalidFullName() {
        return "Invalid full name.";
    }

    public boolean validateCardNO(String card) {
        return validate(card, cardNumberRegex);
    }

    public String invalidCardNO() {
        return "Invalid card number.";
    }

    public boolean validateExpirationMonth(String exp_month) {
        return validate(exp_month, expirationMonthRegex);
    }

    public String invalidExpirationMonth() {
        return "Invalid expiration month.";
    }

    public boolean validateExpirationYear(String exp_year) {
        return validate(exp_year, expirationYearRegex);
    }

    public String invalidExpirationYear() {
        return "Invalid expiration year.";
    }

    public boolean validateSecurityCode(String cvv) {
        return validate(cvv, securityCodeRegex);
    }

    public String invalidSecurityCode() {
        return "Invalid security code.";
    }
}