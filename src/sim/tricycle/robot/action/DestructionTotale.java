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
        
        Case c = bot.getT().getMap().getCaseDevant(bot);
        
        if(c.getObstacle() instanceof AbstractBatiment){
            AbstractBatiment bat = (AbstractBatiment) c.getObstacle();            
            while(bat.getTemps()>0){
                b.addNew("Destruction", bat);
            }
        }
        
        return null;
    }

    @Override
    public String getId() {
        return "destruction totale";
    }
       
    
}
