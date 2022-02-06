
package com.core.banking.service.impl;

import com.core.banking.model.Customer;
import com.core.banking.model.ResponseModel;
import com.core.banking.model.User;
import com.core.banking.repository.LoginRepository;
import com.core.banking.service.LoginService;
import com.core.banking.session.CustomerSession;
import com.core.banking.session.UserSession;


public class LoginServiceImpl implements LoginService{

    private LoginRepository loginRepository = new LoginRepository();
    
    @Override
    public int checkDigits(String cardNumber){
        
        int flag=0;
        for (int i = 0, len = cardNumber.length(); i < len; i++) {
            if (Character.isDigit(cardNumber.charAt(i))) {
            flag++;
            }
        }
        return flag;
}
    
    public int checkDigits(Long customerNumber){
        
        int flag=0;
        String customerNumb=Long.toString(customerNumber);
        for (int i = 0, len = customerNumb.length(); i < len; i++) {
            if (Character.isDigit(customerNumb.charAt(i))) {
            flag++;
            }
        }
        return flag;
}
    
    @Override
    public Boolean numericCheck(String cardNumber){
        try {
		Integer.parseInt(cardNumber);
	} catch (NumberFormatException numberFormatException) {
		return false;
        }
	return true;
}
    
    @Override
    public ResponseModel<Customer> login(String cardNumber, String password) {
       //cardnumber kontrolleri,şifre kontrolleri
       //responsemodel işlemleri yapılacak
        ResponseModel responsemodel=new ResponseModel(); 
       try{
            //int i=Integer.valueOf(cardNumber);       
            if(checkDigits(cardNumber)!=16){    
                responsemodel.setSuccess(false);
                responsemodel.setMessage("Kredi kartı numarası yanlış girildi!");
                return responsemodel;
            }
        }catch(Exception e){
                e.printStackTrace();
                responsemodel.setSuccess(false);
                responsemodel.setMessage("Kredi kartı numarası yanlış girildi!");
                return responsemodel;
        }
        //loginrepository customer döndükten sonra customersession.setcustomer(ilgiliobje) yapılmalı.
        Customer customer = loginRepository.login(cardNumber,password);
        if(customer!=null){            
            responsemodel.setMessage("Basarili Giris");
            responsemodel.setSuccess(true);
            responsemodel.setResponseObject(customer);
        } else {
            responsemodel.setMessage("Hatali Giris");
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(customer);
        }
        CustomerSession.setCustomer(customer);
        return responsemodel;
        
    }
    

    @Override
    public ResponseModel<Customer> login(Long customerNumber, String password) {
        //customernumber kontrolü,şifre kontrolleri
        //responsemodel işlemleri yapılacak
        
        ResponseModel responsemodel=new ResponseModel();
        try{
            if(checkDigits(customerNumber)!=8){
            responsemodel.setSuccess(true);
            responsemodel.setMessage("Hatalı giriş!");   
            return responsemodel;
        }
        }catch(Exception e){
                e.printStackTrace();
                responsemodel.setSuccess(false);
                responsemodel.setMessage("Kredi kartı numarası yanlış girildi!");
                return responsemodel;
        } 
        Customer customer = loginRepository.login(customerNumber,password);
        if(customer!=null){            
            responsemodel.setMessage("Basarili Giris");
            responsemodel.setSuccess(true);
            responsemodel.setResponseObject(customer);
        } else {
            responsemodel.setMessage("Hatali Giris");
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(customer);
        }                        
        CustomerSession.setCustomer(customer);
        return responsemodel;
    }

    @Override
    public ResponseModel<Customer> login(String identityNumber) {
        //identitynumber kontrolü       
        //responsemodel işlemleri yapılacak        
        ResponseModel responsemodel=new ResponseModel();
        try{
            if(checkDigits(identityNumber)!=11){
            responsemodel.setSuccess(false);
            responsemodel.setMessage("Hatalı giriş!");            
            return responsemodel;
            }
        }catch(Exception e){
                e.printStackTrace();
                responsemodel.setSuccess(false);
                responsemodel.setMessage("Kimlik numarası yanlış girildi!");                
                return responsemodel;                
                }
        Customer customer = loginRepository.login(identityNumber);
        if(customer!=null){            
            responsemodel.setMessage("Basarili Giris");
            responsemodel.setSuccess(true);
            responsemodel.setResponseObject(customer);
        } else {
            responsemodel.setMessage("Hatali Giris");
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(customer);
        }
        CustomerSession.setCustomer(customer);
        return responsemodel;                
    }

    @Override
    public ResponseModel<Boolean> logout() {
        
        CustomerSession.clear();
        ResponseModel responsemodel=new ResponseModel(); 
        responsemodel.setSuccess(true);
        responsemodel.setMessage("Oturumunuz kapatılmıştır!");
        responsemodel.setResponseObject(true);
        
        return responsemodel;
    }
    
    @Override
    public ResponseModel<User> userLogin(String identityNumber, String password){
        ResponseModel<User> responsemodel=new ResponseModel();
        User user =loginRepository.userLogin(identityNumber,password);
        if(user!=null){            
            responsemodel.setMessage("Basarili Giris");
            responsemodel.setSuccess(true);
            responsemodel.setResponseObject(user);
        } else {
            responsemodel.setMessage("Hatali Giris");
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(user);
        }
        UserSession.setUser(user);
        return responsemodel;
    }
    
}
