package sim.tricycle.mapping;

import sim.tricycle.mapping.elementCase.*;
import sim.tricycle.robot.Robot;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 *
 * Une case de la carte. Peut porter un objet ou être un obstacle.
 */
public class Case implements CaseInterface {

    private AbstractObstacle obstacle = null;
    private AbstractObjet objet = null;
    private AbstractZone zone = null;
    private int x, y;
    private String idImg = "X";
    private boolean ciblable;


    public Case(int cx, int cy) {
        this.x = cx;
        this.y = cy;
        obstacle = null;
        objet = null;
        ciblable = true;
    }

    /**
     * Crée une case selon un identificateur: ' ': case vide. 'O': case avec une
     * boule. 'B': case avec un bonus. 'P': case avec une pièce. 'X' ou 'A':
     * case obstacle. 'T': case avec une tour. '@': case avec un point de
     * controle. '>': case avec une base.
     */
    public Case(String id, int cx, int cy) {
        this.x = cx;
        this.y = cy;
        switch (id.charAt(0)) {
            case 'X':
                setObstacle(new Mur());
                objet = null;
                break;

            case 'T':
                setObstacle(new Tour());
                objet = null;
                break;

            case '>':
                setObstacle(new Mur());
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
                setObstacle(new Mur());
                objet = null;
                break;

            default:
                obstacle = null;
                objet = null;
        }
        this.idImg = id;
        ciblable = true;
    }
    
    public AbstractZone getZone() {
        return this.zone;
    }
    
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    /**
     * Fournit l'identifiant précis de ce qu'il représente graphiquement.
     *
     * @return son id.
     */
    @Override
    public String getId() {
        return idImg;
    }

    /**
     * Retourne si a case possède t-elle un objet.
     *
     * @return 0 si absence d'objet.
     */
    @Override
    public boolean hasItem() {
        return (objet != null);
    }
    
    /**
     * Retourne si a case possède t-elle une zone.
     *
     * @return 0 si absence de zone.
     */
    public boolean hasZone() {
        return this.zone!=null;
    }
    
    /**
     * Retourne si a case est un obstacle.
     *
     * @return 0 si absence d'objet.
     */
    @Override
    public boolean hasObstacle() {
        return (obstacle != null);
    }

    /**
     * Supression de l'objet.
     */
    @Override
    public void suprObjet() {
        this.objet = null;
    }

    /**
     * Supression de l'obstacle.
     */
    @Override
    public void suprObstacle() {
        this.obstacle = null;
    }

    /**
     * setItem place un objet sur la case.
     *
     * @param ob l'objet à placer.
     * @param l'objet à placer.
     */
    @Override
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
    @Override
    public void setObstacle(AbstractObstacle obst) {
        if (this.hasObstacle()) {
//            throw new CaseMultipleObstacleException("Superpostion d'obstacles.");
        } else {
            this.obstacle = obst;
            obst.setPos(this);
        }
    }

    /**
     * Copie d'une autre case.
     *
     * @param nouv la case à copiée.
     */
    @Override
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
            return this.getItem().toString();
        }
        if (this.hasObstacle()) {
            return this.getObstacle().toString();
        }

        return " . ";
    }

    /**
     * Indique quel est le type de la case.
     *
     * @return le type de la case
     */
    @Override
    public TypeCase whoIam() {

        if (this.hasItem()) {
            return this.getItem().whoIam();
        }
        if (this.hasObstacle()) {
            return this.getObstacle().whoIam();
        }

        return TypeCase.vide;
    }

    /**
     * Renvoi l'objet associé.
     *
     * @return l'objet.
     */
    @Override
    public AbstractObjet getItem() {
        return this.objet;
    }

    /**
     * Renvoi l'obstacle associé.
     *
     * @return l'obstacle.
     */
    @Override
    public AbstractObstacle getObstacle() {
        return this.obstacle;
    }

    @Override
    public boolean robotPresent() {
        boolean res = false;
        if (this.hasObstacle() && this.getObstacle().whoIam() == TypeCase.robot) {
            res = true;
        }
        return res;
    }

    @Override
    public Robot getRobotPresent() {
        Robot rob = null;
        if (this.robotPresent()) {
            rob = (Robot) this.getObstacle();
        }
        return rob;
    }

    @Override
    public void setZone(AbstractZone zo) {
        this.zone = zo;
    }

    @Override
    public boolean equals(Case c) {
        return (c.x == this.x && c.y == this.y);
    }
    
    public boolean isCiblable() {
        return ciblable;
    }

    public void setCiblable(boolean ciblable) {
        this.ciblable = ciblable;
    }
}
