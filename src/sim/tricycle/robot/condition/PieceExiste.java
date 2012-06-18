/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.condition;

import sim.tricycle.Ordonnanceur.Ordonnanceur;
import sim.tricycle.mapping.Carte;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.condition.core.AbstractCondition;

/**
 *
 * @author Adri
 */
public class PieceExiste extends AbstractCondition {
    private Ordonnanceur o;

    public PieceExiste(Ordonnanceur o) {
        this.o = o;
    }
    
    @Override
    public String getId(){
        return "pieceexiste";
    }

    @Override
    public boolean test() {
        Robot bot = (Robot) o.getActiveTask();
        Carte c = bot.getMapObjective();
        for(int i=0; i< c.getHauteur(); i++){
            for(int j = 0; i< c.getLargeur(); i++){
                if(c.getCase(i, j).whoIam() == TypeCase.piece)
                    return true;
            }
        }
        return false;
    }
    
}
