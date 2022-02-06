
package com.core.banking.service.impl;

import com.core.banking.model.Account;
import com.core.banking.model.Customer;
import com.core.banking.model.ResponseModel;
import com.core.banking.repository.AccountRepository;
import com.core.banking.service.AccountService;
import com.core.banking.session.CustomerSession;
import java.util.ArrayList;
import java.util.List;


public class AccountServiceImpl implements AccountService {
    
    private AccountRepository accountrepository=new AccountRepository();    
    
    @Override
    public ResponseModel<Account> paraYatirma(Account account , String amount) {
        ResponseModel<Account> responsemodel=new ResponseModel();
        account.setBalance(account.getBalance()+Double.valueOf(amount));
        if(accountrepository.updateBalance(account)<0){
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(null);
            responsemodel.setMessage("İşlem başarısız!");
       
        }else{
            responsemodel.setSuccess(true);
            responsemodel.setResponseObject(account);
            responsemodel.setMessage("İşlem başarılı!");
        }                        
        return responsemodel;
    }
                           
    @Override
    public ResponseModel<Account> paraCekme(Account account,String amount){
        ResponseModel<Account> responsemodel=new ResponseModel();
        if(account.getBalance()-Double.valueOf(amount)>=0){
            account.setBalance(account.getBalance()- Double.valueOf(amount));
            if(accountrepository.updateBalance(account)<0){
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(null);
            responsemodel.setMessage("İşlem başarısız!");
       
            }else{
            responsemodel.setSuccess(true);
            responsemodel.setResponseObject(account);
            responsemodel.setMessage("Ödemeniz gerçekleştirildi!");
            }                        
        
        }else{
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(null);
            responsemodel.setMessage("İşlem başarısız oldu , geçersiz miktar girildi!");
            return responsemodel;        
        }
        
        return responsemodel;
    }
    
    @Override
    public ResponseModel<List<Account>> kayıtlıHesaplar() {
        List<Account> list=new ArrayList<>();
        ResponseModel<List<Account>> responsemodel=new ResponseModel<>();
        Customer customer=CustomerSession.getCustomer();        
        list.addAll(accountrepository.findByCustomerId(customer.getCustomerNumber()));
        if(!list.isEmpty()){
            responsemodel.setSuccess(true);
            responsemodel.setResponseObject(list);
        }else{
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(null);
            responsemodel.setMessage("Müşteriye kayıtlı hesap bulunamadı!");
        }                
        return responsemodel;
    }
    
    @Override
    public ResponseModel<List<Account>> paraTransferi(Account account,String amount,Long iban){
        List<Account> list=new ArrayList<>();        
        ResponseModel<List<Account>> responsemodel=new ResponseModel<>();
        Account targetAccount=new Account();
        targetAccount=accountrepository.findByIban(iban);
        list.add(account);
        list.add(targetAccount);
        if(targetAccount==null){
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(null);
            responsemodel.setMessage("Yazılan IBAN'a ait hesap bulunamadı!");                
        }else{
            if(account.getBalance()-Double.valueOf(amount)>=0){
                account.setBalance(account.getBalance()- Double.valueOf(amount));
                targetAccount.setBalance(targetAccount.getBalance()+ Double.valueOf(amount));
                accountrepository.updateBalance(account);
                accountrepository.updateBalance(targetAccount);
                responsemodel.setSuccess(true);                
                responsemodel.setMessage("Para transfer işlemi başarılı ve hesap bakiyesi sekmeyi yeniden açınca geçerli olacaktır!");
                responsemodel.setResponseObject(list);
                return responsemodel;
            }else{                
                return null;        
            }                
        }            
        return null;
    }
        
}

