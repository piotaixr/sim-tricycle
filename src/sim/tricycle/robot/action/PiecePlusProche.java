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
public class PiecePlusProche extends AbstractAction {

    public PiecePlusProche() {
    }

    @Override
    protected Object doExecute(Robot bot) {
        CarteTeam c = bot.getMapTeam();
        for (int i = 0; i < c.getLargeur(); i++) {
            for (int j = 0; j < c.getHauteur(); j++) {
                if (c.getCase(i, j).whoIam() == TypeCase.piece) {
                    return c.getCase(i, j).getItem();
                }
            }
        }
        return null;
    }

    @Override
    public String getId() {
        return "pieceplusproche";
    }
}
