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
public class FinirConstruction extends AbstractActionComposee{
    
    private Variable varbat;
    
    public void setParameters(Variable varbat){
        this.varbat = varbat;
    }
    
    public FinirConstruction(ActionBuilder builder) {
        super(builder);
    }

    @Override
    protected Object doExecute(Robot bot) {
        AbstractBatiment bat = (AbstractBatiment) varbat.getValue();
        ActionBuilder b = getBuilder();
        int temps = bat.getTemps();
        while(temps <= bat.getTempsMax()){
            b.addNew("construction");
            temps++;
        }
        return null;
    }

    @Override
    public String getId() {
        return "finir_construction";
    }
    
}
