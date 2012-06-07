/*
 */
package sim.tricycle.mapping;

import sim.tricycle.Robot;
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
    private AbstractObstacle obstacle;
    private AbstractObjet objet;

    
    public Case (){
        obstacle=null;
        objet=null;
    }
    
    /*
     * Retourne si a case possède t-elle un objet. 
     * @return 0 si absence d'objet.
     */
    public boolean hasItem() {
        return (objet != null);
    }
    
     /*
     * Retourne si a case est un obstacle. 
     * @return 0 si absence d'objet.
     */
    public boolean hasObstacle() {
        return (obstacle != null);
    }

    /*
     * setItem place un objet sur la case. @param: l'objet à placer.
     * @param l'objet à placer.
     */
    public void setItem(AbstractObjet ob) {
        if (this.hasItem()) {
            throw new CaseMultipleObjetException("Superpostion d'objets.");
        } else {
            this.objet = ob;
        }
    }
    
     /*
     * setItem place un objet sur la case. @param: l'objet à placer.
     * @param l'objet à placer.
     */
    public void setObstacle(AbstractObstacle obst) {
        if (this.hasObstacle()) {
            throw new CaseMultipleObstacleException("Superpostion d'obstacles.");
        } else {
            this.obstacle = obst;
        }
    }

    
    
}
