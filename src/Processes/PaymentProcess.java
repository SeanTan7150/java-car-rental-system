package Processes;

import Classes.Payment;
import DAO.PaymentDao;

public class PaymentProcess {
    PaymentDao paymentDao = new PaymentDao();
    Payment payment = new Payment();
    private String paymentId, bookingId, adminId, datetime, method, amount, approval, bankId;

    public void setPayment(String paymentId, String bookingId, String adminId, String datetime, String method, String amount, String approval, String bankId) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.adminId = adminId;
        this.datetime = datetime;
        this.method = method;
        this.amount = amount;
        this.approval = approval;
        this.bankId = bankId;
    }

    public boolean approvePayment(String approvedBy) {
        payment = paymentDao.get(paymentId);
        String approved = "Verified";
        payment.setApproval(approved);
        payment.setAdminId(approvedBy);

        return paymentDao.update(paymentId, payment);
    }
    
    public boolean updatePayment() {
        payment.setBookingId(bookingId);
        payment.setAdminId(adminId);
        payment.setDatetime(datetime);
        payment.setMethod(method);
        payment.setAmount(amount);
        payment.setApproval(approval);
        payment.setBankId(bankId);
        
        return paymentDao.add(payment, false);
    }
}