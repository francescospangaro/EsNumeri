/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esnumeri;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc
 */
public class DatiCondivisi {
    private int buffer;
    private int max;
    private int min;
    private int num;
    private Semaphore syncGenMin;
    private Semaphore syncMinMax;
    private Semaphore syncMaxGen;
    
    public DatiCondivisi(int buffer, int max, int min) {
        this.buffer = buffer;
        this.max = max;
        this.min = min;
    }

    public DatiCondivisi(int num) {
        this.syncGenMin = new Semaphore(0);
        this.syncMinMax = new Semaphore(0);
        this.syncMaxGen = new Semaphore(1);
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getBuffer() {
        return buffer;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
    
    public void waitsyncGenMin(){
        try {
            this.syncGenMin.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void waitsyncMinMax(){
        try {
            this.syncMinMax.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void waitsyncMaxGen(){
        try {
            this.syncMaxGen.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void signalsyncGenMin(){
        this.syncGenMin.release();
    }
    
    public void signalsyncMinMax(){
        this.syncMinMax.release();
    }
    
    public void signalsyncMaxGen(){
        this.syncMaxGen.release();
    }
}
