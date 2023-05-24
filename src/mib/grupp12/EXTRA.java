/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mib.grupp12;

/**
 *
 * @author elias
 */
public class EXTRA {
    
       //KOD FÖR ATT TA BORT ALIEN
        /*String id = txtalien.getText();
        if (id != null) {
            try {
                String hamta = idb.fetchSingle("SELECT * FROM alien WHERE Alien_ID=" + id);
                if (hamta != null) {
                    idb.delete("DELETE FROM boglodite WHERE Alien_ID=" + id);
                    idb.delete("DELETE FROM squid WHERE Alien_ID=" + id);
                    idb.delete("DELETE FROM worm WHERE Alien_ID=" + id);
                    idb.delete("DELETE FROM alien WHERE Alien_ID=" + id);
                    JOptionPane.showMessageDialog(rootPane, "Alien är nu raderad");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Alien verkar inte finnas med i systemet");
                    txtalien.setText(null);
                }
            } catch (InfException e) {
                JOptionPane.showMessageDialog(rootPane, "Vänligen skriv in en vald alien");
            }
        }
         */
    
    
    //KOD FÖR ATT TA BORT UTRUSTNING
    /*String utrustning = txtutrustning.getText();
        if (utrustning != null) {
            try {
                String hamta = idb.fetchSingle("SELECT * FROM utrustning WHERE Utrustnings_ID=" + utrustning);
                if (hamta != null) {
                    
                    idb.delete("DELETE FROM innehar_utrustning WHERE Utrustnings_ID=" + utrustning);
                    idb.delete("DELETE FROM kommunikation WHERE Utrustnings_ID=" + utrustning);
                    idb.delete("DELETE FROM teknik WHERE Utrustnings_ID=" + utrustning);
                    idb.delete("DELETE FROM vapen WHERE Utrustnings_ID=" + utrustning);
                    idb.delete("DELETE FROM utrustning WHERE Utrustnings_ID=" + utrustning);
                    JOptionPane.showMessageDialog(rootPane, "Utrustning är nu raderad");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Finns ingen utrustning med det namnet");
                    txtutrustning.setText(null);
                }
                
            } catch (InfException e) {
                JOptionPane.showMessageDialog(rootPane, "Vänligen skriv in utrustning");
            }
        }
         */
    
    
    //KOD FÖR ATT ÄNDRA TILL ADMIN
    /*String nyadmin = txtadmin.getText();
        if (nyadmin != null) {
            try {
                String hamta = idb.fetchSingle("SELECT * FROM agent WHERE Agent_ID=" + nyadmin);
                String status = idb.fetchSingle("SELECT Administrator from agent where Agent_ID=" + nyadmin);
                if (hamta != null && status.equals("N")) {
                    idb.update("UPDATE agent SET Administrator='J' WHERE Agent_ID=" + hamta);
                    JOptionPane.showMessageDialog(rootPane, "Agenten är nu en admin");
                    
                } else if (hamta != null && status.equals("J")) {
                    JOptionPane.showMessageDialog(rootPane, "Agenten är redan admin");
                    txtadmin.setText(null);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Agenten verkar inte finnas med i systemet");
                    txtadmin.setText(null);
                }
            } catch (InfException e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
         */
}
