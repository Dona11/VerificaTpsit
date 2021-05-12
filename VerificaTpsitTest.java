/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificatpsit;

import static java.lang.Thread.sleep;

/**
 *<p>Questa è la classe Main dove verificare che tutto funzioni correttamente</p>
 * @author informatica
 */
public class VerificaTpsitTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        int numDipendenti = 10;
        BanconeBuffer bancone = new BanconeBuffer(numDipendenti);
        
        ProduttoreCuoco pc = new ProduttoreCuoco(bancone);
        pc.start();
        
        for(int i = 0; i < numDipendenti; i++){
        
            ConsumatoreDipendente cd = new ConsumatoreDipendente(bancone);
            cd.start();
        }
        
        for(int i = 0; i < numDipendenti; i++){
        
            ConsumatoreDipendente cd = new ConsumatoreDipendente(bancone);
            cd.join();
        }
        
        pc.join();
        
        sleep((int) (Math.random() * 1000));
        
        System.out.println("\nFine pausa pranzo");
        
        
        
    }
    
}
