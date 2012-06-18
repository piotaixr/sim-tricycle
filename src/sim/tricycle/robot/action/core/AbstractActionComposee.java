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
    
    
   
    
    protected ArrayDeque<AbstractAction> suiteActions;

    
    public AbstractActionComposee(){
        super();
        this.composee=true;
        this.setPoids(0);
    } 
    
    public ArrayDeque<AbstractAction> getSuiteActions() {
        return suiteActions;
    }

    public void setSuiteActions(ArrayDeque<AbstractAction> suiteActions) {
        this.suiteActions = suiteActions;
    }
    
    public Object doExecute(Robot bot){
        
        return null;
    }
}
