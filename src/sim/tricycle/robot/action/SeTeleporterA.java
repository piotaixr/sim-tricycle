/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;
import sim.tricycle.utils.params.types.Reference;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author Adri
 */
public class SeTeleporterA extends AbstractAction {

    private Point point;
    private Reference refPoint;

    public SeTeleporterA() {
        super(1);
    }

    public SeTeleporterA(int poids, Point p) {
        super(poids);
        this.point = point;
    }

    @Override
    protected Object doExecute(Robot bot) {

       if(refPoint!=null){
           this.point=(Point)refPoint.getValue();
       }
        if (!bot.getTeam().getMap().getCase(point.getX(), point.getY()).hasObstacle()) {
           // bot.setCoordonnees(point);
        }
        return null;
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
    
    @Override
    public String getId() {
        return "seTeleporter";
    }
}
