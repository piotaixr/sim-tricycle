/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot;

import java.util.ArrayList;
import sim.tricycle.robot.action.Action;

/**
 *
 * @author Adri
 */
public class Transition {

    private Etat etatDepart;
    private Etat etatDestination;
    private ArrayList<Action> listeAction = new ArrayList();

    public Transition(Etat depart, Etat destination) {
        this.etatDepart = depart;
        this.etatDestination = destination;
    }

    /**
     *
     * @param bot
     */
    public void enfilerAllActions(Robot bot) {
        bot.getFileActions().addAll(listeAction);
    }

    public void addAction(Action act) {
        this.listeAction.add(act);
    }
}
