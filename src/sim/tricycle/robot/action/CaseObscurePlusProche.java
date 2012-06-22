/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.CarteTeam;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Adri
 */
public class CaseObscurePlusProche extends AbstractAction {

    public CaseObscurePlusProche() {
    }

    @Override
    protected Object doExecute(Robot bot) {
        CarteTeam c = bot.getTeam().getMap();
        for (int i = 0; i < c.getLargeur(); i++) {
            for (int j = 0; j < c.getHauteur(); j++) {
                if (c.getCase(i, j).JamaisVu()) {
                    return c.getCase(i, j);
                }
            }
        }
        return null;
    }

    @Override
    public String getId() {
        return "case_obscure_plus_proche";
    }
}
