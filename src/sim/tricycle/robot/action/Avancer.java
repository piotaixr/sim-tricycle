/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;

/**
 *
 * @author Adri
 */
public class Avancer extends Action{
    
    private int nbCases;
    
    public Avancer(){nbCases=1;};
    
    public Avancer(int nbCases){this.nbCases=nbCases;};

    
    @Override 
    public void executer(Robot bot){
        
        Point p=new Point(bot.getPosition());
        
       for(int i=0;i<nbCases;i++){
        switch(bot.getDirection()){
            case NORD:
                p.setX(p.getX()+1);
                break;
                
            case EST:
                p.setX(p.getY()+1);
                break;
                 
            case OUEST:
                p.setX(p.getY()-1);
                break;
            
            case SUD:
                p.setX(p.getX()-1);
                break;
                
            case SUD_EST:
                p.setX(p.getX()-1);
                p.setY(p.getY()+1);
                break;
                
            case SUD_OUEST:
                p.setX(p.getX()-1);
                p.setY(p.getY()-1);
                break;
                
            case NORD_EST:
                p.setX(p.getX()+1);
                p.setY(p.getY()+1);
                break;
                
            case NORD_OUEST:
                p.setX(p.getX()+1);
                p.setY(p.getY()-1);
                break;
        }
       }
        bot.setPosition(p);
    }
    
}
