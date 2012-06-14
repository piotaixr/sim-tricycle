/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle;

import sim.tricycle.Ordonnanceur.Ordonnanceur;
import sim.tricycle.ihm.FrameGame1;
import sim.tricycle.mapping.Carte;
import sim.tricycle.mapping.TestMap;
import sim.tricycle.mapping.elementCase.Piece;
import sim.tricycle.robot.Collecteur;
import sim.tricycle.robot.Point;
import sim.tricycle.robot.Sens;
import sim.tricycle.robot.action.AllerA;
import sim.tricycle.robot.action.Avancer;
import sim.tricycle.robot.action.CollecterUnePiece;
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
        Carte c = new Carte(20, 20);
        sim.tricycle.team.Team t = new sim.tricycle.team.Team("Winneurs", c, new Point(0, 0));
        sim.tricycle.robot.Robot bot;
       // TestMap tm = new TestMap();
       // tm.startTest();
       // c = tm.getCarte();

        bot = new Collecteur(t, c);
        bot.setCoordonnees(new Point(10, 10));
        bot.setDirection(Sens.NORD);
        bot.collerRobotSurMap();

        CollecterUnePiece cup =new CollecterUnePiece();
        Piece p = (Piece)c.getCase(0, 0).myItem();
        cup.setPiece(p);
        bot.getActions().add(cup);
//        sim.tricycle.robot.Robot bot2;
//        bot2 = new Collecteur(t, c);
//        bot2.setCoordonnees(new Point(11, 10));
//        bot2.setDirection(Sens.NORD);
//        bot2.collerRobotSurMap();
//
//
//        sim.tricycle.robot.Robot bot3;
//        bot3 = new Collecteur(t, c);
//        bot3.setCoordonnees(new Point(11, 10));
//        bot3.setDirection(Sens.NORD);
//        bot3.collerRobotSurMap();

       // Point p = new Point(0, 0);
       // Point p2 = new Point(12, 10);
       // Point p3 = new Point(8, 1);
        //TrouveChemin TrCh = new TrouveChemin(p);
        //LinkedList<Noeud> chemin= new LinkedList<Noeud>();
        //TrCh.executer(bot);
        //TrouveChemin tc = (TrouveChemin)TrCh;
        //chemin = tc.getChemin();

//  for(int i=0;i<chemin.size();i++){
//     System.out.println("Chemin final case N°"+i+" :"+chemin.get(i).getPoint().getX()+" "+chemin.get(i).getPoint().getY());
//  }
//  
       // AllerA go3 = new AllerA(p3);
       // go3.executer(bot3);
       // AllerA go2 = new AllerA(p3);
     //   go2.executer(bot);
   //     AllerA go = new AllerA(p);
     //   go.executer(bot2);

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
//        ordo.add(bot2);
//        ordo.add(bot3);
        fg.addOrdonnaceur(ordo);

        fg.setVisible(true);


       // tm.afficherCarte(c);

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
