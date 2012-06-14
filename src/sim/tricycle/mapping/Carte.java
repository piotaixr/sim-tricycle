package sim.tricycle.mapping;

import java.util.HashSet;
import sim.tricycle.mapping.elementCase.AbstractObjet;
import sim.tricycle.mapping.elementCase.AbstractObstacle;
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
        if (x > tailleX || y > tailleY || x < 0 || y < 0) {
            throw new CasesHorsMatriceDemandeException("Hors limite de la matrice");
        }
        return carte[x][y];
    }

    @Override
    public void actualiserCarte(Carte source, int rayon, Case pos) {
        HashSet<Case> liste = new HashSet<Case>();

        // Capture de toute les cases dans le rayon souhaité.
        liste.add(source.getCase(pos.getX(), pos.getY()));
        while (rayon > 0) {
            HashSet<Case> newliste = (HashSet<Case>) liste.clone();

            for (Case x : newliste) {
                casesVoisines(source, source.getCase(x.getX(), x.getY()), liste);
            }
            rayon--;
        }
        System.out.print("liste crée    ");
        System.out.print(liste.toString());
        // Traitement des cases selectionnées:
        for (Case x : liste) {
            this.getCase(x.getX(), x.getY()).copy(x);
        }
    }

    @Override
    public void casesVoisines(Carte source, Case pos, HashSet<Case> liste) {

        // Si case en bordure verticale droite:
        if ((this.tailleX - 1) > pos.getX()) {
            Case droite = source.getCase(pos.getX() + 1, pos.getY());
            if (!(liste.contains(droite))) {
                liste.add(droite);
                //System.out.println("Droite");
            }
        }
        // Si case en bordure verticale gauche:
        if (pos.getX() > 0) {
            Case gauche = source.getCase(pos.getX() - 1, pos.getY());
            if (!liste.contains(gauche)) {
                liste.add(gauche);
                // System.out.println("Gauche");
            }
        }
        // Si case en bordure horizontale gauche:
        if (pos.getY() > 0) {
            Case haut = source.getCase(pos.getX(), pos.getY() - 1);
            if (!liste.contains(haut)) {
                liste.add(haut);
                //  System.out.println("Haut");
            }
        }
        // Si case en bordure horizontale droite:
        if ((this.tailleY - 1) > pos.getY()) {
            Case bas = source.getCase(pos.getX(), pos.getY() + 1);
            if (!liste.contains(bas)) {
                liste.add(bas);
                //   System.out.println("Bas");
            }
        }
    }

    @Override
    public int getHauteur() {
        return this.tailleY;
    }

    @Override
    public int getLargeur() {
        return this.tailleX;
    }

    @Override
    public void pop(PossedeCaseInterface e) {
        int l, h;
        Case c;
        do {
            l = (int) (Math.random() * this.getLargeur());
            h = (int) (Math.random() * this.getHauteur());
            c = this.getCase(l, h);
        } while (c.hasItem() || c.hasObstacle());
        if (e.obstacleItem() == 1) {
            c.setItem((AbstractObjet)e);
        }
        if (e.obstacleItem() == 2) {
            c.setObstacle((AbstractObstacle)e);
        }
    }
}
