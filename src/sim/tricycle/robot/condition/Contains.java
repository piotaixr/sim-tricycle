package sim.tricycle.robot.condition;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.PossedeCaseInterface;
import sim.tricycle.robot.condition.core.AbstractCondition;
import sim.tricycle.utils.params.types.Reference;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class Contains extends AbstractCondition {

    private Reference refcase;
    private Reference refpiece;

    @Override
    public boolean test() {
        Case c = (Case) refcase.getValue();
        PossedeCaseInterface obj = (PossedeCaseInterface) refpiece.getValue();
        if (c.hasItem()) {
            return c.getItem().equals(obj);
        } else {
            return false;
        }
    }

    @Override
    public String getId() {
        return "contains";
    }

    public void setParameters(Reference refcase, Variable refpiece) {
        this.refcase = refcase;
        this.refpiece = refpiece;
    }
}
