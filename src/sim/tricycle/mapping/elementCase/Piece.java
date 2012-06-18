package sim.tricycle.mapping.elementCase;

import sim.tricycle.mapping.TypeCase;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Piece extends AbstractObjet {

    @Override
    public TypeCase whoIam() {
        return (TypeCase.piece);
    }

    @Override
    public String toString() {
        return " P ";
    }
}
