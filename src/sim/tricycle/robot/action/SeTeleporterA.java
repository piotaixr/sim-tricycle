/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Adri
 */
public class SeTeleporterA extends AbstractAction{

    private Point p;
    
    public SeTeleporterA(int poids,Point p){
        super(poids);
        this.p=p;
    }
    
    
   protected Object doExecute(Robot bot){
       bot.setCoordonnees(p);
       return null;
   }
   
   public String getId(){
       return "seTeleporter";
   }
    
}
