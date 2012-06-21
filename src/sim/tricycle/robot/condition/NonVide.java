/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim.tricycle.robot.condition;

import sim.tricycle.robot.condition.core.AbstractCondition;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class NonVide extends AbstractCondition {

    private Variable var;
    
    @Override
    public boolean test() {
        return var.getValue() != null;
    }

    @Override
    public String getId() {
        return "non_vide";
    }
    
    public void setParameters(Variable var){
        this.var = var;
    }

}
