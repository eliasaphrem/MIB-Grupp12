/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mib.grupp12;

import oru.inf.InfDB;
import oru.inf.InfException;

public class MIBGrupp12 {

    private static InfDB idba;
   
    public static void main(String[] args) {
       try {
           idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
           new mittfönster().setVisible(true);
       } catch (InfException ex) {
       }
    }
    
}
