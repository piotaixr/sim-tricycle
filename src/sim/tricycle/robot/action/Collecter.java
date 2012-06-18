/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import java.util.ArrayDeque;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractActionComposee;
import sim.tricycle.robot.action.core.ActionInterface;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author Adri
 */
public class Collecter extends AbstractActionComposee{
    private Variable varPiece;
    
    public Collecter() {
        super();
    }
    
    @Override
    public Object doExecute(Robot bot){
        return null;
    }
    
    @Override
    public String getId(){
        return "collecter";
    }
    
    @Override
    public ArrayDeque<ActionInterface> getSuiteActions() {
        return super.getSuiteActions();
    }
    
    public void setParameters(Variable varPiece){
        this.varPiece = varPiece;
    }

    
    public void setSuiteActions() {
//        TrouveCollectable tc = new TrouveCollectable();
//        CollecterUnePiece cup = new CollecterUnePiece();
//        cup.setPiece((Piece)tc.getC().myItem());
//        RevenirBase rb = new RevenirBase();
//        this.suiteActions.add(cup);
//        this.suiteActions.add(rb);
    }

    
}
