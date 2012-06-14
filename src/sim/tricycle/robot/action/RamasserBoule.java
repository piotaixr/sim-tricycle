/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author marion
 */
public class RamasserBoule extends AbstractAction {
    
    @Override
    public Object doExecute(Robot bot){
        bot.getTeam().setBoule(bot.getTeam().getBoule()+1);
        return null;
    }
    
    @Override
    public String getId(){
        return "ramasserBoule";
    }
    
}


