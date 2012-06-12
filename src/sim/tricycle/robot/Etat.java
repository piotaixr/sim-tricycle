/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Adri
 */
public class Etat {

    private String id;
    private List<Transition> transitions;

    public Etat(String id) {
        this.id = id;
    }

    public String getId() {
        return id;

    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void getTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }

    public void addTransition(Transition t) {
        transitions.add(t);
    }
}
