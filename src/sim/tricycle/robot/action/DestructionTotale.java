/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.elementCase.AbstractBatiment;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractActionComposee;
import sim.tricycle.utils.ActionBuilder;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author marion
 */
public class DestructionTotale extends AbstractActionComposee {

    public DestructionTotale(ActionBuilder builder) {
        super(builder);
    }

    @Override
    protected Object doExecute(Robot bot) {
        
        ActionBuilder b = getBuilder();
        
        Case c = bot.getTeam().getMap().getCaseDevant(bot);
        
        
        if(c.getObstacle() instanceof AbstractBatiment){
            AbstractBatiment bat = (AbstractBatiment) c.getObstacle(); 
            int nb = bat.getTemps();
            for (int i=1;i<=nb;i++){
                b.addNew("Destruction");
            }
        }
        else throw new RuntimeException ("il n'y a pas de batiment debant le robot");
        
        return null;
    }

    @Override
    public String getId() {
        return "destruction totale";
    }
       
    
}
