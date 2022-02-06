package com.core.banking.service.impl;

import com.core.banking.model.CreditCard;
import com.core.banking.model.Customer;
import com.core.banking.model.ResponseModel;
import com.core.banking.repository.CreditCardRepository;
import com.core.banking.service.CreditCardService;
import com.core.banking.session.CustomerSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CreditCardServiceImpl implements CreditCardService{
    
    private CreditCardRepository creditCardRepository=new CreditCardRepository();
    
    public ResponseModel<CreditCard> borcOde(CreditCard creditCard,Double amount){
       ResponseModel<CreditCard> responsemodel=new ResponseModel();
       if(amount>0&&creditCard.getDebt()-amount>=0){
           creditCard.setCurrentLimit(creditCard.getCurrentLimit()+amount);
           creditCard.setDebt(creditCard.getDebt()-amount);
           if(creditCardRepository.updateDebt(creditCard)>=0){    
            responsemodel.setSuccess(true);
            responsemodel.setMessage("Ödeme işleminiz başarıyla gerçekleştirildi!");
            responsemodel.setResponseObject(creditCard);
            
            return responsemodel;            
            }else{
            responsemodel.setSuccess(false);
            responsemodel.setMessage("İşlem başarısız!");
            responsemodel.setResponseObject(null);
            
            return responsemodel;
            }
        }else{
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(null);
            responsemodel.setMessage("İşlem başarısız oldu!");
            return responsemodel;
        
        }    
    }
    
    public ResponseModel<CreditCard> OdemeYap(CreditCard creditCard , Double amount){
        ResponseModel<CreditCard> responsemodel=new ResponseModel();
        if(creditCard.getCurrentLimit()-amount>=0){
            creditCard.setCurrentLimit(creditCard.getCurrentLimit()-amount);
            creditCard.setDebt(creditCard.getDebt()+amount);
            if(creditCardRepository.updateDebt(creditCard)>=0){    
            responsemodel.setSuccess(true);
            responsemodel.setMessage("İşlem başarılı!");
            responsemodel.setResponseObject(creditCard);
            
            return responsemodel;            
            
            }else{
            responsemodel.setSuccess(false);
            responsemodel.setMessage("İşlem başarısız!");
            responsemodel.setResponseObject(null);
            
            return responsemodel;
        
            }                                
        }else{
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(null);
            responsemodel.setMessage("İşlem başarısız oldu!");
            
            return responsemodel;
        
        }    
           
    }

    public ResponseModel<List<CreditCard>> kayıtlıKartlar(){
        List<CreditCard> list=new ArrayList<>();
        ResponseModel<List<CreditCard>> responsemodel=new ResponseModel<>();
        Customer customer=CustomerSession.getCustomer();        
        list.addAll(creditCardRepository.findByCustomerId(customer.getCustomerNumber()));
        if(!list.isEmpty()){
            responsemodel.setSuccess(true);
            responsemodel.setResponseObject(list);
        }else{
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(null);
            responsemodel.setMessage("Hata");
        }                
        return responsemodel;                
    }

    @Override
    public ResponseModel<CreditCard> kartBasvurusu(Double limit) {
        CreditCard creditCard=new CreditCard();
        creditCard.setCustomer(CustomerSession.getCustomer());
        creditCard.setNameSurname(creditCard.getCustomer().getName()+" "+creditCard.getCustomer().getSurname());
        creditCard.setLimit(limit);        
        creditCard.setCvcNumber(generateNumericString(3));
        creditCard.setPassword(generateNumericString(4));
        Calendar calender = Calendar.getInstance();
        Date date=new Date();
        calender.setTime(date);
        calender.add(Calendar.YEAR, 2);
        date = calender.getTime();
        creditCard.setExpireDate(date);
        creditCard.setCurrentLimit(limit);
        
        do{
            creditCard.setCardNumber(generateNumericString(16));
        }while(creditCardRepository.findByCreditCardNumber(creditCard.getCardNumber())!=null);
        
        creditCard=creditCardRepository.insertCreditCard(creditCard);
        
        
        return null;
    }
    
    public String generateNumericString(int length){
        String generatedString="";
        Random random=new Random();
        for(int i=0;i<length;i++){
            generatedString += random.nextInt(9);       
        }        
        return generatedString;    
    }
    
    
    public ResponseModel<List<CreditCard>> kayıtlıBasvurular(){
        List<CreditCard> list=new ArrayList<>();
        ResponseModel<List<CreditCard>> responsemodel=new ResponseModel<>();
        list=creditCardRepository.findCardAppeals();
        if(!list.isEmpty()){
            responsemodel.setSuccess(true);
            responsemodel.setResponseObject(list);
        }else{
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(null);
            responsemodel.setMessage("Kayıtlı başvuru bulunamadı!");
        }                
        return responsemodel;                
    }
    
    public ResponseModel<Boolean> basvuruOnayla(String cardNumber){
        ResponseModel<Boolean> responsemodel= new ResponseModel();
        if(creditCardRepository.setApproval(cardNumber)>=0){
            responsemodel.setSuccess(true);
            responsemodel.setMessage("Onaylama başarılı");
            responsemodel.setResponseObject(true);
            return responsemodel;
        }else{
            responsemodel.setSuccess(false);
            responsemodel.setMessage("Onaylama başarısız");
            responsemodel.setResponseObject(false);
            return responsemodel;
        }
    
    }
    public ResponseModel<Boolean> basvuruReddi(String cardNumber){
        ResponseModel<Boolean> responsemodel= new ResponseModel();
        if(creditCardRepository.deleteAppeal(cardNumber)>=0){
            responsemodel.setSuccess(true);
            responsemodel.setMessage("Başvuru reddedildi!");
            responsemodel.setResponseObject(true);
            return responsemodel;
        }else{
            responsemodel.setSuccess(false);
            responsemodel.setMessage("Reddetme başarısız!");
            responsemodel.setResponseObject(false);
            return responsemodel;
        }
    }
}
