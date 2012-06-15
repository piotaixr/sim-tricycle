/*

 */

package sim.tricycle.mapping.elementCase;

import java.util.HashSet;
import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.PossedeCaseInterface;
import sim.tricycle.mapping.TypeCase;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class AbstractZone implements PossedeCaseInterface {
    protected HashSet<Case> liste;
    protected Case pos;

    @Override
    public Case getPosition() {
        return pos;
    }

    @Override
    public TypeCase whoIam() {
        return (TypeCase.zone);
    }

    @Override
    public String toString() {
        return "Z";
    }

    @Override
    public int obstacleItem() {
        return 3;
    }

}
