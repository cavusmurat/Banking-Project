
package com.core.banking.repository;

import com.core.banking.model.Account;
import com.core.banking.model.Customer;
import com.core.banking.model.ResponseModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.core.banking.view.DatabaseConnection;


public class AccountRepository {
    
    private Connection con=DatabaseConnection.getCon();    
    private CustomerRepository customerrepository=new CustomerRepository();
    
    //her repositoryde bu işlemler yapılacak,birden fazla obje dönecekler için list tutmak gerekir.
    public List<Account> findByCustomerId(Long customerNumber){
        String sql="SELECT * FROM MURAT.ACCOUNT WHERE CUSTOMERNUMBER=?";
        List<Account> list= new ArrayList<>(); 
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1, customerNumber);            
            rs=ps.executeQuery();
            while(rs.next()){
                Account account = new Account();
                account.setId(rs.getLong("ID"));
                account.setBalance(rs.getDouble("BALANCE"));
                account.setName(rs.getString("NAME"));
                account.setIban(rs.getString("IBAN"));
                account.setCustomer(customerrepository.findByCustomerId(rs.getLong("CUSTOMERNUMBER")));
                list.add(account);
            }
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;        
        }                               
    } 
    
    public Account findById(Long id){
        String sql="SELECT * FROM MURAT.ACCOUNT WHERE ID=?";
        Account account = new Account();
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1, id);            
            rs=ps.executeQuery();
            if(rs.next()){
                account.setId(rs.getLong("ID"));
                account.setBalance(rs.getDouble("BALANCE"));
                account.setName(rs.getString("NAME"));
                account.setIban(rs.getString("IBAN"));
                account.setCustomer(customerrepository.findByCustomerId(rs.getLong("CUSTOMERNUMBER")));
                
                return account;
            }else{
                return null;
            }              
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;        
        }                               
    }
    
    public int updateBalance(Account account){
        String sql="UPDATE MURAT.ACCOUNT SET NAME = ?, IBAN= ?, BALANCE = ? WHERE ID = ?" ;  
        
        PreparedStatement ps;
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,account.getName());
            ps.setString(2,account.getIban());
            ps.setDouble(3,account.getBalance());
            ps.setLong(4,account.getId());
            return ps.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }        
    }
    
    public Account findByIban(Long iban){
        String sql="SELECT * FROM MURAT.ACCOUNT WHERE IBAN=?";
        Account account=new Account();
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1,iban);
            rs=ps.executeQuery();
            if(rs.next()){
                account.setId(rs.getLong("ID"));
                account.setBalance(rs.getDouble("BALANCE"));
                account.setName(rs.getString("NAME"));
                account.setIban(rs.getString("IBAN"));
                return account;
            }else{
                return null;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
            
            
        }                        
       
    }
}
