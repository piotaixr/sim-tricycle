package sim.tricycle.mapping.elementCase;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.TypeCase;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Boule extends AbstractObjet {

    /*
     * Constructeur d'une boule. @param pos la case de la boule.
     */
    public Boule(Case pos) {
        this.pos = pos;
        pos.setItem(this);
    }

    @Override
    public TypeCase whoIam() {
        return (TypeCase.boule);
    }

    @Override
    public String toString() {
        return " B ";
    }
}
