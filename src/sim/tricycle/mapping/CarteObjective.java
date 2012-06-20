/*
 */
package sim.tricycle.mapping;

import java.util.List;
import sim.tricycle.robot.Point;

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

    protected void setDispositionBases(List<Point> dispositionBases) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
