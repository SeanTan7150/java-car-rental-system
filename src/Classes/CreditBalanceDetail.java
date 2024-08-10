package Classes;

public class CreditBalanceDetail {
    private String creditBalanceDetailId, icno, datetime, flow, amount, finalAmount;

    public CreditBalanceDetail() {
    }
    
    public CreditBalanceDetail(String creditBalanceDetailId, String icno, String datetime, String flow, String amount,
            String finalAmount) {
        this.creditBalanceDetailId = creditBalanceDetailId;
        this.icno = icno;
        this.datetime = datetime;
        this.flow = flow;
        this.amount = amount;
        this.finalAmount = finalAmount;
    }

    public String getCreditBalanceDetailId() {
        return creditBalanceDetailId;
    }

    public void setCreditBalanceDetailId(String creditBalanceDetailId) {
        this.creditBalanceDetailId = creditBalanceDetailId;
    }

    public String getIcno() {
        return icno;
    }

    public void setIcno(String icno) {
        this.icno = icno;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(String finalAmount) {
        this.finalAmount = finalAmount;
    }
}