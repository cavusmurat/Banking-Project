/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.banking.repository;

import com.core.banking.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.core.banking.view.DatabaseConnection;

/**
 *
 * @author Murat
 */
public class CustomerRepository {
    
    private Connection con=DatabaseConnection.getCon();
    
    public Customer findByCustomerId(Long customerNumber){
        String sql="SELECT * FROM MURAT.CUSTOMER WHERE CUSTOMERNUMBER=?";
        Customer customer = new Customer(); 
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1, customerNumber);            
            rs=ps.executeQuery();
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
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;        
        }                               
    }   
}
