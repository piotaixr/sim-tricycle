/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.Sens;
import sim.tricycle.robot.action.core.AbstractAction;
import sim.tricycle.utils.params.types.Reference;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author Adri
 */
public class TrouveDirection extends AbstractAction{

    private Reference refPoint;
    private Point point;
    
    public TrouveDirection() {
    }
    
    @Override
    protected Object doExecute(Robot bot) {
      
       if(refPoint!=null){
           point=(Point)refPoint.getValue();
       }
        return trouveDirection(bot.getCoordonnees(),point);
    }
    
    private Sens trouveDirection(Point p1, Point p2) {
        
        Sens newSens = Sens.NORD;

        if (p1.getX() < p2.getX()) {
            newSens = Sens.EST;
        } else if (p1.getY() < p2.getY()) {
            newSens = Sens.SUD;
        } else if (p2.getX() < p1.getX()) {
            newSens = Sens.OUEST;
        } else if (p2.getY() < p1.getY()) {
            newSens = Sens.NORD;
        }

        return newSens;
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
        return "trouvedirection";
    }
    
}
