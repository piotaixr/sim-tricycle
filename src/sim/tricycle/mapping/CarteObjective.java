/*
 */
package sim.tricycle.mapping;


import java.util.ArrayList;
import java.util.List;
import sim.tricycle.mapping.elementCase.AbstractObjet;
import sim.tricycle.mapping.elementCase.AbstractObstacle;
import sim.tricycle.mapping.elementCase.AbstractVision;
import sim.tricycle.robot.Point;

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
                x.getTeam().getMap().actualiserCarte(x.getPortee(), c);
            }
        }
    }
    
      protected void setDispositionBases(List<Point> dispositionBases) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean pop(PossedeCaseInterface e, int x, int y) {
        Case c = getCase(x, y);
        if (c.hasItem() || c.hasObstacle()) {
            if (e.obstacleItem() == 1) {
                c.setItem((AbstractObjet) e);
            }
            if (e.obstacleItem() == 2) {
                c.setObstacle((AbstractObstacle) e);
            }
        } else {
            throw new RuntimeException("Il y a déjà quelque chose sur la case");
        }
    }

    public boolean pop(PossedeCaseInterface e, Case c) {
        if (e.obstacleItem() == 1) {
            c.setItem((AbstractObjet) e);
        }
        if (e.obstacleItem() == 2) {
            c.setObstacle((AbstractObstacle) e);
        }
    }

    //rempli ensemble de bases
    protected void setDispositionBases(List<Point> dispositionBases) {
        super.setListeBase(dispositionBases);
    }
}
