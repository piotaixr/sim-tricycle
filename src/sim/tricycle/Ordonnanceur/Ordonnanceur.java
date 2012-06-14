/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.Ordonnanceur;

import java.util.*;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 * @author Morgan BIDOIS <morganbidois@gmail.com>
 */
public class Ordonnanceur extends Observable implements OrdonnanceurInterface {

    /*
     * Tableau représentant les éléments qu'il reste à traiter
     */
    private ArrayList<OrdonnancableInterface> subscribersActionToDo;
    /*
     * Tableau représentant les éléments déjà traités
     */
    private ArrayList<OrdonnancableInterface> subscribersActionDone;
    private Timer timer;
    private long period;
    private long defaultperiod = 100;
    private boolean running = false; // Par défaut l'ordonnaceur est sur "pause"
    private Random randomGenerator = new Random();
    private long time = 0;

    /*
     * Constructeur avec timer par défaut
     */
    public Ordonnanceur() {
        this(100);
    }

    /*
     * Constructeur avec timer en paramètre
     */
    public Ordonnanceur(long period) {
        this.period = period;
        subscribersActionToDo = new ArrayList();
        subscribersActionDone = new ArrayList();
        timer = new Timer();
        timer.schedule(new TaskAction(), 0, period);

    }

    /*
     * Exécute l'action de l'élément en paramètre
     */
    private void doAction(OrdonnancableInterface oi) {
        oi.executeAction();
    }

    /*
     * Ajoute en fin de la liste des objets ayant des actions Utilisée pour
     * transférer un élément de la liste à faire à celle de ceux faits
     */
    private void addToActionDone(OrdonnancableInterface oi) {
        subscribersActionDone.add(oi);
    }

    /*
     * Enlève en tête de la liste des objets ayant des actions et le met dans la
     * liste des actions effectuées
     */
    private void actionAndRemoveFromToDo() {
        OrdonnancableInterface elem;
        synchronized (this) {
            elem = subscribersActionToDo.remove(0);
            addToActionDone(elem);
        }
        doAction(elem);
    }

    /**
     * Remplissage des actions à faire de manière aléatoire A faire une fois
     * qu'il n'y a plus d'action à faire
     */
    private void intializeActionToDo() {
        int randomInt;
        while (!subscribersActionDone.isEmpty()) {
            /*
             * Génération aléatoire d'un nombre
             */
            randomInt = randomGenerator.nextInt(1000);
            /*
             * On enlève un élément de la liste des actions faites, dont l'index
             * est le modulo du nombre aléatoire par le nombre d'éléments
             * restants dans la liste que l'on met dans la liste des actions à
             * faire
             */
            add(subscribersActionDone.remove(randomInt % (subscribersActionDone.size())));
            /*
             * Tant que la liste des actions faites n'est pas vide
             */
        }
        System.out.println("------- Remplissage des actions à faire -------");
    }

    class TaskAction extends TimerTask {

        @Override
        public void run() {
            if (running) {
                next();
            }

        }
    }

    /*
     * Fonction pour faire les actions les unes après les autres manuellement.
     */
    @Override
    public synchronized void next() {
        //new TaskAction().run();
        if (!subscribersActionToDo.isEmpty()) {
            actionAndRemoveFromToDo();
            time++;
        } else {
            intializeActionToDo();
        }
        setChanged();
        notifyObservers();
    }

    @Override
    /*
     * Enlève définitivement l'objet entré en paramètre
     */
    public void remove(OrdonnancableInterface oi) {
        /*
         * Si l'element à enlever est dans la liste des éléments restants à
         * traiter on l'enlève (ex: un bot tue une autre bot, il ne faut pas que
         * celui ci puisse faire une action une fois mort)
         */
        synchronized (this) {
            if (subscribersActionToDo.contains(oi)) {
                subscribersActionToDo.remove(oi);
            } else {// Sinon on l'enlève des éléments déjà traités
                subscribersActionDone.remove(oi);
            }
        }
    }

    /*
     * Ajoute l'objet en paramètre à la fin de la liste des actions à faire Ex :
     * Création nouveau bot
     */
    @Override
    public synchronized void add(OrdonnancableInterface oi) {
        subscribersActionToDo.add(oi);
    }

    @Override
    public void start() {
        running = true;
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public void setPeriod(long period) {
        this.period = period;
        timer.cancel();
        timer = new Timer();
        timer.schedule(new TaskAction(), 0, period);
    }

    @Override
    public long getPeriod() {
        return period;
    }

    @Override
    public long getDefaultPeriod() {
        return defaultperiod;
    }

    @Override
    public long getTime() {
        return time;
    }
}
