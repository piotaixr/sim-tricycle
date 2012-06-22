/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim.tricycle.robot.condition;

import sim.tricycle.Ordonnanceur.OrdonnanceurInterface;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.condition.core.AbstractCondition;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class PvNecessaires extends AbstractCondition{

    private OrdonnanceurInterface ordonnanceur;

    public PvNecessaires(OrdonnanceurInterface ordonnanceur) {
        this.ordonnanceur = ordonnanceur;
    }
    @Override
    public boolean test() {
        Robot bot = (Robot) ordonnanceur.getActiveTask();
        return bot.getPV() <= (bot.getArmure()/10) ? false : true;
    }

    @Override
    public String getId() {
        return "pv_necessaire";
    }

}
