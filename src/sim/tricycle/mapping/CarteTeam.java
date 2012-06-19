package sim.tricycle.mapping;

import sim.tricycle.robot.Robot;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class CarteTeam extends AbstractCarte {

    /** Construit la map d'une team.
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
    }
    
    public void avancer(Robot bot) {
        Case c = getCaseDevant(bot);
        if (c != null) {
            if (bot.getPosition().hasObstacle()) {
                bot.getPosition().suprObstacle();
            }
            if (!c.hasObstacle()) {
                c.setObstacle(bot);
            }

        }
    }
   
}