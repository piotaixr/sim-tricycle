/*
 */
package sim.tricycle.mapping;

import java.util.List;
import java.util.Map;
import sim.tricycle.mapping.nosCarte.CarteFichier;
import sim.tricycle.team.Team;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class CarteObjective extends AbstractCarte {
    Map<Team,List<PossedeCaseInterface>> elementsCarte;
    
    
    /**
     * Création d'une carte à partir d'une matrice d'entier. @ensure la carte
     * correspond aux informations fournit.
     */
    public CarteObjective(String[][] tab) {
        startInit(tab);
    }
    
    public CarteObjective() {
    }
}
