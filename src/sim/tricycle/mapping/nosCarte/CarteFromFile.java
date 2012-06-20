/*
 */
package sim.tricycle.mapping.nosCarte;

import sim.tricycle.mapping.CarteObjective;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class CarteFromFile extends CarteObjective {

    public CarteFromFile(String[][] tab) {
        super(tab);
    }

    public CarteFromFile(CarteFichier cf, int nbTeams) {
        if (cf.getFond() != null) {
            setImage(cf.getFond());
        }
        startInit(cf.getMat());
        setDispositionBases(cf.getDispositionBases(nbTeams));
    }

    public CarteFromFile(String nomCarte, int nbTeams) {
        this(CarteFichier.fromFile(nomCarte), nbTeams);

    }
}
