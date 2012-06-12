package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.utils.IdentifiableInterface;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public interface ActionInterface extends IdentifiableInterface<String> {

    public void executer(Robot bot);
}
