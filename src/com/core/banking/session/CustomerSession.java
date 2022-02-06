
package com.core.banking.session;

import com.core.banking.model.Account;
import com.core.banking.model.Credit;
import com.core.banking.model.CreditCard;
import com.core.banking.model.Customer;
import com.core.banking.model.Invoice;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class CustomerSession {
    private static Customer customer;
    private static List<Account> account;
    private static List<CreditCard> creditcard;
    private static List<Credit> credit;
    private static List<Invoice> invoice;
    private static List<JFrame> parentFrame=new ArrayList<>();
    //ilgili repository içinde findbyıd işlemlerinden sonra ilgili objeler konacak
    
    public static void clear(){
        customer=null;
        account=null;
        creditcard=null;
        credit=null;
        invoice=null;
    }

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer customer) {
        CustomerSession.customer = customer;
    }

    public static List<Account> getAccount() {
        return account;
    }

    public static void setAccount(List<Account> account) {
        CustomerSession.account = account;
    }

    public static List<CreditCard> getCreditcard() {
        return creditcard;
    }

    public static void setCreditcard(List<CreditCard> creditcard) {
        CustomerSession.creditcard = creditcard;
    }

    public static List<Credit> getCredit() {
        return credit;
    }

    public static void setCredit(List<Credit> credit) {
        CustomerSession.credit = credit;
    }

    public static List<Invoice> getInvoice() {
        return invoice;
    }

    public static void setInvoice(List<Invoice> invoice) {
        CustomerSession.invoice = invoice;
    }

    public static List<JFrame> getParentFrame() {
        return parentFrame;
    }

    public static void setParentFrame(List<JFrame> parentFrame) {
        CustomerSession.parentFrame = parentFrame;
    }       
}