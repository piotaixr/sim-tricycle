package sim.tricycle.mapping;

import java.util.HashSet;
import sim.tricycle.robot.Robot;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class CarteTeam extends AbstractCarte {

    protected CarteObjective vraiCarte;

    /**
     * Construit la map d'une team.
     *
     * @param source la carte objective liée
     */
    public CarteTeam(CarteObjective source) {
        this.tailleX = source.tailleX;
        this.tailleY = source.tailleY;
        carte = new Case[source.tailleX][source.tailleY];
        int i, j;

        //parcours du tableau pour initialiser les cases.
        for (i = 0; i < tailleX; i++) {
            for (j = 0; j < tailleY; j++) {
                carte[i][j] = new Case(i, j);
            }
        }
        vraiCarte = source;
        this.afficherCarte();
    }

    /**
     * Redéfinition
     *
     * @param bot
     * @return vrai si deplacement réussi
     */
    @Override
    public boolean avancer(Robot bot) {
        if (!vraiCarte.avancer(bot)) {
            return false;
        } else {
            // On actu notre map.
            this.actualiserCarte(bot.getPortee(), this.getCase(bot.getPosition().getX(), bot.getPosition().getY()));
            return true;
        }
    }

    /**
     * Actualise la carte dans un rayon donné autour d'une case pos.
     *
     * @param rayon de vision.
     * @param pos la postion de la case observateur;
     */
    public void actualiserCarte(int rayon, Case pos) {
        HashSet<Case> liste = new HashSet<Case>();
        // Capture de toute les cases dans le rayon souhaité.
        liste.add(vraiCarte.getCase(pos.getX(), pos.getY()));
        while (rayon > 0) {
            HashSet<Case> newliste = (HashSet<Case>) liste.clone();

            for (Case x : newliste) {
                casesVoisines(vraiCarte, vraiCarte.getCase(x.getX(), x.getY()), liste);
            }
            rayon--;
        }
        // Traitement des cases selectionnées:
        for (Case x : liste) {
            this.getCase(x.getX(), x.getY()).copy(x);
            this.getCase(x.getX(), x.getY()).setTpsNonVu(0);
        }
    }

//    public Case popAlea(PossedeCaseInterface e) {
//        Case c = null;
//        c = super.popAlea(e);
//        this.actualiserCarte(0, c);
//        return null;
//    }

    @Override
    public boolean pop(PossedeCaseInterface e, int x, int y) {
        Case c = vraiCarte.getCase(x, y);
        if (super.pop(e, c)) {
            this.actualiserCarte(1, this.getCase(x, y)); // On actu notre map.
            return true;
        }
        return false;
    }

    @Override
    public boolean pop(PossedeCaseInterface e, Case c) {
        Case cv = vraiCarte.getCase(c.getX(), c.getY());
        if (super.pop(e, cv)) {
            this.actualiserCarte(2, c);
            return true;
        }
        return false;
    }

    /**
     * Suprime un element de la carte.
     *
     * @param e l'element à suprimer.
     * @param c
     * @return
     */
    @Override
    public boolean supprimer(PossedeCaseInterface e, Case c) {
        Case cv = vraiCarte.getCase(c.getX(), c.getY());
        if (vraiCarte.supprimer(e, cv)) {
            this.actualiserCarte(1, c);
            return true;
        }
        return false;
    }

    @Override
    protected void placerPoint(String[][] mat) {
        int i, j;
        for (i = 0; i < tailleX; i++) {
            for (j = 0; j < tailleY; j++) {
                if ("@".equals(mat[i][j])) {
                    this.actualiserCarte(1, getCase(i, j));
                }

            }
        }
    }

    @Override
    public boolean isConnexe(Case c1, Case c2) {
        return vraiCarte.isConnexe(c1, c2);
    }

}