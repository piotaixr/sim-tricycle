/*
 */
package sim.tricycle.mapping;

import java.awt.Image;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import sim.tricycle.Ordonnanceur.OrdonnanceurInterface;
import sim.tricycle.ihm.ViewCarte;
import sim.tricycle.mapping.elementCase.*;
import sim.tricycle.mapping.mapException.CasesHorsMatriceDemandeException;
import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public abstract class AbstractCarte implements CarteInterface {

    protected static Image imgFond = null;
    protected static Image imgVide = null;
    protected static HashSet<PointDeControle> listePt;  //Ensemble des points de controles.
    protected List<Point> listeBase;
    protected int tailleX, tailleY;
    protected Case[][] carte;
    protected int[][] connexe;
    protected ArrayList<AbstractVision> elements = new ArrayList();

    @Override
    public void afficherCarte() {
        int i, j;
        System.out.println("");
        for (i = 0; i < this.getLargeur(); i++) {
            for (j = 0; j < this.getHauteur(); j++) {
                System.out.print(this.getCase(i, j).toString());
            }
            System.out.print("\n");
        }
    }

    public HashSet<PointDeControle> getListePt() {
        return listePt;
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
        HashSet<Case> liste2 = new HashSet<Case>();
        HashSet<PointDeControle> listeP = new HashSet<PointDeControle>();

        //Recherche des points de controles et traitement.
        for (i = 0; i < tailleX; i++) {
            for (j = 0; j < tailleY; j++) {

                if ("@".equals(mat[i][j])) {
                    carte[i][j] = new Case(i, j);
                    //Si pt de controle il lui faut connaitre ses cases voisines.
                    casesVoisines(this, this.getCase(i, j), liste);
                    //
                    for(Case c:liste){
                        c.setZone(new AbstractZone());
                        liste2.add(c);
                    }
                    liste2.add(carte[i][j]);
                    //System.out.println(liste);
                    PointDeControle pt = new PointDeControle(liste2);
                    pt.setPosition(this.getCase(i, j));
                    this.pop(pt, i, j);
                    listeP.add(pt);// On ajoute ce point à la liste des points.
                }
                carte[i][j].setTpsNonVu(0);
            }
        }
        this.listePt = listeP;
    }

    @Override
    public void startInit(String[][] mat) {
        this.tailleX = mat.length;
        this.tailleY = mat[0].length;
        carte = new Case[this.tailleX][this.tailleY];
        setVide("vide");
        initAllCases(mat);
        placerPoint(mat);
        construireConnexe();
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
    public Set<Case> casesVoisines(AbstractCarte source, Case pos, HashSet<Case> liste) {

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
/**
 * @deprecated 
 */
    @Override
    public void routinePt() {
        if (!listePt.isEmpty()) {
            for (PointDeControle x : this.listePt) {
                //x.analyseCapture();
                System.out.println("DEGAGE");
            }
        }
    }

    @Override
    public Case getCaseDevant(Robot bot) {
        Case c = null;
        try {
            switch (bot.getDirection()) {
                case NORD:
                    c = this.getCase(bot.getPosition().getX() - 1, bot.getPosition().getY());
                    break;
                case SUD:
                    c = this.getCase(bot.getPosition().getX() + 1, bot.getPosition().getY());
                    break;
                case EST:
                    c = this.getCase(bot.getPosition().getX(), bot.getPosition().getY() + 1);
                    break;
                case OUEST:
                    c = this.getCase(bot.getPosition().getX(), bot.getPosition().getY() - 1);
                    break;
            }
        } catch (Exception e) {
        }
        return c;
    }

    @Override
    public boolean avancer(Robot bot) {
        Case c = getCaseDevant(bot);
        System.out.print("Case devant: " + c.toPoint().getStringedCoord());
        System.out.println(" Case robot: " + bot.getPosition().toPoint().getStringedCoord());
        if (c != null) {// si on peut avancer:
            if (!c.hasObstacle()) {
                bot.getPosition().suprObstacle();
                bot.setPosition(c);
                c.setObstacle(bot);
                this.ActualiserBrouillard(c);
            }
        } else {
            return false;
        }
        return true;
    }

    public Case popAlea(PossedeCaseInterface e) {
        int l, h;
        Case c;
        do {
            l = (int) (Math.random() * this.getLargeur());
            h = (int) (Math.random() * this.getHauteur());
            c = this.getCase(l, h);
        } while (c.hasItem() || c.hasObstacle() || c.hasZone());
        pop(e, c);
        return c;
    }

    @Override
    public boolean pop(PossedeCaseInterface e, int x, int y) {
        Case c = getCase(x, y);
        return pop(e, c);
    }

    @Override
    public boolean pop(PossedeCaseInterface e, Case c) {
        if (e.typeDeCase() == TypeCase.objet) {
            c.setItem((AbstractObjet) e);
        } else if (e.typeDeCase() == TypeCase.obstacle) {
            c.setObstacle((AbstractObstacle) e);
            // maj de l'ensemble elements qui contient les unités. 
            if (elements != null && !elements.contains(e)) {
                elements.add((AbstractVision) e);
            }
        } else if (e.typeDeCase() == TypeCase.zone) {
            c.setZone((AbstractZone) e);
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(PossedeCaseInterface e, Case c) {
        if (e.typeDeCase() == TypeCase.objet) {
            if (c.getItem().equals(e)) {
                c.suprObjet();
            }

        } else if (e.typeDeCase() == TypeCase.obstacle) {
            c.setObstacle((AbstractObstacle) e);
            if (c.getObstacle().equals(e)) {
                c.suprObstacle();
                // maj de l'ensemble elements qui contient les unités.
                if (elements != null && elements.contains(e)) {
                    elements.remove(e);
                }
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * Actualise le broullard des teams sur une case.
     *
     * @param c la case depuis laquelle actualisé.
     */
    public void ActualiserBrouillard(Case c) {

        for (AbstractVision x : elements) {
            if (x.voit(c)) {
                x.getTeam().getMap().actualiserCarte(x.getPortee(), x.getPosition());
            }
        }
    }

    public List<Point> getListeBase() {
        return listeBase;
    }

    public void setListeBase(List<Point> listeBase) {
        this.listeBase = listeBase;
    }

    private void construireConnexe() {
        Map<Integer, Set<Case>> indexnum = initConnexe();
//pour chaque case
        for (int x = 0; x < getLargeur(); x++) {
            for (int y = 0; y < getHauteur(); y++) {
                Case courante = getCase(x, y);
                if(courante.hasObstacle())
                    continue;
                Set<Case> ensCaseNumCourante = indexnum.get(getGroup(courante));
                //on prend les voisines
                Set<Case> voisinesCourante = casesVoisines(this, courante, new HashSet<Case>());

                for (Case c : voisinesCourante) {
                    if(c.hasObstacle()){
                        continue;
                    }
                    //pour chaque voisine
                    if (!isConnexe(c, courante)) {
                        //si groupe différent
                        //on prend toutes les cases de ce groupe et on supprime ce groupe
                        Set<Case> casesNumChange = indexnum.remove(getGroup(c));
                        for (Case change : casesNumChange) {
                            // pour chacune de ces cases, on les change de groupe
                            setGroup(change, getGroup(courante));
                            ensCaseNumCourante.add(change);
                        }
                    }

                }
            }
        }
    }

    @Override
    public boolean isConnexe(Case c1, Case c2) {
        return connexe[c1.getX()][c1.getY()] == connexe[c2.getX()][c2.getY()];
    }

    private int getGroup(Case c) {
        return connexe[c.getX()][c.getY()];
    }

    private void setGroup(Case c, int numgroup) {
        connexe[c.getX()][c.getY()] = numgroup;
    }

    private Map<Integer, Set<Case>> initConnexe() {
        Map<Integer, Set<Case>> indexnum = new HashMap();
        connexe = new int[getLargeur()][getHauteur()];
        int i = 0;
        for (int x = 0; x < getLargeur(); x++) {
            for (int y = 0; y < getHauteur(); y++) {
                connexe[x][y] = i;
                Set<Case> set = new HashSet();
                set.add(getCase(x, y));
                indexnum.put(i, set);
                i++;
            }
        }

        return indexnum;
    }
}
