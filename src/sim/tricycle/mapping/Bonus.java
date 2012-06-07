package sim.tricycle.mapping;

/*
 */

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Bonus extends AbstractObjet{
    
    public Bonus (Case pos) {
        this.pos=pos;
        pos.setItem(this);
    }
}
