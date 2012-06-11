package sim.tricycle.robot.condition.factory;

import java.util.Collection;
import java.util.List;
import sim.tricycle.robot.condition.ConditionInterface;
import sim.tricycle.utils.params.Parameter;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public interface ConditionFactoryInterface {

    public ConditionInterface create(String nom, List<Parameter> parameters);

    public void registerConditions(Collection<ConditionInterface> conditions);

    public void registerCondition(ConditionInterface condition);
}
