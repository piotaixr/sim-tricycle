/*
 */

package sim.tricycle.mapping;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class AbstractObstacle implements PossedeCaseInterface{
        protected Case pos;
        
    @Override
    public Case getPosition() {
       return pos;
    }

}
