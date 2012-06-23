/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.condition;

import sim.tricycle.Ordonnanceur.OrdonnanceurInterface;
import sim.tricycle.mapping.CarteTeam;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.condition.core.AbstractCondition;

/**
 *
 * @author marion
 */
public class PtControleTrouve extends AbstractCondition {

    private OrdonnanceurInterface ordonnanceur;

    public PtControleTrouve(OrdonnanceurInterface ordonnanceur) {
        this.ordonnanceur = ordonnanceur;
    }

    @Override
    public boolean test() {
        Robot r = (Robot) ordonnanceur.getActiveTask();
        CarteTeam c = r.getTeam().getMap();
        for (int i = 0; i < c.getLargeur(); i++) {
            for (int j = 0; j < c.getHauteur(); j++) {
                if (c.getCase(i, j).whoIam() == TypeCase.ptDeControle) {
                    if (c.getCase(i, j).getRobotPresent() == null || c.getCase(i, j).getRobotPresent().getTeam() != r.getTeam()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getId() {
        return "pt_control_trouve";
    }
}
