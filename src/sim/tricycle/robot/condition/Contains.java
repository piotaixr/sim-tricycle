package sim.tricycle.robot.condition;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.PossedeCaseInterface;
import sim.tricycle.mapping.elementCase.AbstractObjet;
import sim.tricycle.mapping.elementCase.AbstractObstacle;
import sim.tricycle.mapping.elementCase.AbstractZone;
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

        if (obj instanceof AbstractObjet) {
            if (c.hasItem()) {
                return c.getItem().equals(obj);
            } else {
                return false;
            }
        } else if (obj instanceof AbstractZone) {
            if (c.hasZone()) {
                return c.getZone().equals(obj);
            } else {
                return false;
            }
        } else if (obj instanceof AbstractObstacle) {
            if (c.hasZone()) {
                return c.getObstacle().equals(obj);
            } else {
                return false;
            }
        }
        return false;
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
