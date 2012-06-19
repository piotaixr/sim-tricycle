/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim.tricycle.robot.condition.multiple;

import sim.tricycle.robot.condition.core.AbstractConditionMultiple;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class ConditionOu extends AbstractConditionMultiple {

    @Override
    protected boolean combine(boolean res1, boolean res2) {
        return res1 || res2;
    }

    @Override
    protected boolean oneValue(boolean res) {
        return res;
    }

    @Override
    public String getId() {
        return "ou";
    }

}
