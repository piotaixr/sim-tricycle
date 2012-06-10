package sim.tricycle.robot.condition.factory;

import java.util.Collection;
import java.util.List;
import org.jdom2.Element;
import sim.tricycle.robot.condition.ConditionInterface;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public interface ConditionFactoryInterface {

    public ConditionInterface create(String nom, List<Element> parameters);

    public void registerConditions(Collection<ConditionInterface> conditions);

    public void registerCondition(ConditionInterface condition);
}
