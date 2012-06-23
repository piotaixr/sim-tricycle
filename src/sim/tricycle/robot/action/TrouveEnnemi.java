/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.CarteTeam;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Adri
 */
public class TrouveEnnemi extends AbstractAction {

    @Override
    protected Object doExecute(Robot bot) {
        CarteTeam c = bot.getTeam().getMap();
        for (int i = 0; i < c.getLargeur(); i++) {
            for (int j = 0; j < c.getHauteur(); j++) {
                if (c.getCase(i, j).whoIam() == TypeCase.robot) {
                    Robot rob = (Robot) c.getCase(i, j).getObstacle();
                    if (!rob.getTeam().getColor().equals(bot.getTeam().getColor())) {
                        return c.getCase(i, j).getObstacle();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String getId() {
        return "trouveennemi";
    }

    public TrouveEnnemi() {
        super();
    }
}
