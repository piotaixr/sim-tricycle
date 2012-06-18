package sim.tricycle.robot.condition;

import sim.tricycle.robot.condition.core.AbstractCondition;
import sim.tricycle.utils.params.types.Reference;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class Contains extends AbstractCondition {

    @Override
    public boolean test() {
        return true;
    }

    @Override
    public String getId() {
        return "contains";
    }
    
    public void setParameters(String refcase, String refpiece){
        
    }
}
