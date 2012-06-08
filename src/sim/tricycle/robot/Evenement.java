/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot;

/**
 *
 * @author Adri
 */
public class Evenement {
    
    private EventType type;
    
    public Evenement(){
    
   }
    
    public void setType(EventType newType){
        this.type=newType;
    }
    
    public EventType getType(){
        return this.type;
    }
}
