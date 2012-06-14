package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Adri
 */
public class ArreterTout extends AbstractAction{

    @Override
    protected Object doExecute(Robot bot) {
        bot.getActions().clear();
        
        return null;
    }

    @Override
    public String getId() {
        return "arreter_tout";
    }
}
