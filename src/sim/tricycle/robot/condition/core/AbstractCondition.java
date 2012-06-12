package sim.tricycle.robot.condition.core;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public abstract class AbstractCondition implements ConditionInterface {

    @Override
    public ConditionInterface clone() throws CloneNotSupportedException{
        return (ConditionInterface) super.clone();
    }

}
