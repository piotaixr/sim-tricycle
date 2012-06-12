/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
