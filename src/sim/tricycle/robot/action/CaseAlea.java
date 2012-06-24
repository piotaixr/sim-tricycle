/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.CarteTeam;
import sim.tricycle.mapping.Case;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author marion
 */
public class CaseAlea extends AbstractAction {

    @Override
    protected Object doExecute(Robot bot) {
        CarteTeam map = bot.getTeam().getMap();
        int xmax = map.getLargeur();
        int ymax = map.getHauteur();
        int x = (int) (Math.random() * xmax);
        int y = (int) (Math.random() * ymax);
        
        Case c = map.getCase(x,y);
        return c; 
    }

    @Override
    public String getId() {
        return "casealea";
    }
    
}
