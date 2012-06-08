/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.Ordonnanceur;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author morgan
 */
public class TestOrdonnanceur {
    
    private Timer timer;
            
    class BotTest implements OrdonnancableInterface{

        private String nom;

        public BotTest (String nomP){
            nom = nomP;
        }

        @Override
        public void executeAction() {
            System.out.println("Salut moi c'est : " + this.nom);         
        }

    }             
    
    class TaskStop extends TimerTask {

        Ordonnanceur ord;
        
        public TaskStop(Ordonnanceur o){
            ord = o;
        }
        
        @Override
        public void run() {
            ord.stop();
            System.out.println(" --> Stop <--");
            start(ord);
        }
        
    }
    
        
    class TaskStart extends TimerTask {

        Ordonnanceur ord;

        public TaskStart(Ordonnanceur o){
            ord = o;
        }

        @Override
        public void run() {
            ord.start();
            System.out.println(" --> Start <--");
        }
        
    }
    
    class TaskSpeedUp extends TimerTask {

        Ordonnanceur ord;

        public TaskSpeedUp(Ordonnanceur o){
            ord = o;
        }

        @Override
        public void run() {
            ord.setTime(ord.getTime()/2);
            System.out.println(" --> SPEED !! <--");
        }
        
    }
    
    /*
     * Stop au bout de 5sec
     */
    public void stop(Ordonnanceur o){
        timer = new Timer();
        System.out.println(" --> Stop dans 5sec <--");
        timer.schedule(new TaskStop(o),5000, 5000);
    }
    
    /*
     * Stop au bout de 5sec
     */
    public void start(Ordonnanceur o){
        timer = new Timer();
        System.out.println(" --> Start dans 2sec <--");
        timer.schedule(new TaskStart(o),2000);
    }
    
    public void doubleSpeed(Ordonnanceur o){
        timer = new Timer();
        System.out.println(" --> Vitesse doublé dans 6 sec <--");
        timer.schedule(new TaskSpeedUp(o),6000);
    }
    
    public void goTest(){
        Ordonnanceur ordo = new Ordonnanceur();
        BotTest bot01 = new BotTest("01 ~o~");
        BotTest bot02 = new BotTest("02 |o~");
        BotTest bot03 = new BotTest("03 ~o|");
        BotTest bot04 = new BotTest("04 |o|");
        BotTest bot05 = new BotTest("05 |o_");
        BotTest bot06 = new BotTest("06 _o|");
        ordo.add(bot01);
        ordo.add(bot02);
        ordo.add(bot03);
        ordo.add(bot04);
        ordo.add(bot05);
        ordo.add(bot06);
        ordo.start();
        System.out.println("C'est parti pour l'ordonnanceur !!");
        //stop(ordo);
        doubleSpeed(ordo);
    }
    
}
