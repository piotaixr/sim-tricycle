/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot;

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
    
    public void Executer($Robot bot){
        
       bot.SetDirection(this.direction);
    }
    
    public void SetDirection(Sens newDir){
        this.direction=newDir;
    }
    
    public Sens SetDirection(){
        return this.direction;
    }
}
