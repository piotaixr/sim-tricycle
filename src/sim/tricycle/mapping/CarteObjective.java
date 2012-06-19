/*
 */
package sim.tricycle.mapping;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import sim.tricycle.mapping.elementCase.AbstractVision;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class CarteObjective extends AbstractCarte {
        protected ArrayList<AbstractVision> elements=null;
    
    /**
     * Création d'une carte à partir d'une matrice d'entier. @ensure la carte
     * correspond aux informations fournit.
     */
    public CarteObjective(String[][] tab) {
        startInit(tab);
    }
    
    public CarteObjective() {
    }
    /** Actualise le broullard des teams sur une case.
     * 
     * @param c la case depuis laquelle actualisé.
     */
    public void ActualiserBroullard(Case c){
        
        for (AbstractVision x: elements){
            if (x.voit(c)){
                x.getT().getMap().actualiserCarte(x.getPortee(), c);
            }
        }
    }
    
      protected void setDispositionBases(List<Point> dispositionBases) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    
}
