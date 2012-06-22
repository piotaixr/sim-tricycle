/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractActionComposee;
import sim.tricycle.utils.ActionBuilder;
import sim.tricycle.utils.params.converter.PointConverter;
import sim.tricycle.utils.params.types.Reference;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author Adri
 */
public class AllerIci extends AbstractActionComposee{

    private Point point;
    private Reference refPoint;
    
    @Override
    protected Object doExecute(Robot bot) {
        
        if(refPoint!=null){
            point=(Point)refPoint.getValue();
        }
        getBuilder().addNewReturn("trouvechemin", "chemin", point)
                    .addNew("suivrechemin", getBuilder().buildVariable("chemin"));
        return null;
    }

    @Override
    public String getId() {
        return "allerici";
    }

    public AllerIci(ActionBuilder builder) {
        super(builder);
    }
    
    public void setParameters(String point) {
        PointConverter pc = new PointConverter();
        this.point = (Point)pc.convert(point);
    }
    
    public void setParameters(Point point) {
        this.point = point;
    }

    public void setParameters(Reference point) {
        this.refPoint = point;
    }
    
    public void setParameters(Variable point) {
        this.refPoint = point;
    } 
}
