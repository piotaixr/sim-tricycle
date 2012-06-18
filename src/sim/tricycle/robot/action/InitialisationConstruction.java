/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.mapping.elementCase.AbstractBatiment;
import sim.tricycle.mapping.elementCase.Tour;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author marion
 */
public class InitialisationConstruction extends AbstractAction{
    

    @Override
    protected Object doExecute(Robot bot) {
        
                
        Case c = bot.getMapObjective().getCase(bot.caseDevant().getX(),bot.caseDevant().getY());
        
        AbstractBatiment bat = new Tour(c);
        
        if (c.whoIam()== TypeCase.vide){
            c.setObstacle(bat);            
        }
        else throw new RuntimeException("la case n'est pas vide");
        
        return null;
    }

    @Override
    public String getId() {
        return "initialisation construction";
    }
    
}
