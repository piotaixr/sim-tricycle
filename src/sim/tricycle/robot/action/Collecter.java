/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import java.util.ArrayDeque;
import sim.tricycle.mapping.elementCase.Piece;
import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractActionComposee;

/**
 *
 * @author Adri
 */
public class Collecter extends AbstractActionComposee{
    


    public Collecter() {
        this.suiteActions=new ArrayDeque();
        this.suiteActions.add(new TrouveCollectable());
        this.suiteActions.add(new TrouveChemin());
        this.suiteActions.add(new AllerA());
        this.suiteActions.add(new Ramasser());
    }
    
    public Object doExecute(Robot bot){
        bot.setActions(suiteActions);
        return null;
    }
    
    public String getId(){
        return "collecterPiece";
    }
    


//    public void setPiece(Piece piece) {
//        this.piece = piece;
//        AllerA go = new AllerA();
//        go.setP(new Point(this.piece.getPosition().getX(),this.piece.getPosition().getY()));
//        Ramasser r = new Ramasser();
//        r.setRessourceParItem(this.piece);
//        
//        this.suiteActions.add(go);
//        this.suiteActions.add(r);
//        
//    }
}
