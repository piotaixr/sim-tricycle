/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.condition;

import sim.tricycle.Ordonnanceur.OrdonnanceurInterface;
import sim.tricycle.mapping.Case;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.condition.core.AbstractCondition;

/**
 *
 * @author marion
 */
public class EnnemiDevant extends AbstractCondition {

    private OrdonnanceurInterface ordonnanceur;

    public EnnemiDevant(OrdonnanceurInterface ordonnanceur) {
        this.ordonnanceur = ordonnanceur;
    }

    @Override
    public String getId() {
        return "ennemi_devant";
    }

    @Override
    public boolean test() {
        Robot bot = (Robot) ordonnanceur.getActiveTask();
        Case c = bot.getTeam().getMap().getCaseDevant(bot);
        if(c == null)
            return false;

        return c.robotPresent() && !c.getRobotPresent().getTeam().equals(bot.getTeam());
    }
}
