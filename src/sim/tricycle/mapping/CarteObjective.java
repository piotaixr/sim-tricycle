/*
 */
package sim.tricycle.mapping;

import sim.tricycle.mapping.nosCarte.CarteFichier;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class CarteObjective extends AbstractCarte {

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
