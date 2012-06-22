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
public class SeDeplacerUneCase extends AbstractActionComposee {

    private Point point;
    private Reference refPoint = null;

    public SeDeplacerUneCase(ActionBuilder builder) {
        super(builder);
    }

    public Object doExecute(Robot bot) {
//        Point point = (Point)varPoint.getValue();
        if (refPoint != null) {
            this.point = (Point) this.refPoint.getValue();
        }
        getBuilder().addNewReturn("trouvedirection", "sens", point).addNew("tourner", getBuilder().buildVariable("sens")).addNew("Avancer");
        return null;
    }

    public void setParameters(String point) {
        PointConverter pc = new PointConverter();
        this.point = (Point) pc.convert(point);
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

    public String getId() {
        return "sedeplacerunecase";
    }
}
