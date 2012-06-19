package sim.tricycle.robot.action;

import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Adri
 */
public class Avancer extends AbstractAction {

    public Avancer() {
        super();
    }

    @Override
    protected Object doExecute(Robot bot) {
        bot.getT().getMap().avancer(bot);
        return null;
    }
    
    @Override
    public String getId() {
        return "avancer";
    }
}
