package sim.tricycle.mapping.elementCase;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.PossedeCaseInterface;
import sim.tricycle.mapping.TypeCase;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class AbstractObstacle implements PossedeCaseInterface {

    protected Case pos;

    public void setPos(Case pos) {
        this.pos = pos;
    }

    @Override
    public Case getPosition() {
        return pos;
    }

    public void supprimerObstacle() {
        pos.suprObstacle();
    }

    @Override
    public TypeCase whoIam() {
        return (TypeCase.obstacle);
    }

    @Override
    public String toString() {
        return "X";
    }

    @Override
    public int obstacleItem() {
        return 2;
    }
}
