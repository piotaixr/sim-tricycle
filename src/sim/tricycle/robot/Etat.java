/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot;

import java.util.HashMap;

/**
 *
 * @author Adri
 */
public class Etat {
    
    private HashMap<EventType,Transition> listeTransition;
    private Robot bot;
    
    public Etat(){
        
    }
    
    public void etatSuivant(Evenement evt){
        listeTransition.get(evt.getType()).effectuerTransition(this.bot);
    }
    
    
}
