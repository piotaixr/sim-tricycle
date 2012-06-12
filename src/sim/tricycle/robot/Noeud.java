/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot;

/**
 *
 * @author Adri
 */
public class Noeud implements Comparable<Noeud> {

    private int poids;
    private Point p;
    private Noeud parent;

    public Noeud(Point p) {
        this.p = p;
        this.poids = 0;
    }
    
    public Noeud(Point p,Noeud parent) {
        this.p = p;
        this.poids = 0;
        this.parent=parent;
    }


    public void determinePoids(Point pDest) {

        this.poids = this.p.distanceDepuis(pDest);
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int newPoids) {
        this.poids = newPoids;
    }

    public Point getPoint() {
        return p;
    }

    public void setPoint(Point newPoint) {
        this.p = newPoint;
    }

    public Noeud getParent(){
        return this.parent;
    }
    
    public void setParent(Noeud newParent){
        this.parent=newParent;
    }
    
    public int compareTo(Noeud o) {
        Noeud n = (Noeud) o;
        if (n.getPoids() > this.poids) {
            return 1;
        } else {
            if (n.getPoids() < this.poids) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}