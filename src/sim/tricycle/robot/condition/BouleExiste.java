/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.condition;

import sim.tricycle.Ordonnanceur.Ordonnanceur;
import sim.tricycle.mapping.CarteTeam;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.condition.core.AbstractCondition;

/**
 *
 * @author Adri
 */
public class BouleExiste extends AbstractCondition {

    private Ordonnanceur o;

    public BouleExiste(Ordonnanceur o) {
        this.o = o;
    }

    @Override
    public String getId() {
        return "boule_existe";
    }

    @Override
    public boolean test() {
        Robot bot = (Robot) o.getActiveTask();
        CarteTeam c = bot.getTeam().getMap();
        for (int i = 0; i < c.getLargeur(); i++) {
            for (int j = 0; j < c.getHauteur(); j++) {
                if (c.getCase(i, j).whoIam() == TypeCase.boule) {
                    return true;
                }
            }
        }
        return false;
    }
}
