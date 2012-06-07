package sim.tricycle.mapping;

/*
 */

/**
 *
 * @author Thomas nds <nds.thomas@gmail.com>
 */
public interface MapInterface {
    
/* renvoie la case correspondante aux coordonnées x et y.
 * @param x cooddonnée x.
 * @param y coordonnée y.
 * @return la case en question.
 */
    public Case getCase(int x,int y);
}
