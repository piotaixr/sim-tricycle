package sim.tricycle;

import java.util.HashMap;
import java.util.LinkedList;
import sim.tricycle.mapping.nosCarte.CarteFichier;
import sim.tricycle.robot.Point;
import sim.tricycle.utils.ObjectBuilder;
import sim.tricycle.xmlparser.RobotParser;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class GenerateurFichier {

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

        String[][] mat = new String[][]{
            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V",   "V",  "V", "V", "V", "V", "V", "V", "V", "X", "X", "X",        "V", "V", "V", "V", "V", "V", "V", "V", "V",    "V", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "X", "X", "X", "X", "X", "X",   "X",  "X", "X", "X", "X", "V", "V", "V", "X", "X", "X",        "V", "V", "V", "X", "X", "X", "X", "X", "X",    "X", "X", "X", "X", "X", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "X", "X", "X", "X", "X", "X", "X",   "X",  "X", "X", "X", "X", "V", "V", "V", "X", "X", "X",        "V", "V", "V", "X", "X", "X", "X", "X", "X",    "X", "X", "X", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "X", "X", "X", "X", "X", "X", "X",   "X",  "X", "X", "X", "X", "V", "V", "V", "X", "X", "X",        "V", "V", "V", "X", "X", "X", "X", "X", "X",    "X", "X", "X", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "A1", "A2", "A3", "X", "X", "X", "V", "V", "V", "X", "X", "X",        "V", "V", "V", "X", "X", "X", "A1", "A2", "A3", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "X", "X", "X", "X", "X", "A4", "@",  "A6", "X", "X", "X", "V", "V", "V", "X", "X", "X",        "V", "V", "V", "X", "X", "X", "A4", "@", "A6",  "V", "X", "X", "X", "X", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "X", "X", "X", "X", "X", "A7", "A8", "A9", "X", "X", "X", "V", "V", "V", "AP4", "APN2", "AP8", "V", "V", "V", "V", "X", "X", "A7", "A8", "A9", "V", "X", "X", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "X", "X", "X", "X", "X", "V",    "X", "X", "X", "X", "X", "V", "V", "V", "AP5", "APN1", "AP9", "V", "V", "V", "X", "X", "X", "V", "V", "V",    "V", "X", "X", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "X", "X", "X", "X", "V", "V", "V",    "X", "X", "X", "X", "X", "V", "V", "V", "X", "X",        "X", "V", "V", "V", "X", "X", "X", "X", "X", "X",    "V", "V", "V", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "X", "X", "X", "X", "V", "V", "V",    "X", "X", "X", "X", "X", "V", "V", "V", "X", "X", "X",        "V", "V", "V", "X", "X", "X", "X", "X", "X",    "V", "V", "V", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "X", "X", "X", "V", "V", "V",    "X", "X", "X", "X", "X", "X", "V", "V", "X", "X", "X",        "V", "V", "V", "X", "X", "X", "X", "X", "X",    "V", "V", "V", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "X", "X", "X", "X", "V", "V",    "V", "V", "X", "X", "X", "X", "V", "V", "X", "X", "X",        "V", "V", "V", "X", "X", "X", "V", "V", "V",    "V", "V", "X", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "X", "X", "X", "X", "X", "X",    "X", "V", "X", "X", "X", "X", "V", "V", "X", "X", "X",        "V", "V", "V", "X", "X", "X", "V", "X", "X",    "X", "X", "X", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "X", "X", "X", "X", "X", "X", "X",    "X", "V", "X", "X", "X", "X", "V", "V", "X", "X", "X",        "V", "V", "X", "X", "X", "X", "V", "X", "X",    "X", "X", "X", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "X", "X", "X", "X", "X", "X", "X",    "X", "V", "X", "X", "X", "X", "V", "V", "X", "X", "X",        "V", "V", "X", "X", "X", "X", "V", "X", "X",    "X", "X", "X", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "CPE5", "V", "V", "CPE6", "V", "V", "V", "V", "V", "X", "X", "X", "X", "CR6", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "CPE9", "CPE10", "X", "X", "X", "X", "X", "X", "X", "X", "X", "CR4", "CR5", "CR7", "V", "V", "V", "V", "V", "X", "CPO1", "CPO2", "X", "X", "V", "V", "V", "V", "V", "X"},
            {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "CPE8", "CPE11", "X", "X", "X", "X", "X", "X", "X", "X", "CRA2", "CRA3", "X", "X", "X", "X", "X", "X", "X", "X", "CPO3", "CPO4", "X", "X", "X", "X", "X", "X", "X", "X"},
            {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "CPE7", "CPE12", "X", "X", "X", "X", "X", "X", "X", "CRA4", "@", "CRA6", "X", "X", "X", "X", "X", "X", "X", "X", "CPO5", "CPO6", "X", "X", "X", "X", "X", "X", "X", "X"},
            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "CPE1", "CPE2", "CPE3", "CPE4", "V", "V", "V", "V", "X", "X", "CRA7", "CRA8", "X", "X", "X", "X", "X", "X", "X", "X", "X", "CPO7", "CPO8", "X", "X", "X", "X", "X", "X", "X", "X"},
            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "CR1", "CR3", "X", "X", "X", "X", "X",   "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "CR2", "X", "X", "X", "X",     "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "V", "V", "V", "X", "X",       "X", "V", "V", "V", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "V", "V", "X", "X",       "X", "V", "V", "V", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "V", "V", "X", "X",       "X", "V", "V", "V", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "X", "X", "X","A1","A2","A3", "V", "V", "V", "V", "V", "V", "V", "V", "X", "X",       "X", "V", "V", "V", "V", "V", "V", "V", "V", "V","A1","A2","A3", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "X", "X", "X","A4", "@","A6", "V", "V", "V", "V", "V", "V", "V", "V", "X", "X",       "X", "V", "V", "V", "V", "V", "V", "V", "V", "V","A4", "@","A6", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "X", "X", "X","A7","A8","A9", "X", "X", "X", "X", "X", "X", "V", "V", "X", "X",       "X", "V", "V", "V", "X", "X", "X", "X", "X", "V","A7","A8","A9", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "X", "X", "X", "V", "V", "V", "X", "X", "X", "X", "X", "X", "V", "V", "X", "X",       "X", "V", "V", "V", "X", "X", "X", "X", "X", "V", "V", "V", "V", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "X", "X", "X", "X", "V", "V", "X", "X", "X", "X", "X", "X", "V", "V", "AP4", "AP6", "AP8", "V", "V", "V", "X", "X", "X", "X", "X", "V", "V", "X", "X", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "X", "X", "X", "X", "X", "V", "V", "V", "X", "X", "X", "X", "V", "V", "AP5", "AP7", "AP9", "V", "V", "V", "X", "X", "X", "V", "V", "V", "X", "X", "X", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "X", "X", "X", "X", "X", "X", "V", "V", "V", "X", "X", "X", "X", "V", "V", "X", "X",       "X", "V", "V", "V", "X", "X", "X", "V", "V", "V", "X", "X", "X", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "X", "X", "X", "X", "X", "V", "V", "V", "V", "X", "X", "X", "X", "V", "V", "X", "X",       "X", "V", "V", "V", "X", "X", "X", "X", "V", "V", "V", "X", "X", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "X", "X", "X", "V", "V", "V", "V", "V", "X", "X", "X", "X", "X", "V", "V", "X", "X",       "X", "V", "V", "V", "X", "X", "X", "X", "V", "V", "V", "V", "V", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "X", "X", "X", "V", "V", "V", "X", "X", "X", "X", "X", "X", "X", "V", "V", "X", "X",       "X", "V", "V", "V", "X", "X", "X", "X", "X", "X", "X", "V", "V", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "X", "X", "X", "V", "V", "X", "X", "X", "X", "X", "X", "X", "X", "V", "V", "X", "X",       "X", "V", "V", "V", "X", "X", "X", "X", "X", "X", "X", "V", "V", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "X", "X", "V", "V", "X", "X", "X", "X", "X", "X", "X", "X", "V", "V", "X", "X",       "X", "V", "V", "V", "X", "X", "X", "X", "X", "X", "X", "V", "V", "X", "X", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "X", "X",       "X", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "X", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "X",       "X", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "X",       "X", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},};


        HashMap<Integer, LinkedList<sim.tricycle.robot.Point>> dispositions = new HashMap();
        sim.tricycle.robot.Point zero = new Point(0, 0);
        sim.tricycle.robot.Point zero2 = new sim.tricycle.robot.Point(39, 39);
        LinkedList listzero = new LinkedList<sim.tricycle.robot.Point>();
        listzero.add(zero);
        listzero.add(zero2);
        dispositions.put(2, listzero);

        sim.tricycle.robot.Point un = new sim.tricycle.robot.Point(0, 0);
        sim.tricycle.robot.Point un2 = new sim.tricycle.robot.Point(0, 39);
        sim.tricycle.robot.Point un3 = new sim.tricycle.robot.Point(39, 39);
        LinkedList listun = new LinkedList<sim.tricycle.robot.Point>();
        listun.add(un);
        listun.add(un2);
        listun.add(un3);
        dispositions.put(3, listun);

        sim.tricycle.robot.Point deux = new sim.tricycle.robot.Point(0, 0);
        sim.tricycle.robot.Point deux2 = new sim.tricycle.robot.Point(0, 39);
        sim.tricycle.robot.Point deux3 = new sim.tricycle.robot.Point(39, 39);
        sim.tricycle.robot.Point deux4 = new sim.tricycle.robot.Point(39, 0);
        LinkedList listdeux = new LinkedList<sim.tricycle.robot.Point>();
        listdeux.add(deux);
        listdeux.add(deux2);
        listdeux.add(deux3);
        listdeux.add(deux4);
        dispositions.put(4, listdeux);

        CarteFichier.createFile("CrossRiver", mat, "crossriver.png", dispositions);

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
