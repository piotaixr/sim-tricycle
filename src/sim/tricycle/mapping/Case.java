/*
 */
package sim.tricycle.mapping;

import sim.tricycle.mapping.mapException.CaseMultipleObjetException;
import sim.tricycle.mapping.mapException.CaseMultipleObstacleException;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 * 
 * Une case de la carte.
 * Peut porter un objet
 */
public class Case {
    private Obstacle obs;
    private AbstractObjet obj;

    
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
    public void setItem(AbstractObjet ob) {
        if (this.hasItem()) {
            throw new CaseMultipleObjetException("Superpostion d'objets.");
        } else {
            this.obj = ob;
        }
    }
    
     /*
     * setItem place un objet sur la case. @param: l'objet à placer.
     * @param l'objet à placer.
     */
    public void setObstacle(Obstacle obst) {
        if (this.hasObstacle()) {
            throw new CaseMultipleObstacleException("Superpostion d'obstacles.");
        } else {
            this.obs = obst;
        }
    }
    
    
}
