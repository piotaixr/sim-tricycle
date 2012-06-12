package sim.tricycle.robot.condition;

import sim.tricycle.robot.condition.core.AbstractCondition;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class ConditionTrue extends AbstractCondition {

    @Override
    public boolean test() {
        return true;
    }

    @Override
    public String getId() {
        return "true";
    }
}
