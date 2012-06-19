/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractActionComposee;
import sim.tricycle.utils.ActionBuilder;

/**
 *
 * @author Adri
 */
public class CollecterPiecesEnContinu extends AbstractActionComposee{

    public CollecterPiecesEnContinu(ActionBuilder builder) {
        super(builder);
    }
    
    public Object doExecute(Robot bot){
        getBuilder().addNewReturn("pieceplusproche","piece")
                    .addNew("collecter", getBuilder().buildVariable("piece"));
        return null;
    }
    
    public String getId(){
        return "collecterencontinu";
    }
}
