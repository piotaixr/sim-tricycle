/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import java.util.ArrayDeque;
import java.util.LinkedList;
import sim.tricycle.robot.Noeud;
import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.Sens;

/**
 *
 * @author Adri
 */
public class AllerA extends Action{
    
    private Point p;
    
    public AllerA(Point p){
        super();
       this.p=p;   
    }
    
    @Override
    public void executer(Robot bot){
        TrouveChemin tc = new TrouveChemin(this.p);
        tc.executer(bot);
        creerChemin(tc.getChemin(),bot);
    }
    
    private ArrayDeque<ActionInterface> creerChemin(LinkedList<Noeud> cheminTrouve,Robot bot){
        ArrayDeque<ActionInterface> chemin=new ArrayDeque<ActionInterface>();
        Sens directCourante=bot.getDirection();
        Point posCourante=bot.getPosition();
        for(Noeud n:cheminTrouve){
            directCourante= trouveDirection(posCourante,n.getPoint());
            chemin.addFirst(new Tourner(directCourante));
            chemin.addFirst(new Avancer());
            posCourante=n.getPoint();
        }
        return chemin;
    }
    
    private Sens trouveDirection(Point p1,Point p2){
        
        Sens newSens=Sens.NORD;
        
        if(p1.getX()<p2.getX()){
            newSens= Sens.EST;
        }else{
            if(p1.getY()<p2.getY()){
               newSens= Sens.SUD;
            }else{
                if(p2.getX()<p1.getX()){
                  newSens= Sens.OUEST;
                }else{
                    if(p2.getY()<p1.getY()){
                        newSens= Sens.NORD;
                    }
                }
            }
        }
        return newSens;
    }
    
    public void setP(Point newP){
        this.p=newP;
    }
    
    public Point getP(){
        return this.p;
    }
    
    @Override
    public String getId() {
        return "allera";
    }
}
