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
    
    protected ArrayDeque<ActionInterface> suiteActions;
    
    public AbstractActionComposee(){
        super();
        this.setPoids(0);
    } 
    
    public ArrayDeque<ActionInterface> getSuiteActions() {
        return suiteActions;
    }

    public void setSuiteActions(ArrayDeque<ActionInterface> suiteActions) {
        this.suiteActions = suiteActions;
    }
    
    @Override
    public abstract Object doExecute(Robot bot);

    @Override
    public boolean isComposee() {
        return true;
    }
    
    
}
