package sim.tricycle.mapping;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class AbstractObstacle implements PossedeCaseInterface {

    protected Case pos;

    @Override
    public Case getPosition() {
        return pos;
    }

    public void supprimerObstacle() {
        pos.setObstacle(null);
    }

    @Override
    public TypeCase whoIam() {
        return (TypeCase.obstacle);
    }

    @Override
    public String toString() {
        return "X";
    }
}
