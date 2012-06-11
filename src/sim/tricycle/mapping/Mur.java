/*
 */
package sim.tricycle.mapping;

/**
 *
 * @author augustin
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Mur extends AbstractObstacle{
        
        public Mur (Case pos){
            this.pos=pos;
            pos.setObstacle(this);
        }

        public TypeCase whoIam(){
            return (TypeCase.mur);
        }
        
        public String toString(){
            return "M";
        }
}
