/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import java.util.ArrayDeque;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractActionComposee;
import sim.tricycle.robot.action.core.ActionInterface;

/**
 *
 * @author Adri
 */
public class Collecter extends AbstractActionComposee{

    public Collecter() {
        super();
    }
    
    public Object doExecute(Robot bot){
        return null;
    }
    
    public String getId(){
        return "collecterHautNiveau";
    }
    
    @Override
    public ArrayDeque<ActionInterface> getSuiteActions() {
        return super.getSuiteActions();
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
