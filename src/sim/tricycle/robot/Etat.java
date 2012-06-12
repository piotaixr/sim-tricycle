package sim.tricycle.robot;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adri
 */
public class Etat {

    private String id;
    private List<Transition> transitions;
    private List<String> tags = new ArrayList<String>();

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

    public void addTag(String nomTag) {
        tags.add(nomTag);
    }

    public List<String> getTags() {
        return tags;
    }
}
