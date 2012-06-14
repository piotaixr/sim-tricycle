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
    private LinkedList<Robot> modelRobot;
    private Carte map;
    private Point base;
    private int gold;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Team(String nomTeam, Carte map, Point base) {
        this.nomTeam = nomTeam;
        this.map = map;
        this.armee = new LinkedList<Robot>();
        this.base = base;
        this.gold = 0;
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
    
    public LinkedList<Robot> getModels(){
        return modelRobot;
    }
    
    public void addModel(Robot bot){
        modelRobot.add(bot);
    }
}
