package sim.tricycle.robot.action.core;

import sim.tricycle.robot.Robot;
import sim.tricycle.utils.params.types.Variable;
import sim.tricycle.utils.IdentifiableInterface;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public interface ActionInterface extends Cloneable, IdentifiableInterface<String> {

    public void executer(Robot bot);

    public ActionInterface clone() throws CloneNotSupportedException;
    
    public void setVariableDestination(Variable variable);
}
