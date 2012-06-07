/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
