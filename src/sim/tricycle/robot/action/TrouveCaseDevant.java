/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Adri
 */
public class TrouveCaseDevant extends AbstractAction {

    public TrouveCaseDevant() {
        super();
    }
   
    @Override
    protected Object doExecute(Robot bot){
        return caseDevant(bot);
    }
    
    public Point caseDevant(Robot bot){
        int X = bot.getCoordonnees().getX();
        int Y = bot.getCoordonnees().getY();

        switch (bot.getDirection()){
            case NORD :
                if (Y>=0)Y=Y-1;
                else throw new RuntimeException("pas de case face au robot");                       
                break;
                
            case EST :
                if (X!=bot.getT().getMap().getLargeur()) X=X+1;
                else throw new RuntimeException("pas de case face au robot");
                break;
                
            case SUD : 
                if (Y!=bot.getT().getMap().getHauteur()) Y=Y+1;
                else throw new RuntimeException("pas de case face au robot");
                break;
                
            case OUEST :
                if (X>=0) X=X-1;
                else throw new RuntimeException("pas de case face au robot");
                break;
        }
        return new Point(X,Y);        
    }
        
    @Override
    public String getId(){
        return "trouveCaseDevant";
    }
        
}