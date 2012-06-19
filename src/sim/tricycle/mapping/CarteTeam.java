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
    }
/**
 * Redéfinition
 * @param bot
 * @return vrai si deplacement réussi
 */
    public boolean avancer(Robot bot) {
        boolean res = vraiCarte.avancer(bot);
        
        if (!res) {
            return false;
        } else {
            Case c = getCaseDevant(bot);
            if (c != null) {
                if (bot.getPosition().hasObstacle()) {
                    bot.getPosition().suprObstacle();
                }
                if (!c.hasObstacle()) {
                    c.setObstacle(bot);
                }
            }
            this.actualiserCarte(vraiCarte, bot.getPortee(), c);
        }
        return true;
    }
    
    /**
     * Redefinition.
     * @param rayon
     * @param pos 
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
        System.out.print("liste crée    ");
        System.out.print(liste.toString());
        // Traitement des cases selectionnées:
        for (Case x : liste) {
            this.getCase(x.getX(), x.getY()).copy(x);
        }
    }
    
}