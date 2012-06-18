/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.Carte;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractActionComposee;

/**
 *
 * @author Adri
 */
public class PiecePlusProche extends AbstractActionComposee{

    public PiecePlusProche() {
        
    }
    
    @Override
    public Object doExecute(Robot bot){
        Carte c = bot.getMapTeam();
        for(int i=0; i< c.getHauteur(); i++){
            for(int j = 0; i< c.getLargeur(); i++){
                if(c.getCase(i, j).whoIam() == TypeCase.piece)
                    return c.getCase(i, j).myItem();
            }
        }
        return null;
    }
    
    @Override
    public String getId(){
        return "pieceplusproche";
    }
    
}
