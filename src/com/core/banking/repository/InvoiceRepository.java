
package com.core.banking.repository;

import com.core.banking.model.Invoice;
import java.sql.Connection;
import com.core.banking.view.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InvoiceRepository {
    
    private Connection con=DatabaseConnection.getCon();
    CustomerRepository customerrepository=new CustomerRepository();
    
    public List<Invoice> findByCustomerId(Long customerNumber){
        String sql="SELECT * FROM MURAT.INVOICE WHERE CUSTOMERNUMBER=?";
        List<Invoice> list=new ArrayList<>();
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1,customerNumber);
            rs=ps.executeQuery();
            while(rs.next()){
                Invoice invoice=new Invoice();
                invoice.setAmount(rs.getDouble("AMOUNT"));
                invoice.setCorporation(rs.getString("CORPORATION"));
                invoice.setDueDate(rs.getDate("DUEDATE"));
                invoice.setInvoiceNo(rs.getLong("INVOICENO"));
                /*invoice.setType(rs.getString("INVOICETYPE"));
                  invoicetype tipiyle alakalı problem var.
                */
                invoice.setCustomer(customerrepository.findByCustomerId(rs.getLong("CUSTOMERNUMBER")));
                list.add(invoice);
            }
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
  
    public Invoice findById(Long id){
        String sql="SELECT * FROM MURAT.INVOICE WHERE ID=?";
        Invoice invoice=new Invoice();
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                invoice.setId(rs.getLong("ID"));
                invoice.setAmount(rs.getDouble("AMOUNT"));
                invoice.setCorporation(rs.getString("CORPORATION"));
                invoice.setDueDate(rs.getDate("DUEDATE"));
                invoice.setInvoiceNo(rs.getLong("INVOICENO"));
                
                return invoice;
            }else{
                return null;
            }        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }       
    }
    public void deleteInvoice(Long customerNumber,Long invoiceNumber){
        String sql="DELETE FROM MURAT.INVOICE WHERE CUSTOMERNUMBER=? AND INVOICENO=?";
        
        PreparedStatement ps=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1,customerNumber);
            ps.setLong(2, invoiceNumber);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }        
    }        
}
