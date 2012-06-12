package sim.tricycle.robot.condition.core;

import sim.tricycle.utils.IdentifiableInterface;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public interface ConditionInterface extends Cloneable, IdentifiableInterface<String> {

    public boolean test();
    public ConditionInterface clone() throws CloneNotSupportedException;
}
