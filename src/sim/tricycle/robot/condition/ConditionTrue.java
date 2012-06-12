package sim.tricycle.robot.condition;

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
