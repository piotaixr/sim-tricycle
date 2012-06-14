/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle;

import sim.tricycle.Ordonnanceur.Ordonnanceur;
import sim.tricycle.ihm.FrameGame1;
import sim.tricycle.mapping.Carte;
import sim.tricycle.mapping.TestMap;
import sim.tricycle.robot.Collecteur;
import sim.tricycle.robot.Point;
import sim.tricycle.robot.Sens;
import sim.tricycle.robot.action.AllerA;
import sim.tricycle.robot.action.Avancer;
import sim.tricycle.robot.action.Tourner;

/**
 *
 * @author nell
 */
public class SimTricycle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //   System.out.println("Coucou");
        Carte c = new Carte(4, 4);
        sim.tricycle.team.Team t = new sim.tricycle.team.Team("Winneurs", c, new Point(0, 0));
        sim.tricycle.robot.Robot bot;
        TestMap tm = new TestMap();
        tm.startTest();
        c=tm.getCarte();
        bot = new Collecteur(t, c);
        bot.setCoordonnees(new Point(10, 10));
        bot.setDirection(Sens.NORD);
        bot.collerRobotSurMap();


        Point p = new Point(0,0);
        //TrouveChemin TrCh = new TrouveChemin(p);
        //LinkedList<Noeud> chemin= new LinkedList<Noeud>();
        //TrCh.executer(bot);
        //TrouveChemin tc = (TrouveChemin)TrCh;
        //chemin = tc.getChemin();

//  for(int i=0;i<chemin.size();i++){
//     System.out.println("Chemin final case N°"+i+" :"+chemin.get(i).getPoint().getX()+" "+chemin.get(i).getPoint().getY());
//  }
//  
        AllerA go = new AllerA(p);
        go.executer(bot);
//  System.out.println("Lol?"+bot.getActions().size());
//  
//  for(ActionInterface a:bot.getActions()){
//      System.out.println("Action :"+a.getId());
//      
//  }
//bot.getActions().addFirst(new Avancer());
//bot.getActions().addFirst(new Avancer());
//bot.getActions().addFirst(new Tourner(Sens.EST));
//bot.getActions().addFirst(new Avancer());



        FrameGame1 fg = new FrameGame1(c);
        Ordonnanceur ordo = new Ordonnanceur();
        ordo.add(bot);
        fg.addOrdonnaceur(ordo);
         
        fg.setVisible(true);

        
        tm.afficherCarte(c);

//        ordo.start();
//        ordo.stop();
//        ordo.start();
//        int i=0;
//        while(!bot.getActions().isEmpty()){
//           
//        }
//        ordo.nextManual();
//        ordo.nextManual();
//        System.out.println("PosiBot :" + bot.getCoordonnees().getX() + " " + bot.getCoordonnees().getY());
//        System.out.println("SensBot :" + bot.getDirection());
//        ordo.nextManual();
//        ordo.nextManual();
//        System.out.println("PosiBot :" + bot.getCoordonnees().getX() + " " + bot.getCoordonnees().getY());
//        System.out.println("SensBot :" + bot.getDirection());
//        ordo.nextManual();
//        ordo.nextManual();
//        System.out.println("PosiBot :" + bot.getCoordonnees().getX() + " " + bot.getCoordonnees().getY());
//        System.out.println("SensBot :" + bot.getDirection());
//
//        ordo.nextManual();
//        ordo.nextManual();
//        System.out.println("PosiBot :" + bot.getCoordonnees().getX() + " " + bot.getCoordonnees().getY());
//        System.out.println("SensBot :" + bot.getDirection());
//
//        ordo.nextManual();
//        ordo.nextManual();
//        System.out.println("PosiBot :" + bot.getCoordonnees().getX() + " " + bot.getCoordonnees().getY());
//        System.out.println("SensBot :" + bot.getDirection());
//
//        ordo.nextManual();
//        ordo.nextManual();
//        System.out.println("PosiBot :" + bot.getCoordonnees().getX() + " " + bot.getCoordonnees().getY());
//        System.out.println("SensBot :" + bot.getDirection());
//
//        ordo.nextManual();
//        ordo.nextManual();
//        System.out.println("PosiBot :" + bot.getCoordonnees().getX() + " " + bot.getCoordonnees().getY());
//        System.out.println("SensBot :" + bot.getDirection());
//
//        ordo.nextManual();
//        ordo.nextManual();
//        System.out.println("PosiBot :" + bot.getCoordonnees().getX() + " " + bot.getCoordonnees().getY());
//        System.out.println("SensBot :" + bot.getDirection());
//
//        ordo.nextManual();
//        ordo.nextManual();
//        System.out.println("PosiBot :" + bot.getCoordonnees().getX() + " " + bot.getCoordonnees().getY());
//        System.out.println("SensBot :" + bot.getDirection());
//
//        ordo.nextManual();
//        ordo.nextManual();
//        System.out.println("PosiBot :" + bot.getCoordonnees().getX() + " " + bot.getCoordonnees().getY());
//        System.out.println("SensBot :" + bot.getDirection());
//
//        ordo.nextManual();
//        ordo.nextManual();
//        System.out.println("PosiBot :" + bot.getCoordonnees().getX() + " " + bot.getCoordonnees().getY());
//        System.out.println("SensBot :" + bot.getDirection());
//
//        ordo.nextManual();
//        ordo.nextManual();
//        ordo.stop();
//
//
//        tm.afficherCarte(c);
//        System.out.println("PosiBot :" + bot.getCoordonnees().getX() + " " + bot.getCoordonnees().getY());
//        System.out.println("SensBot :" + bot.getDirection());

        // System.out.println("Reste :"+bot.getActions().getFirst().getId());
    }
}
