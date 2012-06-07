/*
 */
package sim.tricycle.mapping;

/**
 *
 * @author augustin
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Obstacle implements PossedeCase{
        private Case pos;
        
        public Obstacle (Case pos){
            this.pos=pos;
            pos.setObstacle(this);
        }
}
