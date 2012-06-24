package sim.tricycle.robot.condition.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public abstract class AbstractConditionMultiple extends AbstractCondition {

    protected List<ConditionInterface> conditions;

    protected abstract boolean combine(boolean res1, boolean res2);

    @Override
    public boolean test() {
        Iterator<ConditionInterface> it = conditions.iterator();
        boolean res = it.next().test();
        if (!it.hasNext()) {
            return oneValue(res);
        }

        while (it.hasNext()) {
            res = combine(res, it.next().test());
        }

        return res;
    }

    protected abstract boolean oneValue(boolean res);

    public void addCondition(ConditionInterface condition) {
        conditions.add(condition);
    }

    public void reset() {
        conditions = new ArrayList<ConditionInterface>();
    }
}
