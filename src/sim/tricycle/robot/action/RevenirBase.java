/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Adri
 */
public class RevenirBase extends AbstractAction{
    
    AllerA aa;

    public RevenirBase(){
        super();
    }
    
    public Object doExecute(Robot bot){
        aa.setP(bot.getTeam().getBase());
        aa.doExecute(bot);
        return null;
    }
    
    public String getId(){
        return "revenirBase";
    }
    
    public AllerA getAa() {
        return aa;
    }

    public void setAa(AllerA aa) {
        this.aa = aa;
    }
    
}
