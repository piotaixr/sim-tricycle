/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.team;

/**
 *
 * @author marion
 */
public class Ressource {
    
    private String idItem;
    private int quantite;

    public String getIdItem() {
        return idItem;
    }

    public void setItem(String IdItem) {
        this.idItem = idItem;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    public Ressource (){
        
    }
    
    public Ressource (String idItem, int quantite){
        this.idItem = idItem;
        this.quantite = quantite;
    }
    
    public boolean equals (Object o){
        Ressource r = (Ressource)o; 
        return this.idItem.equals(r.idItem);
    }
    
    
}
