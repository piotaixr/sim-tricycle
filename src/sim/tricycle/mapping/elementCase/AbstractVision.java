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
    protected int porteeMax = 1;
    protected int portee = 1;

    public int getPorteeMax() {
        return porteeMax;
    }

    public int getPrix() {
        return prix;
    }

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
     *
     * @param c
     * @return vrai s'il voit la case.
     */
    public boolean voit(Case c) {

        return (c.getX() == position.getX() && (position.getY() - 1 <= c.getY() && c.getY() <= position.getY() + 1)) ||
                (c.getY() == position.getY() && (position.getX() - 1 <= c.getX() && c.getX() <= position.getX() + 1));
    }

    public void majvision() {
        this.getTeam().getMap().actualiserCarte(this.portee, position);
    }
}
