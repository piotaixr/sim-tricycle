/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractActionComposee;
import sim.tricycle.utils.ActionBuilder;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author Adri
 */
public class SeDeplacerUneCase extends AbstractActionComposee{

    private Variable varPoint;
    
    public SeDeplacerUneCase(ActionBuilder builder) {
        super(builder);
    }
    
    public Object doExecute(Robot bot){
        Point point = (Point)varPoint.getValue();
         getBuilder().addNewReturn("trouvedirection","sens",getBuilder().buildVariable("point"))
                     .addNew("tourner", getBuilder().buildVariable("sens"))
                     .addNew("Avancer");
        return null;
    }
    
    public String getId(){
        return "sedeplacerunecase";
    }
}
