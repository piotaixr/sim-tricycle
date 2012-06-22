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

    private TeamHelper team;
    private Map<String, Object> var = new HashMap();
    private RobotHelper self;

    public Environnement(Team team, Robot robot) {
        this.team = new TeamHelper(team);
        this.self = new RobotHelper(robot);
    }

    public RobotHelper getSelf() {
        return self;
    }

    public TeamHelper getTeam() {
        return team;
    }

    public Map<String, Object> getVar() {
        return var;
    }

    public void cleanVars() {
        this.var.clear();
    }
}
