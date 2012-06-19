/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.Ordonnanceur;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import sim.tricycle.ihm.FrameGame1;

/**
 *
 * @author Morgan BIDOIS <morganbidois@gmail.com>
 */
public class TestOrdonnanceur {

    private Timer timer;
    private ArrayList<OrdonnancableInterface> bots = new ArrayList();

    class BotTest implements OrdonnancableInterface {

        private String nom;

        public BotTest(String nomP) {
            nom = nomP;
        }

        @Override
        public void tick() {
            System.out.println("Salut moi c'est : " + this.nom);
        }
    }

    class TaskStop extends TimerTask {

        Ordonnanceur ord;

        public TaskStop(Ordonnanceur o) {
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

        public TaskStart(Ordonnanceur o) {
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

        public TaskSpeedUp(Ordonnanceur o) {
            ord = o;
        }

        @Override
        public void run() {
            ord.setPeriod(ord.getPeriod() / 2);
            System.out.println(" --> SPEED !! <--");
        }
    }

    class TaskRemove extends TimerTask {

        OrdonnanceurInterface ord;
        OrdonnancableInterface bot;

        public TaskRemove(OrdonnancableInterface bot, OrdonnanceurInterface o) {
            ord = o;
            this.bot = bot;
        }

        @Override
        public void run() {
            System.out.println(" --> Remove <--");
            bots.remove(bot);
            ord.remove(bot);
        }
    }

    class TaskAdd extends TimerTask {

        OrdonnanceurInterface ord;
        OrdonnancableInterface bot;

        public TaskAdd(OrdonnancableInterface bot, OrdonnanceurInterface o) {
            this.ord = o;
            this.bot = bot;
        }

        @Override
        public void run() {
            System.out.println(" --> Add <--");
            bots.add(bot);
            ord.add(bot);
        }
    }

    /*
     * Stop au bout de 5sec et répétition toutes les 5sec
     */
    public void stop(Ordonnanceur o) {
        timer = new Timer();
        System.out.println(" ~~> Stop dans 5sec <~~");
        timer.schedule(new TaskStop(o), 5000, 5000);
    }

    /*
     * Stop au bout de 2sec
     */
    public void start(Ordonnanceur o) {
        timer = new Timer();
        System.out.println(" ~~> Start dans 2sec <~~");
        timer.schedule(new TaskStart(o), 2000);
    }

    public void doubleSpeed(Ordonnanceur o) {
        timer = new Timer();
        System.out.println(" ~~> Vitesse doublé dans 6 sec <~~");
        timer.schedule(new TaskSpeedUp(o), 6000);
    }

    /* 
     * Ajoute un bot dans le tableau test et ordonnanceur 'manuellement'
     */
    public void add(OrdonnancableInterface bot, OrdonnanceurInterface ordo) {
            bots.add(bot);
            ordo.add(bot);
    }
    
    public void addBot(OrdonnancableInterface bot, OrdonnanceurInterface ordo) {
        timer = new Timer();
        System.out.println(" ~~> Ajout dans 16 sec <~~");
        timer.schedule(new TaskAdd(bot, ordo), 16000);
    }

    public void removeBot(OrdonnancableInterface bot, OrdonnanceurInterface ordo) {
        timer = new Timer();
        System.out.println(" ~~> Suppression dans 7 sec <~~");
        timer.schedule(new TaskRemove(bot, ordo), 7000);
    }

    public void goTest() {

        Ordonnanceur ordo = new Ordonnanceur();
        BotTest bot01 = new BotTest("01 ~o~");
        BotTest bot02 = new BotTest("02 |o~");
        BotTest bot03 = new BotTest("03 ~o|");
        BotTest bot04 = new BotTest("04 |o|");
        BotTest bot05 = new BotTest("05 |o_");
        BotTest bot06 = new BotTest("06 _o|");
        add(bot01, ordo);
        add(bot02, ordo);
        add(bot03, ordo);
        add(bot04, ordo);

        ordo.start();
        System.out.println("C'est parti pour l'ordonnanceur !!");
        
        //stop(ordo);               // Pour le test de l'arret/reprise
        //doubleSpeed(ordo);        // Pour le test de la modification de vitesse de l'ordonnancement

        addBot(bot06,ordo);         // Test ajout 
        
        while (!bots.isEmpty()) {   // Test Suppression
            removeBot(bots.remove(0), ordo);
            try {
                Thread.sleep(8000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TestOrdonnanceur.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
        
        addBot(bot05,ordo);         // Test ajout une fois la liste vide


    }
}
