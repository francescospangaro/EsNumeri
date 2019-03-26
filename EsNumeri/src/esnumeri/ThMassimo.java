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
public class ThMassimo extends Thread{
    private DatiCondivisi ptrDati;
    private int num;

    public ThMassimo(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
        this.num = ptrDati.getNum();
    }

    public ThMassimo() {
    }

    public DatiCondivisi getPtrDati() {
        return ptrDati;
    }

    public void setPtrDati(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public void run(){
        int max = 0;
        int temp = 0;
        for (int i = 0; i < num; i++){
           ptrDati.waitsyncMinMax();
           temp = ptrDati.getBuffer();
           System.out.println("Max controlla " + temp);
           ptrDati.signalsyncMaxGen();
           if (i == 0){
               max = temp;
           }
           if (temp > max){
               max = temp;
           }
        }
        ptrDati.setMax(max);
    System.out.println("Fine di ThMassimo");
    }
}
