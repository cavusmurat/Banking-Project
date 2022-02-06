/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.banking.repository;

import com.core.banking.model.Credit;
import java.sql.Connection;
import com.core.banking.view.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Murat
 */
public class CreditRepository {
    
    private Connection con=DatabaseConnection.getCon();
    CustomerRepository customerrepository=new CustomerRepository();
    
    public Credit insertCredit(Credit credit){
        String sql="INSERT INTO MURAT.CREDIT (MAINAMOUNT, TOTALAMOUNT, CURRENTAMOUNT, INTERESTRATE, EXPIRY, APPROVAL, CUSTOMERNUMBER, ID , ACCOUNTID)"+
                        "VALUES (?,?,?,?,?,?,?,(SELECT MAX(ID)+1 FROM MURAT.CREDIT),?)";
    

        PreparedStatement ps=null;
        
        try{
            ps=con.prepareStatement(sql);
            ps.setDouble(1,credit.getMainAmount());
            ps.setDouble(2,credit.getTotalAmount());
            ps.setDouble(3,credit.getCurrentAmount());
            ps.setDouble(4,credit.getInterestRate());
            ps.setDate(5,null);
            ps.setDouble(6,0);
            ps.setLong(7, credit.getCustomer().getCustomerNumber());
            ps.setLong(8,credit.getAccountId());
                            
            ps.executeUpdate();  
        
            return credit;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }
    
    public List<Credit> findCreditAppeals(){
        String sql="SELECT * FROM MURAT.CREDIT WHERE APPROVAL=0 ";        
        List<Credit> list=new ArrayList<>();
    
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);           
            rs=ps.executeQuery();
            while(rs.next()){
                Credit credit=new Credit();
                credit.setCurrentAmount(rs.getDouble("CURRENTAMOUNT"));
                credit.setInterestRate(rs.getDouble("INTERESTRATE"));
                credit.setTotalAmount(rs.getDouble("TOTALAMOUNT"));
                credit.setMainAmount(rs.getDouble("MAINAMOUNT"));
                credit.setApproval(rs.getInt("APPROVAL"));
                credit.setCustomer(customerrepository.findByCustomerId(rs.getLong("CUSTOMERNUMBER")));
                credit.setAccountId(rs.getLong("ACCOUNTID"));
                credit.setId(rs.getLong("ID"));
                
                list.add(credit);
                
            } 
            return list;
         }catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        
    }
    
     public int setApproval(Long id){
        String sql="UPDATE MURAT.CREDIT SET APPROVAL=1 WHERE ID =?" ;  
        
        PreparedStatement ps=null;
 
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1, id);
            return ps.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }        
        
    }
    
    public int deleteAppeal(Long id){
        String sql="DELETE FROM MURAT.CREDIT WHERE ID=?";
        
        PreparedStatement ps=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1, id);
            return ps.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }        

    }
    
    
    public Credit findById(Long id){
        String sql="SELECT * FROM MURAT.CREDIT WHERE ID=?";
        Credit credit=new Credit();
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1,id);
            rs=ps.executeQuery();
            if(rs.next()){
                credit.setAccountId(rs.getLong("ACCOUNTID"));
                credit.setApproval(rs.getInt("APPROVAL"));
                credit.setCurrentAmount(rs.getDouble("CURRENTAMOUNT"));
                credit.setInterestRate(rs.getDouble("INTERESTRATE"));
                credit.setMainAmount(rs.getDouble("MAINAMOUNT"));
                credit.setTotalAmount(rs.getDouble("TOTALAMOUNT"));
                credit.setId(rs.getLong("ID"));
                credit.setCustomer(customerrepository.findByCustomerId(rs.getLong("ID")));

                return credit;            
            }else{
                return null;
            }            
        }catch(SQLException ex){
            ex.printStackTrace();;
            return null;
        }
    } 
}