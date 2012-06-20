/*
 */
package sim.tricycle.mapping;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import sim.tricycle.ihm.ViewCarte;
import sim.tricycle.mapping.elementCase.AbstractObjet;
import sim.tricycle.mapping.elementCase.AbstractObstacle;
import sim.tricycle.mapping.elementCase.AbstractZone;
import sim.tricycle.mapping.elementCase.PointDeControle;
import sim.tricycle.mapping.mapException.CasesHorsMatriceDemandeException;
import sim.tricycle.robot.Robot;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public abstract class AbstractCarte implements CarteInterface {

    protected Image imgFond = null;
    protected Image imgVide = null;
    protected HashSet<PointDeControle> listePt;
    protected int tailleX, tailleY;
    protected Case[][] carte;

    @Override
    public void afficherCarte() {
        int i, j;
        System.out.println("");
        for (i = 0; i < this.getLargeur(); i++) {
            for (j = 0; j < this.getHauteur(); j++) {
                System.out.print(this.getCase(i, j).toString() + this.getCase(i, j).getId());
            }
            System.out.print("\n");
        }
    }

    /**
     * Initialise la carte à partir de la matrice contenu dans l'abstraction.
     * @ensure la matrice à était initialisée
     */
    protected void initAllCases(String[][] mat) {
        int i, j;
//parcours du tableau pour initialiser les cases.
        for (i = 0; i < tailleX; i++) {
            for (j = 0; j < tailleY; j++) {
                if (!"@".equals(mat[i][j])) {
                    carte[i][j] = new Case(mat[i][j], i, j);
                }
            }
        }
    }

    /**
     * Construit la carte à partir de la matrice contenu dans l'abstraction.
     * @ensure la matrice à était initialisée
     */
    protected void placerPoint(String[][] mat) {
        int i, j;
        HashSet<Case> liste = new HashSet<Case>();
        HashSet<PointDeControle> listeP = new HashSet<PointDeControle>();

        //Recherche des points de controles et traitement.
        for (i = 0; i < tailleX; i++) {
            for (j = 0; j < tailleY; j++) {
                if ("@".equals(mat[i][j])) {
                    //Si pt de controle il lui faut connaitre ses cases voisines.
                    carte[i][j] = new Case(i, j);
                    casesVoisines(this, this.getCase(i, j), liste);
                    PointDeControle pt = new PointDeControle(liste);
                    pt.setCase(this.getCase(i, j));
                    this.getCase(i, j).setZone(pt);
                    //On ajoute ce point à la liste des points.
                    listeP.add(pt);
                }
                this.listePt = listeP;
            }
        }
    }

    public void startInit(String[][] mat) {
        this.tailleX = mat.length;
        this.tailleY = mat[0].length;
        carte = new Case[this.tailleX][this.tailleY];
        setVide("vide");
        initAllCases(mat);
        placerPoint(mat);
    }

    @Override
    public Image getImage() {
        return this.imgFond;
    }

    @Override
    public Image getVide() {
        return this.imgVide;
    }

    @Override
    public void setVide(String s) {
        try {
            // Initialisation des images:
            imgVide = ImageIO.read(new File("./src/sim/tricycle/ihm/images/cases/" + s + ".jpg"));

        } catch (IOException ex) {
            Logger.getLogger(ViewCarte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setImage(String s) {
        try {
            // Initialisation des images:
            imgFond = ImageIO.read(new File("./src/sim/tricycle/ihm/images/" + s));

        } catch (IOException ex) {
            Logger.getLogger(ViewCarte.class.getName()).log(Level.SEVERE, null, ex);
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
    public void casesVoisines(AbstractCarte source, Case pos, HashSet<Case> liste) {

        // Si case en bordure verticale droite:
        if ((this.tailleX - 1) > pos.getX()) {
            Case droite = source.getCase(pos.getX() + 1, pos.getY());
            if (!(liste.contains(droite))) {
                liste.add(droite);
            }
        }
        // Si case en bordure verticale gauche:
        if (pos.getX() > 0) {
            Case gauche = source.getCase(pos.getX() - 1, pos.getY());
            if (!liste.contains(gauche)) {
                liste.add(gauche);
            }
        }
        // Si case en bordure horizontale gauche:
        if (pos.getY() > 0) {
            Case haut = source.getCase(pos.getX(), pos.getY() - 1);
            if (!liste.contains(haut)) {
                liste.add(haut);
            }
        }
        // Si case en bordure horizontale droite:
        if ((this.tailleY - 1) > pos.getY()) {
            Case bas = source.getCase(pos.getX(), pos.getY() + 1);
            if (!liste.contains(bas)) {
                liste.add(bas);
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
    public void routinePt() {
        if (!listePt.isEmpty()) {
            for (PointDeControle x : this.listePt) {
                x.analyseCapture();
            }
        }
    }

    @Override
    public Case getCaseDevant(Robot bot) {
        Case c = null;
        switch (bot.getDirection()) {
            case EST:
                c = bot.getTeam().getMap().getCase(bot.getPosition().getX() + 1, bot.getPosition().getY());
                break;
            case OUEST:
                c = bot.getTeam().getMap().getCase(bot.getPosition().getX() - 1, bot.getPosition().getY());
                break;
            case NORD:
                c = bot.getTeam().getMap().getCase(bot.getPosition().getX(), bot.getPosition().getY() - 1);
                break;
            case SUD:
                c = bot.getTeam().getMap().getCase(bot.getPosition().getX(), bot.getPosition().getY() + 1);
                break;
        }
        return c;
    }

    @Override
    public boolean avancer(Robot bot) {
        Case c = getCaseDevant(bot);
        if (c != null) {
            if (bot.getPosition().hasObstacle()) {
                bot.getPosition().suprObstacle();
            }
            if (!c.hasObstacle()) {
                c.setObstacle(bot);
            }
        } else {
            return false;
        }
        return true;
    }

    public Case popAlea(PossedeCaseInterface e, Case c) {
        int l, h;
        do {
            l = (int) (Math.random() * this.getLargeur());
            h = (int) (Math.random() * this.getHauteur());
            c = this.getCase(l, h);
        } while (c.hasItem() || c.hasObstacle() || c.hasZone());
        pop(e, c);
        return c;
    }

    public boolean pop(PossedeCaseInterface e, int x, int y) {
        Case c = getCase(x, y);
        return pop(e, c);
    }

    public boolean pop(PossedeCaseInterface e, Case c) {
        if (e.typeDeCase() == TypeCase.objet) {
            c.setItem((AbstractObjet) e);
        } else if (e.typeDeCase() == TypeCase.obstacle) {
            c.setObstacle((AbstractObstacle) e);
        } else if (e.typeDeCase() == TypeCase.zone) {
            c.setZone((AbstractZone) e);
        } else {
            return false;
        }
        return true;
    }

    public boolean suprimer(PossedeCaseInterface e, Case c) {
        if (e.typeDeCase() == TypeCase.objet) {
            if (c.getItem().equals(e)) {
                c.suprObjet();
            }

        } else if (e.typeDeCase() == TypeCase.obstacle) {
            c.setObstacle((AbstractObstacle) e);
            if (c.getObstacle().equals(e)) {
                c.suprObstacle();
            }
        } else {
            return false;
        }
        return true;
    }
}
