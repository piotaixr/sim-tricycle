/*
 */
package sim.tricycle;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import sim.tricycle.ihm.FrameGame1;
import sim.tricycle.ihm.FrameMenu;
import sim.tricycle.mapping.nosCarte.CarteFichier;
import sim.tricycle.mapping.nosCarte.CarteFromFile;
import sim.tricycle.robot.Automate;
import sim.tricycle.robot.Point;
import sim.tricycle.team.Team;
import sim.tricycle.utils.ObjectBuilder;
import sim.tricycle.xmlparser.RobotParser;

/**
 *
 * @author nell
 */
public class SimTricycle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //MapTest cr = new MapTest();
        // Carte c = cr.getCarte();
        ObjectBuilder ob = new ObjectBuilder();
        RobotParser parser = ob.getRobotParser();
       // Automate a = parser.parse(new File("./test_basique.xml"));

        // CrossRiver cr = new CrossRiver();
        //CarteObjective c = cr.getCarte();
        // sim.tricycle.team.Team t = new sim.tricycle.team.Team("Winneurs", c, new Point(0, 0), new ArrayList<Ressource>());
//        sim.tricycle.robot.Robot bot;
//
//

//
//       // bot = new Collecteur(t, a);
//        bot.setCoordonnees(new Point(3, 8));
//        bot.setDirection(Sens.SUD);
//        bot.collerRobotSurMap();

//MARION
//        InitialisationConstruction initCons = new InitialisationConstruction();
//        Construction Cons = new Construction();
//        bot.getActions().add(initCons);
//        bot.getActions().add(Cons);

        /*
         * CollecterUnePiece cup = new CollecterUnePiece(); c.pop(new
         * Piece(c.getCase(36, 36)), c.getCase(36, 36)); Piece p = (Piece)
         * c.getCase(36, 36).myItem(); cup.setPiece(p);
         * bot.getActions().add(cup);
         *
         */
//        cr.afficherCarte();
//
//        FrameGame1 fg = new FrameGame1(cr);
//        Ordonnanceur ordo = ob.getOrdonnanceur();
//        ordo.add(bot);

//      ordo.add(bot3);
//        fg.addOrdonnaceur(ordo);
//
//        fg.setVisible(true);

//        String[][] mat = new String[][]{
//            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
//            {"V", "X", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
//            {"V", "V", "V", "V", "V", "V", "A1", "A2", "A3", "V", "V", "V", "V", "V", "V"},
//            {"V", "V", "V", "V", "V", "V", "A4", "@", "A6", "V", "V", "V", "V", "V", "V"},
//            {"V", "V", "B", "V", "V", "V", "A7", "A8", "A9", "V", "V", "V", "V", "V", "V"},
//            {"V", "X", "X", "V", "V", "V", "X", "X", "V", "V", "V", "X", "V", "V", "V"},
//            {"V", "V", "V", "V", "V", "V", "X", "V", "V", "V", "V", "X", "V", "V", "V"},
//            {"V", "V", "B", "V", "V", "V", "X", "V", "V", "V", "V", "X", "V", "V", "V"},
//            {"V", "V", "V", "V", "V", "V", "X", "V", "V", "V", "V", "X", "V", "V", "P"},
//            {"V", "V", "V", "V", "V", "V", "X", "V", "V", "V", "V", "V", "V", "V", "V"},
//            {"V", "V", "B", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "P"},
//            {"V", "P", "V", "V", "P", "P", "V", "V", "V", "V", "V", "V", "V", "V", "P"},
//            {"V", "p", "B", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
//            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
//            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},};
//
//        HashMap<Integer, LinkedList<sim.tricycle.robot.Point>> dispositions = new HashMap();
//        sim.tricycle.robot.Point zero = new Point(0, 0);
//        sim.tricycle.robot.Point zero2 = new sim.tricycle.robot.Point(14, 14);
//        LinkedList listzero = new LinkedList<sim.tricycle.robot.Point>();
//        listzero.add(zero);
//        listzero.add(zero2);
//        dispositions.put(2, listzero);
//
//        sim.tricycle.robot.Point un = new sim.tricycle.robot.Point(1, 6);
//        sim.tricycle.robot.Point un2 = new sim.tricycle.robot.Point(10, 2);
//        sim.tricycle.robot.Point un3 = new sim.tricycle.robot.Point(10, 13);
//        LinkedList listun = new LinkedList<sim.tricycle.robot.Point>();
//        listun.add(un);
//        listun.add(un2);
//        listun.add(un3);
//        dispositions.put(3, listun);
//
//        sim.tricycle.robot.Point deux = new sim.tricycle.robot.Point(0, 0);
//        sim.tricycle.robot.Point deux2 = new sim.tricycle.robot.Point(0, 14);
//        sim.tricycle.robot.Point deux3 = new sim.tricycle.robot.Point(14, 0);
//        sim.tricycle.robot.Point deux4 = new sim.tricycle.robot.Point(14, 14);
//        LinkedList listdeux = new LinkedList<sim.tricycle.robot.Point>();
//        listdeux.add(deux);
//        listdeux.add(deux2);
//        listdeux.add(deux3);
//        listdeux.add(deux4);
//        dispositions.put(4, listdeux);
//
////        CarteFichier.createFile("MapTestBase", mat, null, dispositions);
//        
//        CarteFichier cf = new CarteFichier(mat, null, dispositions);
//        CarteFromFile cff = new CarteFromFile(cf,2);
//        
//        ArrayList<Team> tabTeam = new ArrayList();
//        Team t1 = new Team(1, "coucou", cff);
//        Team t2 = new Team(2, "coucou2", cff);
//        tabTeam.add(t1);
//        tabTeam.add(t2);
//        
//        Jeu jeu = new Jeu();
//        jeu.setCarte(cff);
//        jeu.setObjectBuilder(ob);
//        jeu.setTabTeams(tabTeam);
//        jeu.setTeamNumber(2);
//        
//        FrameGame1 fg = new FrameGame1(jeu);
//        fg.setVisible(true);
//        
//        AbstractJeu superGameDeLaMortQuiTue = new Jeu();
//        FrameMenu fm = new FrameMenu(superGameDeLaMortQuiTue);
//        fm.setVisible(true);
    }
}
