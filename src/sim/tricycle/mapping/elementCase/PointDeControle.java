/*

 */

package sim.tricycle.mapping.elementCase;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.TypeCase;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class PointDeControle extends AbstractObjet {

    public PointDeControle(Case pos) {
        this.pos = pos;
        pos.setItem(this);
    }

    @Override
    public TypeCase whoIam() {
        return (TypeCase.ptDeControle);
    }

    @Override
    public String toString() {
        return " @ ";
    }
}
