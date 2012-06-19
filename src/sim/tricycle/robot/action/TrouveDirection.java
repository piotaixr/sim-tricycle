/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.Sens;
import sim.tricycle.robot.action.core.AbstractAction;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author Adri
 */
public class TrouveDirection extends AbstractAction{

    private Variable varCaseCiblee;
    
    public TrouveDirection() {
    }
    
    @Override
    protected Object doExecute(Robot bot) {
       Point p = (Point)varCaseCiblee.getValue();
        return trouveDirection(bot.getCoordonnees(),p);
    }
    
    
    private Sens trouveDirection(Point p1, Point p2) {
        
        Sens newSens = Sens.NORD;

        if (p1.getX() < p2.getX()) {
            newSens = Sens.NORD;
        } else if (p1.getY() < p2.getY()) {
            newSens = Sens.OUEST;
        } else if (p2.getX() < p1.getX()) {
            newSens = Sens.SUD;
        } else if (p2.getY() < p1.getY()) {
            newSens = Sens.EST;
        }

        return newSens;
    }

    @Override
    public String getId() {
        return "trouvedirection";
    }
    
}
