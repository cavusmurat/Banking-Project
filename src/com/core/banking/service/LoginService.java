
package com.core.banking.service;

import com.core.banking.model.Customer;
import com.core.banking.model.ResponseModel;
import com.core.banking.model.User;

public interface LoginService {
    
    ResponseModel<Customer> login(String cardNumber,String password);
    
    ResponseModel<Customer> login(Long customerNumber,String password);
    
    ResponseModel<Customer> login(String identityNumber);
    
    ResponseModel<Boolean> logout();
    
    Boolean numericCheck(String cardNumber);
    
    ResponseModel<User> userLogin(String identityNumber, String password);
    
    int checkDigits(String cardNumber);
    
}

