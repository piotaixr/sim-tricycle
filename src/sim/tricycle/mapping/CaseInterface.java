/*
 */
package sim.tricycle.mapping;

import sim.tricycle.mapping.elementCase.AbstractObjet;
import sim.tricycle.mapping.elementCase.AbstractObstacle;

/**
 *
 * @author Thomas nds <nds.thomas@gmail.com>
 */
public interface CaseInterface {

    public int getY();

    public int getX();
    
    /*
     * Fournit l'identifiant précis de ce qu'il représente graphiquement.
     * @return son id.
     */
    public String getId();

    /*
     * Retourne si a case possède t-elle un objet. @return 0 si absence d'objet.
     */
    public boolean hasItem();

    /*
     * Retourne si a case est un obstacle. @return 0 si absence d'objet.
     */
    public boolean hasObstacle();

    /*
     * setItem place un objet sur la case. @param l'objet à placer. @param
     * l'objet à placer.
     */
    public void setItem(AbstractObjet ob);

    /*
     * Supression de l'objet.
     */
    public void suprObjet();

    /*
     * Supression de l'obstacle.
     */
    public void suprObstacle();

    /*
     * setItem place un objet sur la case. @param l'objet à placer.
     */
    public void setObstacle(AbstractObstacle obst);

    /*
     * Copie d'une autre case. @param nouv la case à copiée.
     */
    public void copy(Case nouv);

    /*
     * Indique quel est le type de la case. @return le type de la case
     */
    public TypeCase whoIam();

    /*
     * Renvoi l'objet associé. @return l'objet.
     */
    public AbstractObjet myItem();

    /*
     * Renvoi l'obstacle associé. @return l'obstacle.
     */
    public AbstractObstacle myObstacle();
    
}
