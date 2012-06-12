/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim.tricycle.robot.condition;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public abstract class AbstractCondition implements ConditionInterface {

    @Override
    public ConditionInterface clone() throws CloneNotSupportedException{
        return (ConditionInterface) super.clone();
    }

}
