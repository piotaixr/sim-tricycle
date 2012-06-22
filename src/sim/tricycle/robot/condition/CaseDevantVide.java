/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.condition;

import sim.tricycle.Ordonnanceur.OrdonnanceurInterface;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.condition.core.AbstractCondition;

/**
 *
 * @author Adri
 */
public class CaseDevantVide extends AbstractCondition{
 

    private OrdonnanceurInterface ordonnanceur;

    public CaseDevantVide(OrdonnanceurInterface ordonnanceur) {
        this.ordonnanceur = ordonnanceur;
    }

    @Override
    public String getId() {
        return "case_devant_vide";
    }

    @Override
    public boolean test() {
        Robot bot = (Robot) ordonnanceur.getActiveTask();
        return !bot.getTeam().getMap().getCaseDevant(bot).hasObstacle() 
                && !bot.getTeam().getMap().getCaseDevant(bot).hasItem() 
                && !bot.getTeam().getMap().getCaseDevant(bot).hasZone()  ;
    }
}
