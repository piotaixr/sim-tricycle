/*
 */
package sim.tricycle.mapping;

import java.util.HashSet;
import sim.tricycle.mapping.mapException.CasesHorsMatriceDemandeException;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Carte implements CarteInterface {

    private int tailleX, tailleY;
    private Case[][] carte;

    public Carte(int cx, int cy) {
        carte = new Case[cx][cy];
        int i, j;

        this.tailleX = cx;
        this.tailleY = cy;

        //parcours du tableau pour initialiser les cases.
        for (i = 0; i < tailleX; i++) {
            for (j = 0; j < tailleY; j++) {
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
    public Carte(char[][] tab) {
        this.tailleX = tab.length;
        this.tailleY = tab[0].length;
        carte = new Case[this.tailleX][this.tailleY];
        int i, j;

        //parcours du tableau pour initialiser les cases.
        for (i = 0; i < tailleX; i++) {
            for (j = 0; j < tailleY; j++) {
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
    public void actualiserCarte(Carte source, int rayon, Case pos) {
        HashSet<Case> liste = null;

        // Capture de toute les cases dans le rayon souhaité.
        while (rayon > 0) {
            liste.addAll(casesVoisines(pos, liste));
            rayon--;
        }
        // Traitement des cases selectionnées:
        for (Case x: liste) {
            this.getCase(x.getX(), x.getY()).copy(x);
        }
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
    
    @Override
    public int getHauteur() {
        return this.tailleY;
    }
    
    @Override
    public int getLargeur() {
        return this.tailleX;
    }
}
