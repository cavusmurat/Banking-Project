/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.banking.service.impl;

import com.core.banking.model.Account;
import com.core.banking.model.CreditCard;
import com.core.banking.model.Customer;
import com.core.banking.model.Invoice;
import com.core.banking.model.ResponseModel;
import com.core.banking.repository.AccountRepository;
import com.core.banking.repository.InvoiceRepository;
import com.core.banking.service.InvoiceService;
import com.core.banking.session.CustomerSession;
import java.util.ArrayList;
import java.util.List;


public class InvoiceServiceImpl implements InvoiceService {
    
    private InvoiceRepository invoiceRepository=new InvoiceRepository();
    private AccountServiceImpl accountService=new AccountServiceImpl();
    private CreditCardServiceImpl creditCardService=new CreditCardServiceImpl();
    
    @Override
    public ResponseModel<List<Invoice>> kayıtlıFaturalar(){
        List<Invoice> list=new ArrayList<>();
        ResponseModel<List<Invoice>> responsemodel=new ResponseModel<>();
        Customer customer=CustomerSession.getCustomer();
        list.addAll(invoiceRepository.findByCustomerId(customer.getCustomerNumber()));
        if(!list.isEmpty()){
            responsemodel.setSuccess(true);
            responsemodel.setResponseObject(list);
        }else{
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(null);
            responsemodel.setMessage("Müşteriye kayıtlı fatura bulunamadı!");
        }                
        return responsemodel;
    }
    
    @Override
    public ResponseModel<Invoice> hesaptanFaturaOdeme(Invoice invoice, Account account){
        ResponseModel<Invoice> responsemodel=new ResponseModel();
        ResponseModel<Account> responsemodel2=new ResponseModel();
        responsemodel2=accountService.paraCekme(account, String.valueOf(invoice.getAmount()));
        if(responsemodel2.isSuccess()){
            responsemodel.setSuccess(true);
            responsemodel.setMessage("İşlem başarılı");
            responsemodel.setResponseObject(invoice);
            invoiceRepository.deleteInvoice(account.getCustomer().getCustomerNumber(), invoice.getInvoiceNo());
            return responsemodel;
        }else{
            responsemodel.setSuccess(false);
            responsemodel.setMessage("İşlem başarısız!");
            responsemodel.setResponseObject(null);
            
            return responsemodel;        
        }
     
    }
    
    @Override
    public ResponseModel<Invoice> karttanFaturaOdeme(Invoice invoice,CreditCard creditCard){
        ResponseModel<Invoice> responsemodel=new ResponseModel();
        ResponseModel<CreditCard> responsemodel2=new ResponseModel();
        responsemodel2=creditCardService.OdemeYap(creditCard, invoice.getAmount());
        if(responsemodel2.isSuccess()){
            responsemodel.setSuccess(true);
            responsemodel.setMessage("Ödemeniz başarıyla gerçekleştirildi!");
            responsemodel.setResponseObject(invoice);
            invoiceRepository.deleteInvoice(creditCard.getCustomer().getCustomerNumber(), invoice.getInvoiceNo());
            return responsemodel;                            
        }else{
            responsemodel.setSuccess(false);
            responsemodel.setMessage("İşlem başarısız!");
            responsemodel.setResponseObject(null);
            
            return responsemodel;
        
        }
        
        
        
        
    
       
    }
    
    
}
