package Classes;

public class Payment {
    private String paymentId, bookingId, adminId, datetime, method, amount, approval, bankId;

    public Payment() {
    }
    
    public Payment(String paymentId, String bookingId, String adminId, String datetime, String method, String amount,
            String approval, String bankId) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.adminId = adminId;
        this.datetime = datetime;
        this.method = method;
        this.amount = amount;
        this.approval = approval;
        this.bankId = bankId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }
    
    public String getBankId() {
        return bankId;
    }
    
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }
}