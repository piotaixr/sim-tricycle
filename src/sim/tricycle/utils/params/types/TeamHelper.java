/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils.params.types;

import sim.tricycle.mapping.Case;
import sim.tricycle.robot.Point;
import sim.tricycle.team.Team;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class TeamHelper {

    private Team team;

    public TeamHelper(Team team) {
        this.team = team;
    }
    
    public Case base(){
        return team.getBase().getPosition();
    }
}
