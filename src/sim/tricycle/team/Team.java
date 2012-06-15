package sim.tricycle.team;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.LinkedList;
import sim.tricycle.mapping.Carte;
import sim.tricycle.mapping.elementCase.AbstractObjet;
import sim.tricycle.robot.Point;

/**
 * @author Marion Dalle 
 * @author AdriA */
public class Team {

    private String nomTeam;
    private LinkedList<Robot> armee;
    private Carte map;
    private Point base;
    private ArrayList<Ressource> ressources;

    
    public Team(String nomTeam, Carte map, Point base, ArrayList<Ressource> ressources ) {
        this.nomTeam = nomTeam;
        this.map = map;
        this.armee = new LinkedList<Robot>();
        this.base = base;
        this.ressources = ressources;
        
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
    
    public ArrayList<Ressource> getRessources() {
        return ressources;
    }

    public void setRessources(ArrayList<Ressource> ressources) {
        this.ressources = ressources;
    }
    
    /* Au secours j'y comprend rien */
    public Ressource trouveRessourceParItem (AbstractObjet item){        
        return ressources.get(ressources.indexOf(new Ressource (item,0)));
    }
    
    public void ajouterRessource(AbstractObjet item){
        
        Ressource r = new Ressource(item,1);
        
        if(this.ressources.contains(r)){
            r=trouveRessourceParItem(item);
            r.setQuantite(r.getQuantite()+1);
        }else{
            this.ressources.add(r);
        }
    }

   



  
}
