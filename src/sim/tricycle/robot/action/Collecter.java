/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import java.util.ArrayDeque;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;
import sim.tricycle.robot.action.core.AbstractActionComposee;

/**
 *
 * @author Adri
 */
public class Collecter extends AbstractActionComposee{

    public Collecter() {
    }
    
    public Object doExecute(Robot bot){
        return null;
    }
    
    public String getId(){
        return "collecterHautNiveau";
    }
    
    @Override
    public ArrayDeque<AbstractAction> getSuiteActions() {
        return super.getSuiteActions();
    }

    @Override
    public void setSuiteActions(ArrayDeque<AbstractAction> suiteActions) {
        super.setSuiteActions(suiteActions);
    }

    
}