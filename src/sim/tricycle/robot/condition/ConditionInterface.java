package sim.tricycle.robot.condition;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public interface ConditionInterface extends Cloneable {

    public boolean test();

    public String getName();
}
