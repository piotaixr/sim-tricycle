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
    
        Point p = nextCase(bot);       
        if(!bot.getMapTeam().getCase(p.getX(), p.getY()).hasObstacle()){
          bot.decollerRobotDeMap();  
          bot.setCoordonnees(p);
          bot.collerRobotSurMap();
        } 
    }
    
    private Point nextCase(Robot bot){
        
        Point p = bot.getCoordonnees();
        switch(bot.getDirection()){
            
            case NORD:
                p.setX(p.getX()+1);
                break;
                
            case SUD:
                p.setX(p.getX()-1);
                break;
                
            case EST:
                p.setY(p.getY()+1);
                break;
                
            case OUEST:
                p.setY(p.getY()-1);
                break;
        }
        return p;
    }
    
    @Override
    public String getId() {
        return "avancer";
    }
}
