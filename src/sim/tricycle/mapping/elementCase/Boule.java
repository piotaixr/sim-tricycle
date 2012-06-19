package sim.tricycle.mapping.elementCase;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.TypeCase;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Boule extends AbstractObjet {
    
    public Boule (){
        id = "Boule";
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
