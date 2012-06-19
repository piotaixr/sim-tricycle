/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.elementCase.AbstractBatiment;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractActionComposee;
import sim.tricycle.utils.ActionBuilder;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author marion
 */
public class ConstructionApInit extends AbstractActionComposee{
    
    private Variable varbat;
    
    public void setParameters(Variable varbat){
        this.varbat = varbat;
    }
    
    public ConstructionApInit(ActionBuilder builder) {
        super(builder);
    }

    @Override
    protected Object doExecute(Robot bot) {
        AbstractBatiment bat = (AbstractBatiment)varbat.getValue();
        ActionBuilder b = getBuilder();
        while(bat.getTemps() < bat.getTempsMax()){
            b.addNew("ConstructionEnCours",bat);
        }
        return null;
    }

    @Override
    public String getId() {
        return "construction en boucle OK";
    }
    
}
