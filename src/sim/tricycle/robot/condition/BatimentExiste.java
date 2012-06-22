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
 * @author Adri
 */
public class BatimentExiste extends AbstractCondition{
    
        private OrdonnanceurInterface ordonnanceur;

    public BatimentExiste(OrdonnanceurInterface ordonnanceur) {
        this.ordonnanceur = ordonnanceur;
    }

    @Override
    public String getId() {
        return "batiment_existe";
    }

    @Override
    public boolean test() {
        Robot bot = (Robot) ordonnanceur.getActiveTask();
        CarteTeam c = bot.getTeam().getMap();
      
        for (int i = 0; i < c.getLargeur(); i++) {
            for (int j = 0; j < c.getHauteur(); j++) {
                if (c.getCase(i, j).hasObstacle() && c.getCase(i, j).getObstacle().whoIam()==TypeCase.tour) {
                    return true;
                }
            }
        }
        return false;
    }
    
}
