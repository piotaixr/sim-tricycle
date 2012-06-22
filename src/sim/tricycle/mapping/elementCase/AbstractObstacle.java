package sim.tricycle.mapping.elementCase;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.PossedeCaseInterface;
import sim.tricycle.mapping.TypeCase;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class AbstractObstacle implements PossedeCaseInterface {

    protected Case position;

    @Override
    public Case getPosition() {
        return position;
    }

    public void supprimerObstacle() {
        position.suprObstacle();
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
    public TypeCase typeDeCase() {
        return TypeCase.obstacle;
    }

    @Override
    public void setPosition(Case c) {
        position = c;
    }
}
