/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils.params.types;

import sim.tricycle.mapping.Case;
import sim.tricycle.robot.Robot;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class RobotHelper {

    private Robot robot;

    public RobotHelper(Robot robot) {
        this.robot = robot;
    }
    
    public Case getCase(){
        return robot.getPosition();
    }
}
