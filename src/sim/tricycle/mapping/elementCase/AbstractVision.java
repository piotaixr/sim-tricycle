/*
 */
package sim.tricycle.mapping.elementCase;

import sim.tricycle.team.Team;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class AbstractVision extends AbstractObstacle {

    protected Team t=null;
    protected int prix=0;
    protected int porteeMax=0;

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

    public void setT(Team t) {
        this.t = t;
    }

    public int getPortee() {
        return portee;
    }

    public Team getT() {
        return t;
    }
}
