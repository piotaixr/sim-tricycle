package sim.tricycle.robot.action;

import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Adri
 */
public class Avancer extends AbstractAction {

    public Avancer() {
        super();
    }

    @Override
    protected Object doExecute(Robot bot) {
        if(!bot.getTeam().getMap().avancer(bot)){
            throw new RuntimeException("Erreur lors du deplacement du robot");
        }
        return null;
    }
    
    @Override
    public String getId() {
        return "avancer";
    }
}
