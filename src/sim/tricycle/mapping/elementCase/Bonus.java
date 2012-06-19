package sim.tricycle.mapping.elementCase;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.TypeCase;

/*
 */
/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Bonus extends AbstractObjet {
    
    public Bonus(){
        id = "Bonus";
    }


    @Override
    public TypeCase whoIam() {
        return (TypeCase.bonus);
    }

    @Override
    public String toString() {
        return " * ";
    }
}
