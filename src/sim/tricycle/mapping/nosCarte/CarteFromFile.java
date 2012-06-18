/*
 */
package sim.tricycle.mapping.nosCarte;

import sim.tricycle.mapping.AbstractCarte;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class CarteFromFile extends AbstractCarte {

    public CarteFromFile(String nomCarte) {
        CarteFichier cf = CarteFichier.fromFile(nomCarte);
        if (cf.getFond() != null) {
            setImage(cf.getFond());
        }
        startInit(cf.getMat());
    }
}
