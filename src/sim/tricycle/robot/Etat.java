/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot;

import java.util.HashMap;

/**
 *
 * @author Adri
 */
public class Etat {

    private String id;
    private HashMap<EventType, Transition> listeTransition;
    private Robot bot;

    public Etat(String id) {
        this.id = id;
    }

    public void etatSuivant(Evenement evt) {
        listeTransition.get(evt.getType()).effectuerTransition(this.bot);
    }

    public String getId() {
        return id;

    }

    public void setId(String id) {
        this.id = id;
    }

    public Robot getBot() {
        return bot;
    }

    public void setBot(Robot bot) {
        this.bot = bot;
    }

    public HashMap<EventType, Transition> getListeTransition() {
        return listeTransition;
    }

    public void setListeTransition(HashMap<EventType, Transition> listeTransition) {
        this.listeTransition = listeTransition;
    }
}
