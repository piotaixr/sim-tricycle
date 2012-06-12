package sim.tricycle.robot.condition.core;

import java.util.Collection;
import java.util.List;
import sim.tricycle.utils.FactoryInterface;
import sim.tricycle.utils.params.Parameter;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public interface ConditionFactoryInterface extends FactoryInterface<String, ConditionInterface> {

    public ConditionInterface create(String nom, List<Parameter> parameters);

    @Override
    public void registerCollection(Collection<ConditionInterface> conditions);

    @Override
    public void register(ConditionInterface condition);
}
