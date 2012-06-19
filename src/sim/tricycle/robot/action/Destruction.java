/*
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.elementCase.AbstractBatiment;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author marion
 */
public class Destruction extends AbstractAction {

    @Override
    protected Object doExecute(Robot bot) {

        Case c = bot.getMapTeam().getCaseDevant(bot);
        AbstractBatiment bat = (AbstractBatiment) c.getObstacle();

        if (bat.getTemps() > 0) {
            bat.setTemps(bat.getTemps() - 1);
            if (bat.getTemps() == 0) {
                bot.getMapTeam().getCaseDevant(bot).suprObstacle();
            }
        } else {
            throw new RuntimeException("il n'y a pas de batiment sur cette case");
        }

        return null;
    }

    @Override
    public String getId() {
        return "destruction";
    }
}
