package sim.tricycle.robot;

import java.util.ArrayList;
import java.util.List;
import sim.tricycle.robot.action.core.ActionInterface;
import sim.tricycle.utils.tag.Tag;

/**
 *
 * @author Adri
 */
public class Etat {

    private String id;
    private List<Transition> transitions = new ArrayList<Transition>();
    private List<Tag> tags = new ArrayList<Tag>();
    private Automate automate;

    public Etat(String id, Automate automate) {
        this.id = id;
        this.automate = automate;
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

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public int getValeurAction(ActionInterface action) {
        for (Tag t : tags) {
            if (t.hasValeur(action.getId())) {
                return t.getValeur(action.getId());
            }
        }
        // retourner la valeur par defaut
        return action.getPoids();
    }
}
