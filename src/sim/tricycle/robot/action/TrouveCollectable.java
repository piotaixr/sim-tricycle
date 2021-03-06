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

    public TrouveCollectable() {
        super();
    }
    
    protected Object doExecute(Robot bot){
        return bot.getTeam().getCollectableCiblable();
    }
    
    public String getId(){
        return "trouveCollectable";
    }  
}
