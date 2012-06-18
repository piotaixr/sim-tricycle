package sim.tricycle.robot.action;

import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Adri
 */
public class Avancer extends AbstractAction {

    private int nbCases;

    public Avancer() {
        super();

    }
    
    public void setParameters(int nbCases){
        this.nbCases = nbCases;
    }

    @Override
    protected Object doExecute(Robot bot) {

        avancerUneCase(bot);
        return null;
    }
    
    public void avancerUneCase(Robot bot){
        
        Point p = new Point(bot.getCoordonnees());
        bot.decollerRobotDeMap();
        
        if(!bot.getMapTeam().getCase(p.getX(), p.getY()).hasObstacle()){
          bot.setCoordonnees(p);
        } 
        bot.collerRobotSurMap();
    }

    @Override
    public String getId() {
        return "avancer";
    }
}
