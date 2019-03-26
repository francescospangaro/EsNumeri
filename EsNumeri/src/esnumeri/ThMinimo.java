/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esnumeri;

/**
 *
 * @author franc
 */
public class ThMinimo extends Thread{
    private DatiCondivisi ptrDati;
    private int num;

    public ThMinimo(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
        this.num = ptrDati.getNum();
    }

    public ThMinimo() {
    }

    public DatiCondivisi getPtrDati() {
        return ptrDati;
    }

    public void setPtrDati(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }
    
    public void run(){
        int min = 0;
        int temp = 0;
        for (int i = 0; i < num; i++){
           ptrDati.waitsyncGenMin();
           temp = ptrDati.getBuffer();
           System.out.println("Min controlla " + temp);
           ptrDati.signalsyncMinMax();
           if (i == 0){
               min = temp;
           }
           if (temp < min){
               min = temp;
           }
        }
        ptrDati.setMin(min);
        System.out.println("Fine di ThMinimo");
    }
}
