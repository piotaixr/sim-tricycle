/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.elementCase.Piece;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractActionComposee;
import sim.tricycle.utils.ActionBuilder;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author Adri
 */
public class Collecter extends AbstractActionComposee {

    private Variable varPiece;

    public Collecter(ActionBuilder builder) {
        super(builder);
    }

    @Override
    protected Object doExecute(Robot bot) {
        Piece piece = (Piece) varPiece.getValue();
        
        //on crée les "sous-actions"
        getBuilder().addNewReturn("trouvechemin", "chemin", getBuilder().buildVariable("piece"))
                .addNew("allera", getBuilder().buildVariable("chemin"))
                .addNew("ramasser");
        
        return null;
    }

    @Override
    public String getId() {
        return "collecter";
    }

    public void setParameters(Variable varPiece) {
        this.varPiece = varPiece;
    }

//    public void computeNewActions() {
//
////        TrouveCollectable tc = new TrouveCollectable();
////        CollecterUnePiece cup = new CollecterUnePiece();
////        cup.setPiece((Piece)tc.getC().myItem());
////        RevenirBase rb = new RevenirBase();
////        this.suiteActions.add(cup);
////        this.suiteActions.add(rb);
//    }
}
