package sim.tricycle.mapping;

import java.util.HashSet;
import sim.tricycle.mapping.elementCase.AbstractObjet;
import sim.tricycle.mapping.elementCase.AbstractObstacle;
import sim.tricycle.mapping.elementCase.PointDeControle;
import sim.tricycle.mapping.mapException.CasesHorsMatriceDemandeException;
import sim.tricycle.robot.Robot;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class CarteTeam extends AbstractCarte implements CarteInterface {

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

   
}