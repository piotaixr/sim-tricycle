/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action.core;

import sim.tricycle.robot.Robot;
import sim.tricycle.utils.params.types.Variable;

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

    public void setParameters() {
    }

    @Override
    public void executer(Robot bot) {
        Object retour = doExecute(bot);
        if (destination != null) {
            destination.setValue(retour);
        }
    }

    protected abstract Object doExecute(Robot bot);

    @Override
    public boolean isComposee() {
        return false;
    }
}
