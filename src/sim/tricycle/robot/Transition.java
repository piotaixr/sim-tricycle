package sim.tricycle.robot;

import java.util.ArrayList;
import java.util.List;
import sim.tricycle.robot.action.ActionInterface;
import sim.tricycle.robot.condition.ConditionInterface;

/**
 *
 * @author Adri
 */
public class Transition {

    private Etat etatDepart;
    private Etat etatDestination;
    private ConditionInterface condition = null;
    private List<ActionInterface> actions = new ArrayList();

    public Transition(Etat depart, Etat destination, ConditionInterface condition) {
        this.etatDepart = depart;
        this.etatDestination = destination;
        this.condition = condition;
    }

    public ConditionInterface getCondition() {
        return condition;
    }

    public List<ActionInterface> getActions() {
        return actions;
    }

    public void addAction(ActionInterface act) {
        this.actions.add(act);
    }

    public Etat getEtatDepart() {
        return etatDepart;
    }

    public Etat getEtatDestination() {
        return etatDestination;
    }
}
