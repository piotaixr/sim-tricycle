/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action.core;

import java.util.Deque;
import sim.tricycle.robot.Robot;
import sim.tricycle.utils.ActionBuilder;

/**
 *
 * @author Adri
 */
public abstract class AbstractActionComposee extends AbstractAction implements Cloneable {

    private ActionBuilder builder;

    public AbstractActionComposee(ActionBuilder builder) {
        super(0);
        this.builder = builder;
    }

    public ActionBuilder getBuilder() {
        return builder;
    }

    public Deque<ActionInterface> getNewActions() {
        return builder.getActions();
    }

    @Override
    public void executer(Robot bot) {
        builder.reinit();
        super.executer(bot);
    }
     
    @Override
    protected abstract Object doExecute(Robot bot);

    @Override
    public boolean isComposee() {
        return true;
    }

    public void relaunch() {
        builder.reinit();
    }
}
