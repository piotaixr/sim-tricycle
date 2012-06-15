package sim.tricycle.mapping;

import sim.tricycle.mapping.elementCase.*;
import sim.tricycle.mapping.mapException.CaseMultipleObjetException;
import sim.tricycle.mapping.mapException.CaseMultipleObstacleException;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 *
 * Une case de la carte. Peut porter un objet ou être un obstacle.
 */
public class Case implements CaseInterface {

    private Carte carte = null;
    private AbstractObstacle obstacle;
    private AbstractObjet objet;
    private int x;
    private int y;
    private String idImg = "X";

    public Case(int cx, int cy) {
        this.x = cx;
        this.y = cy;
        obstacle = null;
        objet = null;
    }

    /**
     * Crée une case selon un identificateur:      
     * ' ': case vide. 
     * 'O': case avec une boule. 
     * 'B': case avec un bonus. 
     * 'P': case avec une pièce. 
     * 'X' ou 'A': case obstacle.
     * 'T': case avec une tour.
     * '@': case avec un point de controle.
     * '>': case avec une base.
     */
    public Case(String id, int cx, int cy) {
        this.x = cx;
        this.y = cy;
        switch (id.charAt(0)) {
            case 'X':
                obstacle = new Mur(this);
                objet = null;
                break;

            case 'T':
                obstacle = new Tour(this);
                objet = null;
                break;

            case '>':
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
        this.idImg = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Fournit l'identifiant précis de ce qu'il représente graphiquement.
     *
     * @return son id.
     */
    public String getId() {
        return idImg;
    }

    /**
     * Retourne si a case possède t-elle un objet.
     *
     * @return 0 si absence d'objet.
     */
    public boolean hasItem() {
        return (objet != null);
    }

    /**
     * Retourne si a case est un obstacle.
     *
     * @return 0 si absence d'objet.
     */
    public boolean hasObstacle() {
        return (obstacle != null);
    }

    /**
     * Supression de l'objet.
     */
    public void suprObjet() {
        this.objet = null;
    }

    /**
     * Supression de l'obstacle.
     */
    public void suprObstacle() {
        this.obstacle = null;
    }

    /**
     * setItem place un objet sur la case.
     *
     * @param ob l'objet à placer.
     * @param l'objet à placer.
     */
    public void setItem(AbstractObjet ob) {
        if (this.objet != null) {
            //      throw new CaseMultipleObjetException("Superpostion d'objets.");
        } else {
            this.objet = ob;
        }
    }

    /**
     * setObstacle place un objet sur la case.
     *
     * @param obst l'objet à placer.
     */
    public void setObstacle(AbstractObstacle obst) {
        if (this.hasObstacle()) {
//            throw new CaseMultipleObstacleException("Superpostion d'obstacles.");
        } else {
            this.obstacle = obst;
            this.idImg = "X";
        }
    }

    /**
     * Copie d'une autre case.
     *
     * @param nouv la case à copiée.
     */
    public void copy(Case nouv) {
        this.objet = nouv.objet;
        this.obstacle = nouv.obstacle;
    }

    @Override
    public String toString() {
        if (this.hasItem() && this.hasObstacle()) {
            return " ";
        }

        if (this.hasItem()) {
            return this.myItem().toString();
        }
        if (this.hasObstacle()) {
            return this.myObstacle().toString();
        }

        return " . ";
    }

    /**
     * Indique quel est le type de la case.
     *
     * @return le type de la case
     */
    public TypeCase whoIam() {

        if (this.hasItem()) {
            return this.myItem().whoIam();
        }
        if (this.hasObstacle()) {
            return this.myObstacle().whoIam();
        }

        return TypeCase.vide;
    }

    /**
     * Renvoi l'objet associé.
     *
     * @return l'objet.
     */
    public AbstractObjet myItem() {
        return this.objet;
    }

    /**
     * Renvoi l'obstacle associé.
     *
     * @return l'obstacle.
     */
    public AbstractObstacle myObstacle() {
        return this.obstacle;
    }
}
