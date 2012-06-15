/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class Sleep extends AbstractAction {

    @Override
    protected Object doExecute(Robot bot) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getId() {
        return "sleep";
    }
}
