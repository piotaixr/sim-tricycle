/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot;

/**
 *
 * @author Adri
 */
public class Point {
    
    private int x;
    private int y;
    
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    public Point(Point p){
        this.x=p.GetX();
        this.y=p.GetY();
    }
    
    public void SetX(int newX){
        this.x=newX;
    }
    
        
    public void SetY(int newY){
        this.y=newY;
    }
    
        
    public int GetX(){
        return this.x;
    }
    
    public int GetY(){
        return this.y;
    }
    
    public int DistanceDepuis(Point p){
        
        return Math.abs(p.GetX()-this.GetX())+Math.abs(p.GetY()-this.GetY());
    }
    
}
