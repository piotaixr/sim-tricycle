/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot;

import java.util.ArrayList;

/**
 *
 * @author Adri
 */
public class Transition {
    
    private Etat etatDep;
    private Etat etatDest;
    private ArrayList<Action> listeAction;
    
    public Transition(){
        
    }
    
    public void enfilerAllActions(Robot bot){
        bot.setFileAction().addAll(listeAction);
    }
    
    public void addAction(Action act){
        this.listeAction.add(act);
    }
}
