/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mib.grupp12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.logging.Logger;

/**
 *
 * @author elias
 */
public class ListaTop3Agenter extends javax.swing.JFrame {

    private InfDB idb;

    /**
     * Creates new form ListaTop3Agenter
     */
    public ListaTop3Agenter() {
        initComponents();
         try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        } catch (InfException ex) {
            Logger.getLogger(MIBGrupp12.class.getName()).log(Level.SEVERE, null, ex);
        }

        fyllComboBox();
        fyllLabel();
    }

    private void fyllComboBox() {
        ArrayList<String> omraden;
        try {
            omraden = idb.fetchColumn("select benamning from omrade");
            cbOmraden.removeAllItems();
            for (String ettOmrade : omraden) {
                cbOmraden.addItem(ettOmrade);
            }
        }
        catch(InfException e){
        JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    private void fyllLabel() {
        lblTop3Agenter.setText("Top 3 Agenter:");


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbOmraden = new javax.swing.JComboBox<>();
        btnVisaTop3 = new javax.swing.JButton();
        lblTop3Agenter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbOmraden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnVisaTop3.setText("OK");
        btnVisaTop3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaTop3ActionPerformed(evt);
            }
        });

        lblTop3Agenter.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVisaTop3)
                    .addComponent(cbOmraden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(158, 158, 158))
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(lblTop3Agenter, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(cbOmraden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTop3Agenter, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVisaTop3)
                .addGap(87, 87, 87))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisaTop3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaTop3ActionPerformed
        // TODO add your handling code here:
        lblTop3Agenter.setText(""); // Rensa tidigare text

        try {
            String omrade = cbOmraden.getSelectedItem().toString();

            String query = "SELECT agent.agent_id, agent.namn, COUNT(alien.ansvarig_agent) AS assigned_aliens FROM agent JOIN alien ON agent.agent_id = alien.ansvarig_agent JOIN omrade ON agent.omrade = omrade.omrades_id WHERE omrade.benamning = '" + omrade + "' GROUP BY agent.agent_id, agent.namn ORDER BY assigned_aliens DESC LIMIT 3";

            ArrayList<HashMap<String, String>> resultList = idb.fetchRows(query);

            if (!resultList.isEmpty()) {
                lblTop3Agenter.setText("<html>");
                for (HashMap<String, String> enMap : resultList) {
                    System.out.println(enMap); // Felsökning: Skriv ut innehållet i HashMap-objektet
                    String id = enMap.get("Agent_ID");
                    String namn = enMap.get("Namn");

                    lblTop3Agenter.setText(lblTop3Agenter.getText() + "ID: " + id + "<br>NAMN: " + namn + "<br><br>");
                }
                lblTop3Agenter.setText(lblTop3Agenter.getText() + "</html>");
            } else {
                lblTop3Agenter.setText("Det finns inga agenter i detta område...");
            }

        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnVisaTop3ActionPerformed

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
            java.util.logging.Logger.getLogger(ListaTop3Agenter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaTop3Agenter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaTop3Agenter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaTop3Agenter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaTop3Agenter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVisaTop3;
    private javax.swing.JComboBox<String> cbOmraden;
    private javax.swing.JLabel lblTop3Agenter;
    // End of variables declaration//GEN-END:variables
}
