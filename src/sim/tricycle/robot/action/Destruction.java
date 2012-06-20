/*
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.elementCase.AbstractBatiment;
import sim.tricycle.mapping.elementCase.AbstractObstacle;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author marion
 */
public class Destruction extends AbstractAction {
    

    @Override
    protected Object doExecute(Robot bot) {
        
        Case c = bot.getTeam().getMap().getCaseDevant(bot);
        if(!c.hasObstacle())throw new RuntimeException ("il n'y a pas de batiment devant le robot");
        if (c.getObstacle() instanceof AbstractBatiment){
            AbstractBatiment bat = (AbstractBatiment)c.getObstacle();
            if (bat.getTemps() > 0) {            
                bot.getTeam().getMap().getCaseDevant(bot).suprObstacle();
                if (bat.getTemps() == 0) {
                    bat.setTemps(bat.getTemps() - 1);
                }
            } else {
                throw new RuntimeException("il n'y a pas de batiment sur cette case");
            }
        }
        else throw new RuntimeException ("il n'y a pas de batiment devant le robot");
            

        return null;
    }

    @Override
    public String getId() {
        return "destruction";
    }
    
    
}
