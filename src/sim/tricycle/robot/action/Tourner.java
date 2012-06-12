package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.robot.Sens;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Adri
 */
public class Tourner extends AbstractAction {

    private Sens direction;

    public Tourner() {
        super();
        direction = Sens.NORD;
    }

    public Tourner(Sens dir) {
        super();
        this.direction = dir;
    }

    @Override
    protected Object doExecute(Robot bot) {

        bot.setDirection(this.direction);
        return null;
    }
    
    public void executer(Robot bot){
        bot.setDirection(this.direction);
    }

    public void setDirection(Sens newDir) {
        this.direction = newDir;
    }

    public Sens setDirection() {
        return this.direction;
    }

    @Override
    public String getId() {
        return "tourner";
    }
}
