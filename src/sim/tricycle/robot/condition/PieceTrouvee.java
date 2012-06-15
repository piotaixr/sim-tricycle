/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim.tricycle.robot.condition;

import sim.tricycle.robot.condition.core.AbstractCondition;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class PieceTrouvee extends AbstractCondition {
    
    @Override
    public boolean test() {
        return false;
    }

    @Override
    public String getId() {
        return "piece_trouvee";
    }

}
