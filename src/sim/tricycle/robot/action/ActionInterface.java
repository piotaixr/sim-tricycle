/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.utils.IdentifiableInterface;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public interface ActionInterface extends IdentifiableInterface<String> {

    public void executer(Robot bot);
}
