/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.PossedeCaseInterface;
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
public class AllerIci extends AbstractActionComposee {

    private Point point;
    private Reference refPoint;

    @Override
    protected Object doExecute(Robot bot) {
        Object o = refPoint.getValue();
        if (refPoint != null) {
            if (o instanceof Point) {
                point = (Point) o;
            } else if (o instanceof PossedeCaseInterface) {
                point = ((PossedeCaseInterface) o).getPosition().toPoint();
            } else if (o instanceof Case) {
                point = ((Case) o).toPoint();
            } else {
                System.out.println("Mauvais type passé en parametre! : " + o.getClass().getName());
                return null;
            }

        }
        getBuilder().addNewReturn("trouvechemin", "chemin", point).addNew("suivrechemin", getBuilder().buildVariable("chemin"));
        return null;
    }

    @Override
    public String getId() {
        return "allerici";
    }

    public AllerIci(ActionBuilder builder) {
        super(builder);
        setPoids(1);
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
}
