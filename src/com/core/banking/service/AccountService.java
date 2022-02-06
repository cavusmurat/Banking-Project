
package com.core.banking.service;

import com.core.banking.model.Account;
import com.core.banking.model.ResponseModel;
import java.util.List;

public interface AccountService {

    ResponseModel<Account> paraYatirma(Account account, String amount);
    
    ResponseModel<Account> paraCekme(Account account,String amount);
       
    ResponseModel<List<Account>>  kayıtlıHesaplar();
    
    ResponseModel<List<Account>> paraTransferi(Account account,String amount,Long iban);

}