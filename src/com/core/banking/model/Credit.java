
package com.core.banking.model;

public class Credit extends Product {

    private Double mainAmount;
    private Double totalAmount;
    private Double currentAmount;
    private Double interestRate;
    private int expiry;
    private int approval;
    private Long accountId;
    //customernumber ve id eklenecek tabloya

    public Double getMainAmount() {
        return mainAmount;
    }

    public void setMainAmount(Double mainAmount) {
        this.mainAmount = mainAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public int getExpiry() {
        return expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    public int getApproval() {
        return approval;
    }

    public void setApproval(int approval) {
        this.approval = approval;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    
}

