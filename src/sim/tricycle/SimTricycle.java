/*
 */
package sim.tricycle;

import java.util.ArrayList;
import sim.tricycle.Ordonnanceur.Ordonnanceur;
import sim.tricycle.ihm.FrameGame1;
import sim.tricycle.mapping.Carte;
import sim.tricycle.mapping.elementCase.Mur;
import sim.tricycle.mapping.elementCase.Piece;
import sim.tricycle.mapping.nosCarte.CrossRiver;
import sim.tricycle.mapping.nosCarte.MapTest;
import sim.tricycle.robot.Collecteur;
import sim.tricycle.robot.Point;
import sim.tricycle.robot.Sens;
import sim.tricycle.robot.action.AllerA;
import sim.tricycle.robot.action.Avancer;
import sim.tricycle.robot.action.CollecterUnePiece;
import sim.tricycle.robot.action.Tourner;
import sim.tricycle.team.Ressource;

/**
 *
 * @author nell
 */
public class SimTricycle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

 //       MapTest cr = new MapTest();
   //     Carte c = cr.getCarte();
        CrossRiver cr = new CrossRiver();
        Carte c = cr.getCarte();
        sim.tricycle.team.Team t = new sim.tricycle.team.Team("Winneurs", c, new Point(0, 0), new ArrayList<Ressource>());
        sim.tricycle.robot.Robot bot;


        bot = new Collecteur(t, c);
        bot.setCoordonnees(new Point(3, 8));
        bot.setDirection(Sens.NORD);
        bot.collerRobotSurMap();



        CollecterUnePiece cup = new CollecterUnePiece();
        c.pop(new Piece(c.getCase(36, 36)), c.getCase(36, 36));
        Piece p = (Piece) c.getCase(36, 36).myItem();
           cup.setPiece(p);
            bot.getActions().add(cup);
        cr.afficherCarte();

        FrameGame1 fg = new FrameGame1(cr);
        Ordonnanceur ordo = new Ordonnanceur();
        ordo.add(bot);

//      ordo.add(bot3);
        fg.addOrdonnaceur(ordo);

        fg.setVisible(true);

    }
}
