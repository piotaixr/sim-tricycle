/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.team;

import sim.tricycle.mapping.elementCase.AbstractObjet;

/**
 *
 * @author marion
 */
public class Ressource {
    
    private AbstractObjet item;
    private int quantite;

    public AbstractObjet getItem() {
        return item;
    }

    public void setItem(AbstractObjet item) {
        this.item = item;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    public Ressource (){
        
    }
    
    public Ressource (AbstractObjet item, int quantite){
        this.item = item;
        this.quantite = quantite;
    }
    
    public boolean equals (Object o){
        Ressource r = (Ressource)o; 
        return this.item.equals(r.item);
    }
    
    
}
