package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.robot.Sens;
import sim.tricycle.robot.action.core.AbstractAction;
import sim.tricycle.utils.params.types.Reference;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author Adri
 */
public class Tourner extends AbstractAction {

    private Sens direction;
    private Reference refDir;

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
        Sens d = (Sens)refDir.getValue();
        if(d!=null) {
            this.direction=d;
        }
            bot.setDirection(this.direction);
            
        return null;
    }

    public void setDirection(Sens newDir) {
        this.direction = newDir;
    }

    public Sens setDirection() {
        return this.direction;
    }

    public void setParameters(String direction) {
        this.direction = Sens.valueOf(direction);
    }

    public void setParameters(Reference direction) {
        this.refDir = direction;
    }

    public void setParameters(Variable direction) {
        this.refDir = direction;
    }

    @Override
    public String getId() {
        return "tourner";
    }
}
