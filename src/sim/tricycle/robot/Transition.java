/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot;

import sim.tricycle.robot.action.Action;
import java.util.ArrayList;

/**
 *
 * @author Adri
 */
public class Transition {
    
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
    
    public void effectuerTransition(Robot bot){
        enfilerAllActions(bot);
        bot.setEtat(this.etatDest);
    }
}
