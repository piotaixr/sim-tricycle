/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;
import sim.tricycle.team.Ressource;

/**
 *
 * @author marion
 */
public class Ramasser extends AbstractAction{
    
    private Ressource ressource;

    @Override
    protected Object doExecute(Robot bot) {
        bot.getTeam().trouveQuantiteItem(ressource.getItem()).setQuantite(bot.getTeam().trouveQuantiteItem(ressource.getItem()).getQuantite()+1);
        return null;
    }

    @Override
    public String getId() {
        return "ramasser";
    }
    
}
