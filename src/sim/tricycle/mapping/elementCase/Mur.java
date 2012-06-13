/*
 */
package sim.tricycle.mapping.elementCase;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.TypeCase;

/**
 *
 * @author augustin
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Mur extends AbstractObstacle {

    public Mur(Case pos) {
        this.pos = pos;
        pos.setObstacle(this);
    }

    @Override
    public TypeCase whoIam() {
        return (TypeCase.mur);
    }

    @Override
    public String toString() {
        return " # ";
    }
}
