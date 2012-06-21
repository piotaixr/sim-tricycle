/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.condition;

import sim.tricycle.Ordonnanceur.OrdonnanceurInterface;
import sim.tricycle.mapping.CarteTeam;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.condition.core.AbstractCondition;

/**
 *
 * @author Adri
 */
public class CaseObscureExiste extends AbstractCondition {

    private OrdonnanceurInterface ordonnanceur;

    public CaseObscureExiste(OrdonnanceurInterface ordonnanceur) {
        this.ordonnanceur = ordonnanceur;
    }

    public boolean test() {
        Robot bot = (Robot) ordonnanceur.getActiveTask();
        CarteTeam c = bot.getTeam().getMap();
        for (int i = 0; i < c.getLargeur(); i++) {
            for (int j = 0; j < c.getHauteur(); j++) {
                if (c.getCase(i, j).JamaisVu()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getId() {
        return "case_obscure_existe";
    }
}
