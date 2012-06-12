package sim.tricycle.robot.action.core;

import java.util.Collection;
import java.util.List;
import sim.tricycle.utils.FactoryInterface;
import sim.tricycle.utils.params.Parameter;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public interface ActionFactoryInterface extends FactoryInterface<String, ActionInterface> {

    public ActionInterface create(String nom, List<Parameter> parameters);
    
    public ActionInterface create(String nom, List<Parameter> parameters, String nomVariableDest);

    @Override
    public void registerCollection(Collection<ActionInterface> conditions);

    @Override
    public void register(ActionInterface condition);
}
