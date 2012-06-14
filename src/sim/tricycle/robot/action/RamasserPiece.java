/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Adri
 */
public class RamasserPiece extends AbstractAction{

    
    public RamasserPiece(){
        super(0);
    }
    
    public Object doExecute(Robot bot){
        bot.getTeam().setGold(bot.getTeam().getGold()+1);
        return null;
    }
    
    public String getId(){
        return "ramasserPiece";
    }
}
