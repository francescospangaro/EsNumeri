/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esnumeri;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc
 */
public class EsNumeri_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Scanner input = new Scanner(System.in);
            int num;
            System.out.println("Inserisci quanti numeri vuoi che vengano generati");
            num = input.nextInt();
            DatiCondivisi ptrDati = new DatiCondivisi(num);
            ThGenera gen = new ThGenera(ptrDati);
            ThMassimo max = new ThMassimo(ptrDati);
            ThMinimo min = new ThMinimo(ptrDati);
            
            gen.start();
            min.start();
            max.start();
            
            gen.join();
            min.join();
            max.join();
            System.out.println("Numero massimo = " + ptrDati.getMax());
            System.out.println("Numero minimo = " + ptrDati.getMin());
        } catch (InterruptedException ex) {
            Logger.getLogger(EsNumeri_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
