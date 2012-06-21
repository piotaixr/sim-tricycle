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
public class RobotDevant extends AbstractAction{

    @Override
    protected Object doExecute(Robot bot) {
        if(bot.getTeam().getMap().getCaseDevant(bot).getRobotPresent().getTeam() != bot.getTeam()){
            return bot.getTeam().getMap().getCaseDevant(bot).getRobotPresent();
        }
        return null;
    }

    @Override
    public String getId() {
        return "robot_devant";
    }
    
}
