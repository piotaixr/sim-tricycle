/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.condition;

import sim.tricycle.mapping.Case;
import sim.tricycle.robot.condition.core.AbstractCondition;
import sim.tricycle.utils.params.types.Reference;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class TestCaseRobotEgalCaseBase extends AbstractCondition {

    private Reference refCase;
    private Reference refPiece;

    public TestCaseRobotEgalCaseBase(Reference refCase, Reference refPiece) {
        this.refCase = refCase;
        this.refPiece = refPiece;
    }

    @Override
    /**
     */
    public boolean test() {
        Case c = (Case) refCase.getValue();
        Case cp = (Case)refPiece.getValue();
        
        return c.equals(cp);
    }

    @Override
    public String getId() {
        return "case==base";
    }
}
