/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.banking.repository;

import com.core.banking.model.Customer;
import com.core.banking.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.core.banking.view.DatabaseConnection;


public class LoginRepository {
    
    private Connection con=DatabaseConnection.getCon();
    private CustomerRepository customerrepository=new CustomerRepository();
    
    public Customer fillCustomerObject(ResultSet rs) throws SQLException{
        Customer customer=new Customer();
        if(rs.next()){                    
                customer.setCustomerNumber(rs.getLong("CUSTOMERNUMBER"));
                customer.setName(rs.getString("NAME"));
                customer.setSurname(rs.getString("SURNAME"));
                customer.setAddress(rs.getString("ADRESS"));
                customer.setCorporate(rs.getBoolean("ISCORPORATE"));
                customer.setGender(rs.getBoolean("GENDER"));
                customer.setPhone(rs.getString("PHONE"));                     
                return customer;                
            }else{
               return null;
            }            
    }
    
    public Customer login(String cardNumber,String password){
        String sql="Select * from CREDITCARD where CARDNUMBER=? AND PASSWORD=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, cardNumber);
            ps.setString(2, password);
            rs=ps.executeQuery();            
            if(rs.next()){
                Customer customer;
                customer=customerrepository.findByCustomerId(rs.getLong("CUSTOMERNUMBER"));
                return customer;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
        
    }       
   
    public Customer login(Long customerNumber,String password){
        String sql="Select * from CUSTOMER where CUSTOMERNUMBER=? AND PASSWORD=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(customerNumber));
            ps.setString(2, password);
            rs=ps.executeQuery();
            return fillCustomerObject(rs);
        }catch(SQLException ex){
            return null;        
        }
               
    }
    
    public Customer login(String identityNumber){
        String sql="Select * from CUSTOMER where IDENTITYNUMBER=? ";
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,identityNumber);
            rs=ps.executeQuery();
            return fillCustomerObject(rs);
        }catch(SQLException ex){
            return null;
        }                        
    }
    
    public User userLogin(String identityNumber,String password){
        String sql="SELECT * FROM USERS WHERE IDENTITYNUMBER=? AND PASSWORD=?";
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, identityNumber);
            ps.setString(2, password);
            rs=ps.executeQuery();
            if(rs.next()){
                User user=new User();
                user.setName(rs.getString("NAME"));
                user.setAddress(rs.getString("ADRESS"));
                user.setIdentityNumber(rs.getString("IDENTITYNUMBER"));
                user.setSurname(rs.getString("SURNAME"));               
                user.setPhone(rs.getString("PHONE"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setBirthDate(rs.getDate("BIRTHDATE"));
                user.setId(rs.getLong("ID"));
                return user;
            }else{
                return null;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        
        }
 
    }
}
