/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.condition.core;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.elementCase.Piece;
import sim.tricycle.utils.params.types.Reference;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class TestCaseRobotEgalCasePiece extends AbstractCondition {

    private Reference refCase;
    private Reference refPiece;

    public TestCaseRobotEgalCasePiece(Reference refCase, Reference refPiece) {
        this.refCase = refCase;
        this.refPiece = refPiece;
    }

    @Override
    /**
     * @todo creer une methode dans case pour tester l'egalite de deux cases
     */
    public boolean test() {
        Case c = (Case) refCase.getValue();
        Case cp = ((Piece)refPiece.getValue()).getPosition();
        
        return c.equals(cp);
    }

    @Override
    public String getId() {
        return "case==piece";
    }
}
