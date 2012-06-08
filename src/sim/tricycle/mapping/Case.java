/*
 */
package sim.tricycle.mapping;

import sim.tricycle.mapping.mapException.CaseMultipleObjetException;
import sim.tricycle.mapping.mapException.CaseMultipleObstacleException;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 *
 * Une case de la carte. Peut porter un objet ou être un obstacle.
 */
public class Case {

    private AbstractObstacle obstacle;
    private AbstractObjet objet;
    private int x;
    private int y;

    public Case(int cx, int cy) {
        this.x = cx;
        this.y = cy;
        obstacle = null;
        objet = null;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    /* Crée une case selon un identificateur: ' ': case vide. 'O': case avec une
     * boule. 'B': case avec un bonus. 'P': case avec une pièce. 'X': case
     * obstacle.
     */
    public Case(char id, int cx, int cy) {
        this.x = cx;
        this.y = cy;
        switch (id) {
            case 'X':
                obstacle = new Mur(this);
                objet = null;
                break;

            case 'O':
                obstacle = null;
                objet = new Boule(this);
                break;

            case 'B':
                obstacle = null;
                objet = new Bonus(this);
                break;

            case 'P':
                obstacle = null;
                objet = new Piece(this);
                break;

            case '#':
                obstacle = new Mur(this);
                objet = null;
                break;

            default:
                obstacle = null;
                objet = null;
        }
    }

    /* Retourne si a case possède t-elle un objet. @return 0 si absence d'objet.
     */
    public boolean hasItem() {
        return (objet != null);
    }

    /* Retourne si a case est un obstacle. @return 0 si absence d'objet.
     */
    public boolean hasObstacle() {
        return (obstacle != null);
    }

    /*
     * setItem place un objet sur la case. @param: l'objet à placer. @param
     * l'objet à placer.
     */
    public void setItem(AbstractObjet ob) {
        if (this.hasItem()) {
            throw new CaseMultipleObjetException("Superpostion d'objets.");
        } else {
            this.objet = ob;
        }
    }

    /* setItem place un objet sur la case. @param: l'objet à placer. @param
     * l'objet à placer.
     */
    public void setObstacle(AbstractObstacle obst) {
        if (this.hasObstacle()) {
            throw new CaseMultipleObstacleException("Superpostion d'obstacles.");
        } else {
            this.obstacle = obst;
        }
    }
    
    /* Copie d'une autre case.
     * @param nouv la case à copiée.
     * @ensure nouv == this
     */
    public void copy(Case nouv){
        this.objet= nouv.objet;
        this.obstacle=nouv.obstacle;
    }
    
}
