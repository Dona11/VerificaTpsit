/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificatpsit;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *<p>Questa è la classe Produttore dove è presente un oggetto BanconeBuffer</p>
 * @author informatica
 */
public class ProduttoreCuoco extends Thread{
    
    BanconeBuffer bb;
    int numeroProgressivo = 1;

    /**
     *<p>Questo è il costruttore per portare in input un oggetto BanconeBuffer</p>
     * @param bb oggetto di tipo BanconeBuffer
     */
    public ProduttoreCuoco(BanconeBuffer bb) {
        this.bb = bb;
    }
    
    /**
     *<p>Con questo metodo il cuoco prepara un piatto per poi successivamente essere servito<p>
     */
    public void run(){
    
        try {
            sleep((int) (Math.random() * 2000));
        } catch (InterruptedException ex) {
            
        }
        
        for(int i = 0; i < bb.numeroDipendenti; i++){

            bb.deposita();   //Il cuoco prepara un piatto per poi successivamente essere servito

        }
    }
}
