/*
 */
package sim.tricycle.mapping;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Map implements MapInterface {
    private int tailleX,tailleY;
    private Case[][] carte;

    public Map(int tailleX, int tailleY) {
        carte = new Case[tailleX][tailleY];
        int i, j;

        //parcours du tableau pour initialiser les cases.
        
    }
    
    public void initMap (){
        int i, j;
        for (i = 1; i <= tailleX; i++) {
            for (j = 1; j <= tailleY; j++) {
                carte[i][j] = new Case();
            }
        }
    }
    
}
