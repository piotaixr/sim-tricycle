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
import sim.tricycle.robot.action.AllerA;

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
 Carte c = new Carte(4,4);
 sim.tricycle.team.Team t = new sim.tricycle.team.Team("Winneurs",c,new Point(0,0));
 sim.tricycle.robot.Robot bot ;
 bot = new Collecteur(t,c);
 bot.setCoordonnees(new Point(0,0));
 bot.collerRobotSurMap();
         
 
 Point p= new Point(2,2);
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
  
 
 Ordonnanceur ordo = new Ordonnanceur();
 
 ordo.add(bot);
 FrameGame1 fg = new FrameGame1(c); 
 fg.setVisible(true);
 
// TestMap tm = new TestMap();
//         tm.afficherCarte(c);
    }
}

