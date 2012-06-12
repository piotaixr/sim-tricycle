package sim.tricycle.team;

import java.awt.Robot;
import java.util.LinkedList;
import sim.tricycle.mapping.Carte;
import sim.tricycle.robot.Point;

/**
 *
 * @author Adri
 */
public class Team {

    private String nomTeam;
    private LinkedList<Robot> armee;
    private Carte map;
    private Point base;

    public Team(String nomTeam, Carte map, Point base) {
        this.nomTeam = nomTeam;
        this.map = map;
        this.armee = new LinkedList<Robot>();
        this.base = base;
    }

    public void addRobot(Robot bot) {
        this.armee.add(bot);
    }

    public Carte getMap() {
        return this.map;
    }

    public String getNomTeam() {
        return this.nomTeam;
    }

    public void setBase(Point newBase) {
        this.base = newBase;
    }

    public Point getBase() {
        return this.base;
    }
}