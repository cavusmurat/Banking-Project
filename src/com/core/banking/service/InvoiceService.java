/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.banking.service;

import com.core.banking.model.Account;
import com.core.banking.model.CreditCard;
import com.core.banking.model.Invoice;
import com.core.banking.model.ResponseModel;
import java.util.List;

/**
 *
 * @author Murat
 */
public interface InvoiceService {
    
    ResponseModel<List<Invoice>> kayıtlıFaturalar();
    
    ResponseModel<Invoice> hesaptanFaturaOdeme(Invoice invoice,Account account);
    
    ResponseModel<Invoice> karttanFaturaOdeme(Invoice invoice,CreditCard creditCard);
        
}
