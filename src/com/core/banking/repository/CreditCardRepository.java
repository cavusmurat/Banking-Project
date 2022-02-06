/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.banking.repository;

import com.core.banking.model.CreditCard;
import java.sql.Connection;
import com.core.banking.view.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Murat
 */
public class CreditCardRepository {
    
    private Connection con=DatabaseConnection.getCon();
    CustomerRepository customerrepository=new CustomerRepository();
    
    public List<CreditCard> findByCustomerId(Long customerNumber){
        String sql="SELECT * FROM MURAT.CREDITCARD WHERE CUSTOMERNUMBER=?";
        List<CreditCard> list=new ArrayList<>();
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1, customerNumber);
            rs=ps.executeQuery();                        
            while(rs.next()){
                CreditCard creditcard=new CreditCard();
                creditcard.setCurrentLimit(rs.getDouble("CURRENTLIMIT"));
                creditcard.setCvcNumber(rs.getString("CVCNUMBER"));
                creditcard.setDebt(rs.getDouble("DEBT"));
                creditcard.setExpireDate(rs.getDate("EXPIREDATE"));
                creditcard.setNameSurname(rs.getString("NAMESURNAME"));
                creditcard.setLimit(rs.getDouble("LIMIT"));
                creditcard.setCustomer(customerrepository.findByCustomerId(rs.getLong("CUSTOMERNUMBER")));
                creditcard.setCardNumber(rs.getString("CARDNUMBER"));
                creditcard.setMinimumPayment(rs.getDouble("MINIMUMPAYMENT"));
                creditcard.setPassword(rs.getString("PASSWORD"));
                creditcard.setId(rs.getLong("ID"));
                list.add(creditcard);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public CreditCard findById(Long id){
        String sql="SELECT * FROM MURAT.CREDITCARD WHERE ID=?";
        CreditCard creditcard=new CreditCard();
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1,id);
            rs=ps.executeQuery();
            if(rs.next()){
                creditcard.setId(rs.getLong("ID"));
                creditcard.setCardNumber(rs.getString("CARDNUMBER"));
                creditcard.setCurrentLimit(rs.getDouble("CURRENTLIMIT"));
                creditcard.setCvcNumber(rs.getString("CVCNUMBER"));
                creditcard.setDebt(rs.getDouble("DEBT"));
                creditcard.setExpireDate(rs.getDate("EXPIREDATE"));
                creditcard.setLimit(rs.getDouble("LIMIT"));
                creditcard.setMinimumPayment(rs.getDouble("MINIMUMPAYMENT"));
                creditcard.setNameSurname(rs.getString("NAMESURNAME"));
                creditcard.setPassword(rs.getString("PASSWORD"));
                
                return creditcard;            
            }else{
                return null;
            }            
        }catch(SQLException ex){
            ex.printStackTrace();;
            return null;
        }
    
    } 
    
    public int updateDebt(CreditCard creditCard){
        String sql="UPDATE MURAT.CREDITCARD SET DEBT=? , CURRENTLIMIT=? WHERE CARDNUMBER = ?" ;  
        
        PreparedStatement ps;
        
        try{
            ps=con.prepareStatement(sql);
            ps.setDouble(1, creditCard.getDebt());
            ps.setDouble(2, creditCard.getCurrentLimit());
            ps.setString(3, creditCard.getCardNumber());
            return ps.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }        
    }
    
    public CreditCard findByCreditCardNumber(String cardNumber){
        String sql="SELECT * FROM MURAT.CREDITCARD WHERE CARDNUMBER=? ";
        
        CreditCard creditcard=new CreditCard();
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,cardNumber);
            rs=ps.executeQuery();
            if(rs.next()){
                creditcard.setId(rs.getLong("ID"));
                creditcard.setCardNumber(rs.getString("CARDNUMBER"));
                creditcard.setCurrentLimit(rs.getDouble("CURRENTLIMIT"));
                creditcard.setCvcNumber(rs.getString("CVCNUMBER"));
                creditcard.setDebt(rs.getDouble("DEBT"));
                creditcard.setExpireDate(rs.getDate("EXPIREDATE"));
                creditcard.setLimit(rs.getDouble("LIMIT"));
                creditcard.setMinimumPayment(rs.getDouble("MINIMUMPAYMENT"));
                creditcard.setNameSurname(rs.getString("NAMESURNAME"));
                creditcard.setPassword(rs.getString("PASSWORD"));
                
                return creditcard;            
            }else{
                return null;
            }            
        }catch(SQLException ex){
            ex.printStackTrace();;
            return null;
        }
 
    }
    
    public CreditCard insertCreditCard(CreditCard creditCard){
        String sql="INSERT INTO MURAT.CREDITCARD (NAMESURNAME, CARDNUMBER, PASSWORD, CVCNUMBER, LIMIT, DEBT, MINIMUMPAYMENT, CURRENTLIMIT, CUSTOMERNUMBER, EXPIREDATE, ID)"+ 
                      "VALUES (?, ?, ?, ?, ?,? , ?, ?, ?, ?, (SELECT MAX(ID)+1 FROM MURAT.CREDITCARD))";
        
        PreparedStatement ps=null;
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, creditCard.getNameSurname());
            ps.setString(2,creditCard.getCardNumber());
            ps.setString(3,creditCard.getPassword());
            ps.setString(4, creditCard.getCvcNumber());            
            ps.setDouble(5,creditCard.getLimit());
            ps.setString(6, null);
            ps.setDouble(7, 0);
            ps.setDouble(8, creditCard.getLimit());
            ps.setLong(9, creditCard.getCustomer().getCustomerNumber());
            ps.setDate(10, null);
            ps.executeUpdate();
            return creditCard;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<CreditCard> findCardAppeals(){
        String sql="SELECT * FROM MURAT.CREDITCARD WHERE APPROVAL=0 ";        
        List<CreditCard> list=new ArrayList<>();
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);           
            rs=ps.executeQuery();
            while(rs.next()){
                CreditCard creditcard=new CreditCard();
                creditcard.setCurrentLimit(rs.getDouble("CURRENTLIMIT"));
                creditcard.setCvcNumber(rs.getString("CVCNUMBER"));
                creditcard.setDebt(rs.getDouble("DEBT"));
                creditcard.setExpireDate(rs.getDate("EXPIREDATE"));
                creditcard.setNameSurname(rs.getString("NAMESURNAME"));
                creditcard.setLimit(rs.getDouble("LIMIT"));
                creditcard.setCustomer(customerrepository.findByCustomerId(rs.getLong("CUSTOMERNUMBER")));
                creditcard.setCardNumber(rs.getString("CARDNUMBER"));
                creditcard.setMinimumPayment(rs.getDouble("MINIMUMPAYMENT"));
                creditcard.setPassword(rs.getString("PASSWORD"));
                creditcard.setId(rs.getLong("ID"));
                list.add(creditcard);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public int setApproval(String cardNumber){
        String sql="UPDATE MURAT.CREDITCARD SET APPROVAL=1 WHERE CARDNUMBER = ?" ;  
        
        PreparedStatement ps=null;
 
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, cardNumber);
            return ps.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }        
        
    }
    
    public int deleteAppeal(String cardNumber){
        String sql="DELETE FROM MURAT.CREDITCARD WHERE CARDNUMBER=?";
        
        PreparedStatement ps=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, cardNumber);
            return ps.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }        
    }
    
    
}