/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.mapping.elementCase;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.TypeCase;

/**
 *
 * @author marion
 */
public class Tour extends AbstractBatiment{
    
        
    public Tour(Case pos) {
        this.pos = pos;
        pos.setObstacle(this);
        this.porteeMax = 3;
        this.prix = 2;
        this.tempsMax = 2;
        this.temps = 0;
        this.portee = 0;

    }

    @Override
    public TypeCase whoIam() {
        return (TypeCase.tour);
    }

    @Override
    public String toString() {
        return " T ";
    }
    
}
