/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractActionComposee;

/**
 *
 * @author Adri
 */
public class RevenirBase extends AbstractActionComposee{
    
    public RevenirBase(){
        super();
        this.suiteActions.add(new TrouveChemin());
        this.suiteActions.add(new AllerA());
    }
    
    public Object doExecute(Robot bot){
        
        bot.setActions(suiteActions);
        return null;
    }
    
    public String getId(){
        return "revenirBase";
    }
    

    
}
