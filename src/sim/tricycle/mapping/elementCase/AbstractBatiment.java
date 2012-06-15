/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.mapping.elementCase;

/**
 *
 * @author marion dalle mariondallesoulard@gmail.com
 */
public abstract class AbstractBatiment extends AbstractObstacle {
    
    protected int prix;
    protected int porteeMax;
    protected int temps;
    protected int tempsMax;
    protected int portee;
    protected AbstractObjet Item;

    public AbstractObjet getItem() {
        return Item;
    }

    public void setItem(AbstractObjet Item) {
        this.Item = Item;
    }

    public int getPorteeMax() {
        return porteeMax;
    }

    public void setPorteeMax(int porteeMax) {
        this.porteeMax = porteeMax;
    }

    public int getTempsMax() {
        return tempsMax;
    }

    public void setTempsMax(int tempsMax) {
        this.tempsMax = tempsMax;
    }
    


    public int getPortee() {
        return portee;
    }

    public void setPortee() {
        this.portee = (int)(this.porteeMax/this.tempsMax)*this.temps;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }
    
   
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
