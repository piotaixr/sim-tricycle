/*
 */
package sim.tricycle.mapping;

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
    
            public String toString(){
            return "B";
        }
}
