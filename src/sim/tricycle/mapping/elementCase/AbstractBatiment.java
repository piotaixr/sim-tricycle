/*
 */
package sim.tricycle.mapping.elementCase;

/**
 *
 * @author marion dalle mariondallesoulard@gmail.com
 */
public abstract class AbstractBatiment extends AbstractVision {
    
    protected int temps;
    protected int tempsMax;

    public int getTempsMax() {
        return tempsMax;
    }

    public void setTempsMax(int tempsMax) {
        this.tempsMax = tempsMax;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }  
  
    @Override
    public String toString() {
       return "B";
    }
   
}
