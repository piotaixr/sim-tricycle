/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action.core;

import java.util.ArrayDeque;
import sim.tricycle.robot.Robot;

/**
 *
 * @author Adri
 */
public abstract class AbstractActionComposee extends AbstractAction{
    
    
    
    ArrayDeque<ActionInterface> suiteActions;

    public ArrayDeque<ActionInterface> getSuiteActions() {
        return suiteActions;
    }

    public void setSuiteActions(ArrayDeque<ActionInterface> suiteActions) {
        this.suiteActions = suiteActions;
    }
    
    
}
