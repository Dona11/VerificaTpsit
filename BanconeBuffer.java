/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificatpsit;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *<p> Questa è la classe condivisa BanconeBuffer dove sono presenti 2 semafori, il numero progressivo e il numero di dipendenti</p>
 * @author informatica
 * 
 */
public class BanconeBuffer {
    
    Semaphore semVuoto = new Semaphore(1);
    Semaphore semPieno = new Semaphore(0);
    
    int numeroProgressivo = 1;
    int numeroDipendenti;

    /**
     *<p>Questo è il costruttore per creare un oggetto BanconeBuffer</p>
     * @param numeroDipendenti il numero di dipendenti totale
     */
    public BanconeBuffer(int numeroDipendenti) {   //Costruttore per creare un oggetto BanconeBuffer
        this.numeroDipendenti = numeroDipendenti;
    }
    
    /**
     *<p>In questo metodo viene depositato un piatto, di conseguenza diventa pronto per essere prelevato</p>
     */
    public void deposita(){   //In questo metodo viene depositato un piatto
        
        try {
            semVuoto.acquire();
        } catch (InterruptedException ex) {
            
        }
        
        System.out.println("Il piatto n° " + numeroProgressivo + " è pronto");
        semPieno.release();
    }
    
    /**
     *<p>In questo metodo viene prelevato un piatto e viene aggiornato il numero progressivo</p>
     */
    public void preleva(){   //In questo metodo viene preso un piatto
    
        try {
            semPieno.acquire();
        } catch (InterruptedException ex) {
            
        }
        
        System.out.println("Consuma: " + numeroProgressivo);
        semVuoto.release();
        numeroProgressivo++;
    }
}
