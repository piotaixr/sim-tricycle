/*
 */
package sim.tricycle.mapping.elementCase;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.robot.Robot;
import sim.tricycle.team.Team;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Base extends AbstractZone {

    private Team t = null;

    public Base(Case pos,Team eq) {
        this.pos = pos;
        pos.setZone(this);
        this.t=eq;
    }

    @Override
    public TypeCase whoIam() {
        return (TypeCase.base);
    }

    @Override
    public String toString() {
        return " > ";
    }
    
    public boolean invocationPossible(){
        return !pos.hasObstacle();
    }
    /**
     * crée un robot de la team sur la base.
     * @param Rob 
     */
    public void popRob(Robot rob){
        
        pos.setObstacle(rob);
    }
}
