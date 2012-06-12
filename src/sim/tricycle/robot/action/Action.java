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

    private int poids;

    public Action() {
        poids = 0;
    }

    public void setPoids(int newPoids) {
        this.poids = newPoids;
    }

    public int getPoids() {
        return this.poids;
    }
}
