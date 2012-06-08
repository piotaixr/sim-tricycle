/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot;

/**
 *
 * @author Adri
 */
public class Noeud implements Comparable{
    
    
    private int poids;
    private Point p;
    
    public Noeud(Point p){
        this.p=p;
        this.poids=0;
    }
       
    public void DeterminePoids(Point pDest){
      
      this.poids=this.p.DistanceDepuis(pDest);
    }
    
    public int GetPoids(){
        return poids;
    }
    
    public void SetPoids(int newPoids){
        this.poids=newPoids;
    }
    
    public Point GetPoint(){
        return p;
    }
    
    public void SetPoint(Point newPoint){
        this.p=newPoint;
    }
    
    public int compareTo(Object o){
        Noeud n=(Noeud)o;
        if(n.GetPoids()>this.poids){
            return 1;
        }else{
            if(n.GetPoids()<this.poids){
                return -1;
            }else{
                return 0;
            }
        }
    }
}