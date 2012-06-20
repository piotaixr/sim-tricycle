/*
 */
package sim.tricycle.mapping.elementCase;

import sim.tricycle.mapping.Case;
import sim.tricycle.team.Team;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class AbstractVision extends AbstractObstacle {

    protected Team t = null;
    protected int prix = 0;
    protected int porteeMax = 0;
    protected int pv = 0;
    protected int pointAttaque = 0;

    public int getPorteeMax() {
        return porteeMax;
    }

    public int getPrix() {
        return prix;
    }
    protected int portee;

    public void setPorteeMax(int porteeMax) {
        this.porteeMax = porteeMax;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setPortee(int portee) {
        this.portee = portee;
    }

    public void setTeam(Team t) {
        this.t = t;
    }

    public int getPortee() {
        return portee;
    }

    public Team getTeam() {
        return t;
    }

    /**
     * Si l'element peut voir une case c.
     * @param c
     * @return vrai s'il voit la case.
     */
    public boolean voit(Case c) {
        int x=(Math.abs(c.getX()- this.pos.getX()));
        int y=Math.abs(c.getX()- this.pos.getX());
        return (x+y>this.portee);
    }
    
    public void majvision(){
        this.getTeam().getMap().actualiserCarte( this.portee, pos);
    }
}
