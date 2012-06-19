/*
 */
package sim.tricycle.mapping;

import sim.tricycle.mapping.nosCarte.CarteFichier;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class CarteObjective extends AbstractCarte {

    
        public CarteObjective(String nomCarte) {
        CarteFichier cf = CarteFichier.fromFile(nomCarte);
        if (cf.getFond() != null) {
            setImage(cf.getFond());
        }
        startInit(cf.getMat());
    }
        
    /**
     * Création d'une carte à partir d'une matrice d'entier. @ensure la carte
     * correspond aux informations fournit.
     */
    public CarteObjective(String[][] tab) {
        startInit(tab);
    }
}
