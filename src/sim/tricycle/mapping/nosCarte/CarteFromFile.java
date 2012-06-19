/*
 */
package sim.tricycle.mapping.nosCarte;

import java.util.List;
import sim.tricycle.mapping.AbstractCarte;
import sim.tricycle.mapping.CarteObjective;
import sim.tricycle.robot.Point;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class CarteFromFile extends CarteObjective {

    public CarteFromFile(String[][] tab) {
        super(tab);
    }

    public CarteFromFile(String nomCarte, int nbTeams) {
        CarteFichier cf = CarteFichier.fromFile(nomCarte);
        if (cf.getFond() != null) {
            setImage(cf.getFond());
        }
        startInit(cf.getMat());
        setDispositionBases(cf.getDispositionBases(nbTeams));
    }

}
