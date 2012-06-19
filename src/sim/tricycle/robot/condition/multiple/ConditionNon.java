/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.condition.multiple;

import sim.tricycle.robot.condition.core.AbstractConditionMultiple;
import sim.tricycle.robot.condition.core.ConditionInterface;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class ConditionNon extends AbstractConditionMultiple {

    @Override
    protected boolean combine(boolean res1, boolean res2) {
        throw new RuntimeException("On ne combine pas avec la condition non");
    }

    @Override
    protected boolean oneValue(boolean res) {
        return !res;
    }

    @Override
    public String getId() {
        return "non";
    }

    @Override
    public void addCondition(ConditionInterface condition) {
        if (conditions.isEmpty()) {
            super.addCondition(condition);
        } else {
            throw new RuntimeException("La condition 'non' ne prend qu'une condition en paramètre!");
        }

    }
}
