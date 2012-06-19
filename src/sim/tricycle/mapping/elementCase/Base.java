/*
 */
package sim.tricycle.mapping.elementCase;

import sim.tricycle.mapping.TypeCase;
import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.team.Team;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Base extends AbstractZone {

    private Team t = null;

    public Base() {
    }

    public void setT(Team t) {
        this.t = t;
    }

    public Team getT() {
        return t;
    }

    @Override
    public TypeCase whoIam() {
        return (TypeCase.base);
    }

    @Override
    public String toString() {
        return " > ";
    }

    public boolean invocationPossible() {
        return !pos.hasObstacle();
    }

    /**
     * crée un robot de la team sur la base.
     *
     * @param Rob
     */
    public void popRob(Robot rob) {

        pos.setObstacle(rob);
    }
}
