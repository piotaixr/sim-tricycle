/*
 */
package sim.tricycle.mapping;

import sim.tricycle.mapping.mapException.CasesHorsMatriceDemandeException;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Map implements MapInterface {
    private int tailleX,tailleY;
    private Case[][] carte;

    public Map(int X, int Y) {
        carte = new Case[X][Y];
        int i, j;
        
        this.tailleX=X;
        this.tailleY=Y;
        
        //parcours du tableau pour initialiser les cases.
        for (i = 1; i <= tailleX; i++) {
            for (j = 1; j <= tailleY; j++) {
                carte[i][j] = new Case();
            }
        }
    }
    
    /* Création d'une carte à partir d'une matrice d'entier.
     * @ensure la carte correspond aux informations fournit.
     * 0: case vide.
     * 1: case avec une boule.
     * 2: case avec un bonus.
     * 3: case avec une pièce.
     * 4: case obstacle.
     */
    public Map (int[][] tab){
        this.tailleX=tab.length;
        this.tailleY=tab[0].length;
        carte = new Case[this.tailleX][this.tailleY];   
        int i, j;
        
        //parcours du tableau pour initialiser les cases.
        for (i = 1; i <= tailleX; i++) {
            for (j = 1; j <= tailleY; j++) {
                carte[i][j] = new Case(tab[i][j]);
            }
        }
        
    }

    @Override
    public Case getCase(int x, int y) {
        if (x>tailleX || y > tailleY){
        throw new CasesHorsMatriceDemandeException("Hors limite de la matrice");
        }
        return carte [x][y];
    }
    
  
    
}
