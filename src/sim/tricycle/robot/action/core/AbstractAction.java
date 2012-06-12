/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action.core;

import sim.tricycle.robot.Robot;
import sim.tricycle.robot.reference.Variable;

/**
 *
 * @author Adri
 */
public abstract class AbstractAction implements ActionInterface {

    private int poids = 1;
    private Variable destination = null;

    public AbstractAction(int poids) {
        this.poids = poids;
    }

    public AbstractAction() {
        this(1);
    }

    public void setPoids(int newPoids) {
        this.poids = newPoids;
    }

    public int getPoids() {
        return this.poids;
    }

    @Override
    public ActionInterface clone() throws CloneNotSupportedException {
        return (ActionInterface) super.clone();
    }

    @Override
    public void setVariableDestination(Variable variable) {
        destination = variable;
    }

    @Override
    public void executer(Robot bot) {
        Object retour = doExecute(bot);
        if(destination != null)
            destination.setValue(retour);
    }

    protected abstract Object doExecute(Robot bot);
    
}
