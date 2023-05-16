/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mib.grupp12;

import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfDB;
import oru.inf.InfException;


public class MIBGrupp12 {

    private static InfDB idb;
   
    public static void main(String[] args) throws InfException {
       try {
           idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
           new mittfönster().setVisible(true);
       } catch (InfException ex) {
           Logger.getLogger(MIBGrupp12.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
 
}

