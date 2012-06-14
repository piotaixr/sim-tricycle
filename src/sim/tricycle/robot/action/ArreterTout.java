package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Adri
 */
public class ArreterTout extends AbstractAction{

    public ArreterTout() {
        super();
    }
    
    public Object doExecute(Robot bot){
        bot.setActions(null);
        return null;
    }
    
    public String getId(){
        return "arreterTout";
    }
}
