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
public class Construire extends AbstractActionComposee {
    
    private String nombat;
    
    public void setParameters (String nombat){
        this.nombat = nombat;
    }

    public Construire(ActionBuilder builder) {
        super(builder);
    }

    @Override
    protected Object doExecute(Robot bot) {
        ActionBuilder b = getBuilder();
        b.addNewReturn("initialisation_construction","bat", nombat);
        b.addNew("finir_construction", b.buildVariable("bat"));
        return null;
    }

    @Override
    public String getId() {
        return "construire";
    }

   
}
