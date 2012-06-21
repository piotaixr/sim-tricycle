/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import sim.tricycle.ihm.FrameGame1;
import sim.tricycle.mapping.nosCarte.CarteFichier;
import sim.tricycle.mapping.nosCarte.CarteFromFile;
import sim.tricycle.robot.Automate;
import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.team.Team;
import sim.tricycle.utils.ObjectBuilder;
import sim.tricycle.xmlparser.RobotParser;

/**
 *
 * @author Adri
 */
public class TestActions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //MapTest cr = new MapTest();
        // Carte c = cr.getCarte();
        ObjectBuilder builder = new ObjectBuilder();
        RobotParser parser = builder.getRobotParser();


        String[][] mat = new String[][]{
            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "X", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "A1", "A2", "A3", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "A4", "@", "A6", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "B", "V", "V", "V", "A7", "A8", "A9", "V", "V", "V", "V", "V", "V"},
            {"V", "X", "X", "V", "V", "V", "X", "X", "V", "V", "V", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "X", "V", "V", "V", "V", "X", "V", "V", "V"},
            {"V", "V", "B", "V", "V", "V", "X", "V", "V", "V", "V", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "X", "V", "V", "V", "V", "X", "V", "V", "P"},
            {"V", "V", "V", "V", "V", "V", "X", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "B", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "P"},
            {"V", "P", "V", "V", "P", "P", "V", "V", "V", "V", "V", "V", "V", "V", "P"},
            {"V", "p", "B", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},};

        HashMap<Integer, LinkedList<sim.tricycle.robot.Point>> dispositions = new HashMap();
        sim.tricycle.robot.Point zero = new Point(0, 0);
        sim.tricycle.robot.Point zero2 = new sim.tricycle.robot.Point(15, 15);
        LinkedList listzero = new LinkedList<sim.tricycle.robot.Point>();
        listzero.add(zero);
        listzero.add(zero2);
        dispositions.put(2, listzero);

        sim.tricycle.robot.Point un = new sim.tricycle.robot.Point(1, 6);
        sim.tricycle.robot.Point un2 = new sim.tricycle.robot.Point(10, 2);
        sim.tricycle.robot.Point un3 = new sim.tricycle.robot.Point(10, 13);
        LinkedList listun = new LinkedList<sim.tricycle.robot.Point>();
        listun.add(un);
        listun.add(un2);
        listun.add(un3);
        dispositions.put(3, listun);

        sim.tricycle.robot.Point deux = new sim.tricycle.robot.Point(0, 0);
        sim.tricycle.robot.Point deux2 = new sim.tricycle.robot.Point(0, 15);
        sim.tricycle.robot.Point deux3 = new sim.tricycle.robot.Point(15, 0);
        sim.tricycle.robot.Point deux4 = new sim.tricycle.robot.Point(15, 15);
        LinkedList listdeux = new LinkedList<sim.tricycle.robot.Point>();
        listdeux.add(deux);
        listdeux.add(deux2);
        listdeux.add(deux3);
        listdeux.add(deux4);
        dispositions.put(4, listdeux);

        //CarteFichier.createFile("MapTestBase", mat, null, dispositions);
        
        CarteFichier cf = new CarteFichier(mat, null, dispositions);
        CarteFromFile cff = new CarteFromFile(cf,2);
        
        ArrayList<Team> tabTeam = new ArrayList();
        Team t1 = new Team(1, "coucou", cff);
        Team t2 = new Team(2, "coucou2", cff);
        tabTeam.add(t1);
        tabTeam.add(t2);
        
        Jeu jeu = new Jeu();
        jeu.setCarte(cff);
        jeu.setObjectBuilder(builder);
        jeu.setTabTeams(tabTeam);
        jeu.setTeamNumber(2);
        
        FrameGame1 fg = new FrameGame1(jeu);
        fg.setVisible(true);
        
        Automate automate = builder.getRobotParser().parse(new File("./cercle.xml"));
        
        Robot robot = new Robot(automate);
        robot.setTeam(t1);
        cff.pop(robot, 4, 4);
        System.out.println(automate.getEtat("init"));
        fg.addOrdonnaceur(builder.getOrdonnanceur());
        builder.getOrdonnanceur().add(robot);
//        builder.getOrdonnanceur().start();
    }
}
