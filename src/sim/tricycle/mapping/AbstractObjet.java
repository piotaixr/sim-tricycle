/*
 */
package sim.tricycle.mapping;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public abstract class AbstractObjet implements PossedeCaseInterface{
    protected Case pos;

    /*
     * getPosition retourne la case sur laquelle se trouve la boule. @return La
     * case de la boule
     */
    public Case getPosition() {
        return pos;
    }
    /* Supprimer l'objet de la case.
     * @ensure l'objet n'est plus sur la carte.
     */
    public void supprimerObjet(){
        pos.setItem(null);
    }
    
    /* Déplace l'objet vers une autre case.
     * @param nouv la nouvelle case.
     */
    public void deplacerObjet(Case nouv){
        this.supprimerObjet();
        this.pos=nouv;
        pos.setItem(this);
    }
}