
package com.core.banking.model;

import java.util.Date;

public class Invoice extends Product {

    private long InvoiceNo;
    private String corporation;
    private InvoiceType type;
    private double amount;
    private Date dueDate;
    

    public long getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(long invoiceNo) {
        InvoiceNo = invoiceNo;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public InvoiceType getType() {
        return type;
    }

    public void setType(InvoiceType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}

