
package com.core.banking.service;

import com.core.banking.model.CreditCard;
import com.core.banking.model.ResponseModel;
import java.util.List;

public interface CreditCardService {
    
    ResponseModel<CreditCard> borcOde(CreditCard creditCard,Double amount);
    
    ResponseModel<CreditCard> OdemeYap(CreditCard creditCard , Double amount);
    
    ResponseModel<List<CreditCard>> kayıtlıKartlar();    
    
    ResponseModel<CreditCard> kartBasvurusu(Double limit);
    
    ResponseModel<List<CreditCard>> kayıtlıBasvurular();
}
