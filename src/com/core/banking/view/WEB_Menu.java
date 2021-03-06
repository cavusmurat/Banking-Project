/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.banking.view;

import com.core.banking.session.CustomerSession;

/**
 *
 * @author Murat
 */
public class WEB_Menu extends javax.swing.JFrame {

    /**
     * Creates new form WEB_Menu
     */
    public WEB_Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JButton();
        creditCardAppeal = new javax.swing.JButton();
        creditAppeal = new javax.swing.JButton();
        displayBalanceButton = new javax.swing.JButton();
        WEB_CreditCardDebtPayment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        exit.setText("ÇIKIŞ YAP");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        creditCardAppeal.setText("KREDİ KARTI BAŞVURUSU");
        creditCardAppeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditCardAppealActionPerformed(evt);
            }
        });

        creditAppeal.setText("KREDİ BAŞVURUSU");
        creditAppeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditAppealActionPerformed(evt);
            }
        });

        displayBalanceButton.setText("HESAP BAKİYESİ GÖRÜNTÜLE");
        displayBalanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayBalanceButtonActionPerformed(evt);
            }
        });

        WEB_CreditCardDebtPayment.setText("KART BORCU ÖDEME");
        WEB_CreditCardDebtPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WEB_CreditCardDebtPaymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(WEB_CreditCardDebtPayment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(creditCardAppeal))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(displayBalanceButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(creditAppeal)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creditAppeal)
                    .addComponent(displayBalanceButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creditCardAppeal)
                    .addComponent(WEB_CreditCardDebtPayment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(exit)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void creditCardAppealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditCardAppealActionPerformed
        WEB_CreditCardAppeal cardAppeal=new WEB_CreditCardAppeal();
        this.setVisible(false);
        cardAppeal.setVisible(true);
        CustomerSession.getParentFrame().add(this);
    }//GEN-LAST:event_creditCardAppealActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        CustomerSession.getParentFrame().get(CustomerSession.getParentFrame().size()-1).setVisible(true);
        CustomerSession.getParentFrame().removeAll(CustomerSession.getParentFrame());
        dispose();                
    }//GEN-LAST:event_exitActionPerformed

    private void creditAppealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditAppealActionPerformed
        WEB_CreditAppeal creditAppeal=new WEB_CreditAppeal();
        this.setVisible(false);
        creditAppeal.setVisible(true);
        CustomerSession.getParentFrame().add(this);
    }//GEN-LAST:event_creditAppealActionPerformed

    private void displayBalanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayBalanceButtonActionPerformed
        WEB_DisplayBalance displayBalance=new WEB_DisplayBalance();
        this.setVisible(false);
        displayBalance.setVisible(true);
        CustomerSession.getParentFrame().add(this);
    }//GEN-LAST:event_displayBalanceButtonActionPerformed

    private void WEB_CreditCardDebtPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WEB_CreditCardDebtPaymentActionPerformed
        WEB_CreditCardDebtPayment debtPayment=new WEB_CreditCardDebtPayment();
        this.setVisible(false);
        debtPayment.setVisible(true);
        CustomerSession.getParentFrame().add(this);
    }//GEN-LAST:event_WEB_CreditCardDebtPaymentActionPerformed

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
            java.util.logging.Logger.getLogger(WEB_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WEB_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WEB_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WEB_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WEB_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton WEB_CreditCardDebtPayment;
    private javax.swing.JButton creditAppeal;
    private javax.swing.JButton creditCardAppeal;
    private javax.swing.JButton displayBalanceButton;
    private javax.swing.JButton exit;
    // End of variables declaration//GEN-END:variables
}
