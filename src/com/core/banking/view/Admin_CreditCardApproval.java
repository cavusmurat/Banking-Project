/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.banking.view;

import com.core.banking.model.CreditCard;
import com.core.banking.model.ResponseModel;
import com.core.banking.service.impl.CreditCardServiceImpl;
import com.core.banking.session.CustomerSession;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Murat
 */
public class Admin_CreditCardApproval extends javax.swing.JFrame {

    
    private CreditCardServiceImpl creditCardService=new CreditCardServiceImpl();
    private List<CreditCard> creditCardList=new ArrayList<>();
    /**
     * Creates new form Admin_CreditCardApproval
     */
    public Admin_CreditCardApproval() {
        initComponents();
    
        ResponseModel<List<CreditCard>> responsemodel3=creditCardService.kayıtlıBasvurular();
        if(responsemodel3.isSuccess()){
            creditCardList=responsemodel3.getResponseObject();
            for(CreditCard creditCard : creditCardList){
                appealsComboBox.addItem(creditCard.getCardNumber());
            }
                
        }else{
        
        
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JButton();
        confirmApplication = new javax.swing.JButton();
        appealsComboBox = new javax.swing.JComboBox<>();
        nameSurname = new javax.swing.JTextField();
        limit = new javax.swing.JTextField();
        cardNumber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        appealDeny = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        back.setText("GERİ");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        confirmApplication.setText("BAŞVURUYU ONAYLA");
        confirmApplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmApplicationActionPerformed(evt);
            }
        });

        appealsComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                appealsComboBoxİtemStateChanged(evt);
            }
        });

        nameSurname.setEditable(false);

        limit.setEditable(false);

        cardNumber.setEditable(false);
        cardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardNumberActionPerformed(evt);
            }
        });

        jLabel1.setText("AD-SOYAD");

        jLabel2.setText("Kart limiti");

        jLabel3.setText("Kart Numarası");

        appealDeny.setText("BAŞVURUYU REDDET");
        appealDeny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appealDenyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(appealsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameSurname)
                            .addComponent(limit)
                            .addComponent(cardNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addGap(88, 88, 88))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appealDeny)
                    .addComponent(confirmApplication))
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(appealsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(limit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(cardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(confirmApplication)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(appealDeny))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cardNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardNumberActionPerformed
        
    }//GEN-LAST:event_cardNumberActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        CustomerSession.getParentFrame().get(CustomerSession.getParentFrame().size()-1).setVisible(true);
        CustomerSession.getParentFrame().remove(CustomerSession.getParentFrame().size()-1);
        this.setVisible(false);      
    }//GEN-LAST:event_backActionPerformed

    private void appealsComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_appealsComboBoxİtemStateChanged
        int index = appealsComboBox.getSelectedIndex();
        CreditCard creditCard = creditCardList.get(index);
        cardNumber.setText(creditCard.getCardNumber());
        limit.setText(String.valueOf(creditCard.getLimit()));
        nameSurname.setText(creditCard.getNameSurname());
    }//GEN-LAST:event_appealsComboBoxİtemStateChanged

    private void confirmApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmApplicationActionPerformed
        ResponseModel<Boolean> responsemodel=creditCardService.basvuruOnayla(creditCardList.get(appealsComboBox.getSelectedIndex()).getCardNumber());
        if(responsemodel.isSuccess()){
            JOptionPane.showMessageDialog(rootPane, responsemodel.getMessage());
        }else{
            JOptionPane.showMessageDialog(rootPane, responsemodel.getMessage());
        }
    
    }//GEN-LAST:event_confirmApplicationActionPerformed

    private void appealDenyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appealDenyActionPerformed
        ResponseModel<Boolean> responsemodel=creditCardService.basvuruReddi(creditCardList.get(appealsComboBox.getSelectedIndex()).getCardNumber());
        if(responsemodel.isSuccess()){
            JOptionPane.showMessageDialog(rootPane, responsemodel.getMessage());
        }else{
            JOptionPane.showMessageDialog(rootPane, responsemodel.getMessage());
        }
    }//GEN-LAST:event_appealDenyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin_CreditCardApproval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_CreditCardApproval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_CreditCardApproval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_CreditCardApproval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_CreditCardApproval().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton appealDeny;
    private javax.swing.JComboBox<String> appealsComboBox;
    private javax.swing.JButton back;
    private javax.swing.JTextField cardNumber;
    private javax.swing.JButton confirmApplication;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField limit;
    private javax.swing.JTextField nameSurname;
    // End of variables declaration//GEN-END:variables
}
