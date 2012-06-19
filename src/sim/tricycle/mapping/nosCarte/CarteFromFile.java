/*
 */
package sim.tricycle.mapping.nosCarte;

import sim.tricycle.mapping.AbstractCarte;
import sim.tricycle.mapping.CarteObjective;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class CarteFromFile extends CarteObjective {

    public CarteFromFile(String[][] tab) {
        super(tab);
    }

    public CarteFromFile(String nomCarte) {
        CarteFichier cf = CarteFichier.fromFile(nomCarte);
        if (cf.getFond() != null) {
            setImage(cf.getFond());
        }
        startInit(cf.getMat());
    }
}
