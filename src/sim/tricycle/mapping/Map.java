/*
 */
package sim.tricycle.mapping;

import java.util.HashSet;
import java.util.Set;
import sim.tricycle.mapping.mapException.CasesHorsMatriceDemandeException;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Map implements MapInterface {

    private int tailleX, tailleY;
    private Case[][] carte;

    public Map(int X, int Y) {
        carte = new Case[X][Y];
        int i, j;

        this.tailleX = X;
        this.tailleY = Y;

        //parcours du tableau pour initialiser les cases.
        for (i = 1; i <= tailleX; i++) {
            for (j = 1; j <= tailleY; j++) {
                carte[i][j] = new Case(i, j);
            }
        }
    }

    /*
     * Création d'une carte à partir d'une matrice d'entier. @ensure la carte
     * correspond aux informations fournit. ' ': case vide. 'O': case avec une
     * boule. 'B': case avec un bonus. 'P': case avec une pièce. 'X': case
     * obstacle.
     */
    public Map(char[][] tab) {
        this.tailleX = tab.length;
        this.tailleY = tab[0].length;
        carte = new Case[this.tailleX][this.tailleY];
        int i, j;

        //parcours du tableau pour initialiser les cases.
        for (i = 1; i <= tailleX; i++) {
            for (j = 1; j <= tailleY; j++) {
                carte[i][j] = new Case(tab[i][j], i, j);
            }
        }
    }

    @Override
    public Case getCase(int x, int y) {
        if (x > tailleX || y > tailleY) {
            throw new CasesHorsMatriceDemandeException("Hors limite de la matrice");
        }
        return carte[x][y];
    }

    @Override
    public void actualiserCarte(Map source, int rayon, Case pos) {
        HashSet<Case> liste = null;

        // Capture de toute les cases dans le rayon souhaité.
        while (rayon > 0) {
            liste.addAll(casesVoisines(pos, liste));
            rayon--;
        }
        // Traitement des cases selectionnées:
      //  for (int i = 0; i < liste.size(); ++i) {
            
        //}


    }

    @Override
    public HashSet<Case> casesVoisines(Case pos, HashSet<Case> liste) {
        Case gauche = this.getCase(pos.getX() - 1, pos.getY());
        Case droite = this.getCase(pos.getX() + 1, pos.getY());
        Case haut = this.getCase(pos.getX(), pos.getY() + 1);
        Case bas = this.getCase(pos.getX(), pos.getY() + 1);

        // Si case en bordure verticale droite:
        if (this.tailleX <= pos.getX()) {
            if (!liste.contains(droite)) {
                liste.add(this.getCase(pos.getX() + 1, pos.getY()));
            }
        }
        // Si case en bordure verticale gauche:
        if (this.tailleX >= 0) {
            if (!liste.contains(gauche)) {
                liste.add(gauche);
            }
        }
        // Si case en bordure horizontale gauche:
        if (this.tailleY >= 0) {
            if (!liste.contains(bas)) {
                liste.add(bas);
            }
        }
        // Si case en bordure horizontale droite:
        if (this.tailleY <= pos.getY()) {
            if (!liste.contains(haut)) {
                liste.add(haut);
            }
        }
        return liste;
    }

    public int getHauteur() {
        return this.tailleY;
    }

    public int getLargeur() {
        return this.tailleX;
    }
}
