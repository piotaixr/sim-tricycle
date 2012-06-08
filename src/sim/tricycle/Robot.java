/*
 */
package sim.tricycle;

import sim.tricycle.mapping.AbstractObstacle;
import sim.tricycle.mapping.Case;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Robot extends AbstractObstacle {

    public Robot(Case pos) {
        this.pos = pos;
        pos.setObstacle(this);
        
       //a dvp selon besoin !
    }
    
    
    
}
