/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.robot.Sens;

/**
 *
 * @author Adri
 */
public class Tourner {
    
    private Sens direction;
    
    public Tourner(){
        direction=Sens.NORD;
    }
    
    public Tourner(Sens dir){
        this.direction=dir;
    }
    
    public void executer(Robot bot){
        
       bot.setDirection(this.direction);
    }
    
    public void setDirection(Sens newDir){
        this.direction=newDir;
    }
    
    public Sens setDirection(){
        return this.direction;
    }
}
