/*
 */
package sim.tricycle.mapping.elementCase;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.team.Team;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Base extends AbstractObjet {

    private Team t = null;

    public Base(Case pos,Team eq) {
        this.pos = pos;
        pos.setItem(this);
        this.t=eq;
    }

    @Override
    public TypeCase whoIam() {
        return (TypeCase.base);
    }

    @Override
    public String toString() {
        return " > ";
    }
}
