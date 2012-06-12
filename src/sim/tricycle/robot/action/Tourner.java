package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.robot.Sens;

/**
 *
 * @author Adri
 */
public class Tourner extends Action {

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
    public void executer(Robot bot) {

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
