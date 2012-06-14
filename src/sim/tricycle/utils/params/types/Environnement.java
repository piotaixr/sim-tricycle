package sim.tricycle.utils.params.types;


import java.util.HashMap;
import java.util.Map;
import sim.tricycle.robot.Robot;
import sim.tricycle.team.Team;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class Environnement {

    private Team team;
    private Map<String, Object> var = new HashMap();
    private Robot self;

    public Environnement(Team team, Robot robot) {
        this.team = team;
        this.self = robot;
    }

    public Robot getSelf() {
        return self;
    }

    public Team getTeam() {
        return team;
    }

    public Map<String, Object> getVar() {
        return var;
    }
}
