/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;


import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.elementCase.AbstractBatiment;
import sim.tricycle.mapping.elementCase.AbstractObstacle;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.Sens;
import sim.tricycle.robot.action.core.AbstractAction;
import sim.tricycle.team.Ressource;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author Marion DALLE  mariondallesoulard@gmail.com
 */
public class Construction extends AbstractAction {
    
    private  Variable varbat;
 
    
    @Override
    protected Object doExecute(Robot bot) {
       AbstractBatiment bat = (AbstractBatiment)varbat.getValue();
       if(bat.getTemps()==0){
            bot.getTeam().supprimerRessource(bat.getItem(),bat.getPrix());
            bat.setTemps(bat.getTemps()+1);
            bot.getMapObjective().getCase(bot.caseDevant().getX(),bot.caseDevant().getY()).setObstacle(bat);
        }
       else bat.setTemps(bat.getTemps()+1); 
       return null;
    }

    @Override
    public String getId() {
        return "construction";
    }
    
   
}
