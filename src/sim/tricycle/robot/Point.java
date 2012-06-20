package sim.tricycle.robot;

import java.io.Serializable;

/**
 *
 * @author Adri
 */
public class Point implements Serializable {

    private int x;
    private int y;
    static final long serialVersionUID = 1L;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public void setX(int newX) {
        this.x = newX;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getStringedCoord(){
        return this.getX()+" "+this.getY();
    }
    
    public int distanceDepuis(Point p) {

        return Math.abs(p.getX() - this.getX()) + Math.abs(p.getY() - this.getY());
    }
}
