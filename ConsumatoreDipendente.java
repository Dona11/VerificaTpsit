/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificatpsit;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>Questa è la classe Consumatore dove è presente un oggetto BanconeBuffer</p>
 * @author informatica
 */
public class ConsumatoreDipendente extends Thread{
    
    BanconeBuffer bb;

    /**
     *<p>Questo è il costruttore per portare in input un oggetto BanconeBuffer</p>
     * @param bb oggetto di tipo BanconeBuffer
     */
    public ConsumatoreDipendente(BanconeBuffer bb) {   //Costruttore per portare in input un BanconeBuffer
        this.bb = bb;
    }
    
    /**
     *<p>Con questo metodo il dipendente preleva un piatto<p>
     */
    public void run(){
    
        try {
            sleep((int) (Math.random() * 200));
        } catch (InterruptedException ex) {
            
        }
        
        bb.preleva();   //Il dipendente preleva un piatto
    }
}
