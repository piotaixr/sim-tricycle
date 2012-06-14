/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.mapping.elementCase;

/**
 *
 * @author marion
 */
public class AbstractBatiment extends AbstractObstacle {
    
    protected int prix;
    protected int portee;

    public int getPortee() {
        return portee;
    }

    public void setPortee(int portee) {
        this.portee = portee;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }
    protected int temps;

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    @Override
    public String toString() {
        return "B";
    }
    
    public int getPrix(){
        return prix;
    }
    
   
}
