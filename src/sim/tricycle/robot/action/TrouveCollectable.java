/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.Case;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Adri
 */
public class TrouveCollectable extends AbstractAction{

    private Case c;


    public TrouveCollectable() {
        super();
    }
    
    public Object doExecute(Robot bot){
        return bot.getEquipe().getCollectableCiblable();
    }
    
    public String getId(){
        return "trouveCollectable";
    }
    
    public Case getC() {
        return c;
    }

    public void setC(Case c) {
        this.c = c;
    }
    
}
