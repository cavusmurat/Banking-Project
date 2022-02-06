
package com.core.banking.service;

import com.core.banking.model.Account;
import com.core.banking.model.Credit;
import com.core.banking.model.ResponseModel;
import java.util.List;

public interface CreditService {
    
    ResponseModel<Credit> krediBasvurusu(Account account ,Double limit);
    
    ResponseModel<Boolean> basvuruOnayla();
    
    ResponseModel<Boolean> basvuruReddi();
    
    ResponseModel<List<Credit>> kayıtlıBasvurular();
    
}

