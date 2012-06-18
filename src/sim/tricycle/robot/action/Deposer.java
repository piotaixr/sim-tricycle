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
public class Deposer extends AbstractAction{
    
    private Ressource ressource;

    @Override
    protected Object doExecute(Robot bot) {

        return null;
    }

    @Override
    public String getId() {
        return "deposer";
    }

}
