/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot;

/**
 *
 * @author Adri
 */
public class Avancer extends $Action{
    
    private int nbCases;
    
    public Avancer(){nbCases=1;};
    
    public Avancer(int nbCases){this.nbCases=nbCases;};

    
    @Override 
    public void Executer($Robot bot){
        
        Point p=new Point(bot.GetPosition());
        
       for(int i=0;i<nbCases;i++){
        switch(bot.direction){
            case NORD:
                p.SetX(p.GetX()+1);
                break;
                
            case EST:
                p.SetX(p.GetY()+1);
                break;
                 
            case OUEST:
                p.SetX(p.GetY()-1);
                break;
            
            case SUD:
                p.SetX(p.GetX()-1);
                break;
                
            case SUD_EST:
                p.SetX(p.GetX()-1);
                p.SetY(p.GetY()+1);
                break;
                
            case SUD_OUEST:
                p.SetX(p.GetX()-1);
                p.SetY(p.GetY()-1);
                break;
                
            case NORD_EST:
                p.SetX(p.GetX()+1);
                p.SetY(p.GetY()+1);
                break;
                
            case NORD_OUEST:
                p.SetX(p.GetX()+1);
                p.SetY(p.GetY()-1);
                break;
        }
       }
        bot.SetPosition(p);
    }
    
}
