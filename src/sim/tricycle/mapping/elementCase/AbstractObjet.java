package sim.tricycle.mapping.elementCase;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.PossedeCaseInterface;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.robot.Point;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public abstract class AbstractObjet implements PossedeCaseInterface {

    protected Case pos;
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*
     * getPosition retourne la case sur laquelle se trouve la boule. @return La
     * case de la boule
     */
    @Override
    public Case getPosition() {
        return pos;
    }

    /*
     * Supprimer l'objet de la case. @ensure l'objet n'est plus sur la carte.
     */
    public void supprimerObjet() {
        pos.suprObjet();
    }

    /*
     * Déplace l'objet vers une autre case. @param nouv la nouvelle case.
     */
    public void deplacerObjet(Case nouv) {
        this.supprimerObjet();
        this.pos = nouv;
        pos.setItem(this);
    }

    @Override
    public String toString() {
        return "O";
    }

    @Override
    public TypeCase typeDeCase() {
        return TypeCase.objet;
    }

    @Override
    public void setPosition(Case c) {
        pos = c;
    }

    public boolean equals(Object o) {
        if (o instanceof AbstractObjet) {
            return equalsObj((AbstractObjet) o);
        } else {
            return false;
        }
    }

    public boolean equalsObj(AbstractObjet aob) {
        Point pthis = this.getPosition().toPoint();
        Point paob = aob.getPosition().toPoint();
        return pthis.getX() == paob.getX() && pthis.getY() == paob.getY();
    }
}