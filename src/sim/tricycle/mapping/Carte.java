package sim.tricycle.mapping;

import java.util.HashSet;
import sim.tricycle.mapping.elementCase.AbstractObjet;
import sim.tricycle.mapping.elementCase.AbstractObstacle;
import sim.tricycle.mapping.elementCase.PointDeControle;
import sim.tricycle.mapping.mapException.CasesHorsMatriceDemandeException;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Carte implements CarteInterface {

    HashSet<PointDeControle> listePt;
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

    /**
     * Création d'une carte à partir d'une matrice d'entier. @ensure la carte
     * correspond aux informations fournit. ' ': case vide. 'O': case avec une
     * boule. 'B': case avec un bonus. 'P': case avec une pièce. 'X' ou 'A':case
     * obstacle. 'T': case avec une tour. '@': case avec un point de controle.
     * '>': case avec une base.
     */
    public Carte(String[][] tab) {
        HashSet<Case> liste = new HashSet<Case>();
        HashSet<PointDeControle> listeP = new HashSet<PointDeControle>();

        this.tailleX = tab.length;
        this.tailleY = tab[0].length;
        carte = new Case[this.tailleX][this.tailleY];
        int i, j;

        //parcours du tableau pour initialiser les cases.
        for (i = 0; i < tailleX; i++) {
            for (j = 0; j < tailleY; j++) {
                if (!"@".equals(tab[i][j])) {
                    carte[i][j] = new Case(tab[i][j], i, j);
                }
            }
        }
        //Recherche des points de controles et traitement.
        for (i = 0; i < tailleX; i++) {
            for (j = 0; j < tailleY; j++) {
                if ("@".equals(tab[i][j])) {
                    //Si pt de controle il lui faut connaitre ses cases voisines.
                    carte[i][j] = new Case(i, j);
                    casesVoisines(this, this.getCase(i, j), liste);
                    PointDeControle pt = new PointDeControle(this.getCase(i, j), liste);
                    this.getCase(i, j).setZone(pt);
                    //On ajoute ce point à la liste des points.
                    listeP.add(pt);
                }
                this.listePt = listeP;
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
                System.out.println("Droite");
            }
        }
        // Si case en bordure verticale gauche:
        if (pos.getX() > 0) {
            Case gauche = source.getCase(pos.getX() - 1, pos.getY());
            if (!liste.contains(gauche)) {
                liste.add(gauche);
                System.out.println("Gauche");
            }
        }
        // Si case en bordure horizontale gauche:
        if (pos.getY() > 0) {
            Case haut = source.getCase(pos.getX(), pos.getY() - 1);
            if (!liste.contains(haut)) {
                liste.add(haut);
                System.out.println("Haut");
            }
        }
        // Si case en bordure horizontale droite:
        if ((this.tailleY - 1) > pos.getY()) {
            Case bas = source.getCase(pos.getX(), pos.getY() + 1);
            if (!liste.contains(bas)) {
                liste.add(bas);
                System.out.println("Bas");
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
            c.setItem((AbstractObjet) e);
        }
        if (e.obstacleItem() == 2) {
            c.setObstacle((AbstractObstacle) e);
        }
    }

    @Override
    public void pop(PossedeCaseInterface e, int x, int y) {
        Case c = getCase(x,y);
        if (c.hasItem() || c.hasObstacle()){
            if (e.obstacleItem() ==1) {
                c.setItem((AbstractObjet)e);                
            }
            if (e.obstacleItem()==2) {
                c.setObstacle((AbstractObstacle)e);
            }
        }
        else throw new RuntimeException("Il y a déjà quelque chose sur la case");
    }

    @Override
    public void pop(PossedeCaseInterface e, Case c) {
        if (e.obstacleItem() == 1) {
            c.setItem((AbstractObjet) e);
        }
        if (e.obstacleItem() == 2) {
            c.setObstacle((AbstractObstacle) e);
        }
    }

    @Override
    public void routinePt() {
        if (!listePt.isEmpty()) {
            for (PointDeControle x : this.listePt) {
                x.analyseCapture();
            }
        }
    }
}
