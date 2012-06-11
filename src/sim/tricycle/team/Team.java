/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.team;

import java.awt.Robot;
import java.util.LinkedList;
import sim.tricycle.mapping.Carte;

/**
 *
 * @author Adri
 */
public class Team {
    
   private String nomTeam; 
   private LinkedList<Robot> armee;
   private Carte map;
    
    
    public Team(String nomTeam,Carte map){
        this.nomTeam=nomTeam;
        this.map=map;
        this.armee=new LinkedList<Robot>();
    }
    
    public void addRobot(Robot bot){
        this.armee.add(bot);
    }
    
    public Carte getMap(){
        return this.map;
    }
    
    public String getNomTeam(){
        return this.nomTeam;
    }
}
