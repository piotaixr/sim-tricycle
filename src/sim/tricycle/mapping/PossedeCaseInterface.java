package sim.tricycle.mapping;

/**
 *
 * @author Thomas nds <nds.thomas@gmail.com>
 */
public interface PossedeCaseInterface {
    
    /*
     * getPosition retourne la case sur laquelle se trouve la boule. @return La
     * case de la boule
     */
    public Case getPosition();
    
    /* Indique quel est le type de la case.
     * @return le type de la case
     */
    public TypeCase whoIam();
    
    @Override
    public String toString ();
    
    /*renvoie 1 si c'est un objet et 2 si c'est un Obstacle*/
    public int obstacleItem ();
}
