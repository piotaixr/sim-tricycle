/*
 */
package sim.tricycle.mapping;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 * 
 * Une case de la carte.
 * Peut porter un objet
 */
public class Case {
    private Obstacle obs;
    private Objet obj;

    
    public Case (){
        obs=null;
        obj=null;
    }
    
    /*
     * Retourne si a case possède t-elle un objet. 
     * @return 0 si absence d'objet.
     */
    public boolean hasItem() {
        return (obj != null);
    }
    
     /*
     * Retourne si a case est un obstacle. 
     * @return 0 si absence d'objet.
     */
    public boolean hasObstacle() {
        return (obs != null);
    }

    /*
     * setItem place un objet sur la case. @param: l'objet à placer.
     * @param l'objet à placer.
     */
    public void setItem(Objet ob) throws CaseMultipleObjet {
        if (this.hasItem()) {
            throw new CaseMultipleObjet("Objet placer sur une case objet.");
        } else {
            this.obj = ob;
        }
    }
    
    
}
