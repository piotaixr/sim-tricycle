/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.action.Action;
import java.util.ArrayList;
import sim.tricycle.robot.Noeud;
import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;

/**
 *
 * @author Adri
 */
public class TrouveChemin extends Action {

    Point pDest;
    ArrayList<Noeud> chemin;

    public TrouveChemin(Point pDest) {
        this.pDest = pDest;
        this.chemin = new ArrayList<Noeud>();
    }

    public void executer(Robot bot) {
    }

    private void insereEnOrdre(Noeud n, ArrayList<Noeud> listeNoeuds) {
        //  listeNoeuds
    }

    private void plusCourtChemin(Point pDep) {

        ArrayList<Noeud> listeOuverte;
        ArrayList<Noeud> listeFermee;




    }
}
