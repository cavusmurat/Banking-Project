/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.banking.view;


/*
    ATM VE BANKA GİRİS EKRANLARİ YAZİLACAK
    
    

*/

public class Main {
    public static void main(String args[]) {                
        DatabaseConnection con=new DatabaseConnection();
        con.connectdb();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectionMenu().setVisible(true);
            }
        });
    }
}
