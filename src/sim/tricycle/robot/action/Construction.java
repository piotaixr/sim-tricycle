/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractActionComposee;
import sim.tricycle.utils.ActionBuilder;

/**
 *
 * @author marion
 */
public class Construction extends AbstractActionComposee {
    
    private String nombat;
    
    public void setParameters (String nombat){
        this.nombat = nombat;
    }

    public Construction(ActionBuilder builder) {
        super(builder);
    }

    @Override
    protected Object doExecute(Robot bot) {
        ActionBuilder b = getBuilder();
        b.addNewReturn("InitialisationConstruction","bat", b.buildVariable("nombat"));
        b.addNew("ConstructionApInit",b.buildVariable("bat"));
        return null;
    }

    @Override
    public String getId() {
        return "Construction éffectuée";
    }

   
}
