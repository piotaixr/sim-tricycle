/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

/**
 *
 * @author Adri
 */
public abstract class Action implements ActionInterface {

    private int poids = 1;

    public Action(int poids){
        this.poids = poids;
    }
    
    public Action(){
        this(1);
    }

    public void setPoids(int newPoids) {
        this.poids = newPoids;
    }

    public int getPoids() {
        return this.poids;
    }
}
