/*
 */
package sim.tricycle.robot;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sim.tricycle.Ordonnanceur.OrdonnancableInterface;
import sim.tricycle.robot.action.Action;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public abstract class Robot implements OrdonnancableInterface {

    protected Point position;
    protected Sens direction;
    protected int portee;
    protected ArrayDeque<Action> actions = new ArrayDeque();
    /**
     * @deprecated
     */
    protected ArrayList<EventType> ordreTest = new ArrayList();
    protected Etat etatCourant;
    protected Etat etatDestination;
    protected Automate automate;

    /**
     * @todo Initialiser le robot avec l'etat initial de l'automate
     *
     * @param automate
     */
    public Robot(Automate automate) {
        this.automate = automate;

    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point newP) {
        this.position = newP;
    }

    public Sens getDirection() {
        return this.direction;
    }

    public void setDirection(Sens newDirection) {
        this.direction = newDirection;
    }

    public int getPortee() {
        return this.portee;
    }

    public void setPortee(int newPortee) {
        this.portee = newPortee;
    }

    public ArrayDeque<Action> getActions() {
        return actions;
    }

    public void setActions(ArrayDeque<Action> fileActions) {
        this.actions = fileActions;
    }

    public Etat getEtat() {
        return this.etatCourant;
    }

    public void setEtat(Etat newEtat) {
        this.etatCourant = newEtat;
    }

    /**
     * @deprecated
     */
    public ArrayList<EventType> getOrdreTest() {
        return ordreTest;
    }

    /**
     * @deprecated
     */
    public void setOrdreTest(ArrayList<EventType> ordreTest) {
        this.ordreTest = ordreTest;
    }

    /**
     * @deprecated
     */
    public Evenement scan() {

        int i = 0;
        boolean eventFound = false;
        Evenement evt = new Evenement();

        while (i < this.ordreTest.size() && !eventFound) {

            switch (this.ordreTest.get(i)) {
                case BALLE:

                    break;

                case ENNEMI:
                    break;
            }
        }
        return evt;
    }

    /**
     * @deprecated
     */
    public void depilerActionCourante() {
        Action a = actions.pollFirst();
        if (a != null) {
            a.executer(this);
        }
    }

    /**
     * @deprecated
     */
    public void changerEtat(Evenement evt) {
    }

    /**
     * @deprecated
     */
    public void agir() {
        changerEtat(scan());
        depilerActionCourante();
    }

    @Override
    /**
     * Fonction appelée a chaque tick d'horloge
     *
     * @todo coder cette fonction
     */
    public void executeAction() {
        if (actions.isEmpty()) {
            // liste actions vide, on change d'état
            etatCourant = etatDestination;
            // parcours des transitions
            List<Transition> transitions = etatCourant.getTransitions();
            Iterator<Transition> it = transitions.iterator();
            while (it.hasNext()) {
                Transition t = it.next();
                // si condition non valide, on passe à la suivante
                if (!t.getCondition().test()) {
                    continue;
                }
                //ajout des actions
                List<Action> newActions = t.getActions();
                actions.addAll(newActions);
                //on donne l'etat de destination
                etatDestination = t.getEtatDestination();
                break;
            }
        }
    }
}
