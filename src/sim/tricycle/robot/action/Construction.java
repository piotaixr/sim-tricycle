/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;


import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.elementCase.AbstractBatiment;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Marion DALLE  mariondallesoulard@gmail.com
 */
public class Construction extends AbstractAction {
    
    
 
    
    @Override
    protected Object doExecute(Robot bot) {
        
        Case c = bot.getMapObjective().getCase(bot.caseDevant().getX(),bot.caseDevant().getY());
        AbstractBatiment bat = (AbstractBatiment)c.myObstacle();
        
       if(bat.getTemps()==0){
            bot.getEquipe().supprimerRessource(bat.getItem(),bat.getPrix());
            bat.setTemps(bat.getTemps()+1);
            bot.getMapTeam().getCase(bot.caseDevant().getX(),bot.caseDevant().getY()).setObstacle(bat);
        }
       else bat.setTemps(bat.getTemps()+1); 
       return null;
    }

    @Override
    public String getId() {
        return "construction";
    }
    
   
}
