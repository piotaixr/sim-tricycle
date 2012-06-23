/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import java.awt.event.ActionEvent;
import sim.tricycle.mapping.CarteTeam;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.mapping.elementCase.AbstractBatiment;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;
/**
 *
 * @author marion
 */
public class BatPlusPres extends AbstractAction{

    @Override
    protected Object doExecute(Robot bot) {
        CarteTeam c = bot.getTeam().getMap();
        for (int i = 0; i < c.getLargeur(); i++) {
            for (int j = 0; j < c.getHauteur(); j++) {
                if (c.getCase(i, j).hasObstacle()){
                    if (c.getCase(i,j).getObstacle() instanceof AbstractBatiment){
                        return c.getCase(i, j).getItem();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String getId() {
        return "batpluspres";
    }
    

    
}
