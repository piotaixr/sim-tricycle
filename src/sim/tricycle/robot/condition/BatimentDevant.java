package sim.tricycle.robot.condition;

import sim.tricycle.Ordonnanceur.OrdonnanceurInterface;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.condition.core.AbstractCondition;

/**
 *
 * @author Adri
 */
public class BatimentDevant extends AbstractCondition{
 

    private OrdonnanceurInterface ordonnanceur;

    public BatimentDevant(OrdonnanceurInterface ordonnanceur) {
        this.ordonnanceur = ordonnanceur;
    }

    @Override
    public String getId() {
        return "batiment_devant";
    }

    @Override
    public boolean test() {
        Robot bot = (Robot) ordonnanceur.getActiveTask();
        return bot.getTeam().getMap().getCaseDevant(bot).hasObstacle() && bot.getTeam().getMap().getCaseDevant(bot).getObstacle().whoIam()==TypeCase.tour;
    }
}

