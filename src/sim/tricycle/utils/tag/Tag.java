/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils.tag;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class Tag {

    private Map<String, Integer> valeurs = new HashMap();
    private String nom;

    public Tag(String nom) {
        this.nom = nom;
    }

    public void addValeur(String nom, int valeur) {
        valeurs.put(nom, valeur);
    }

    public boolean hasValeur(String nom) {
        return valeurs.containsKey(nom);
    }

    public int getValeur(String nom) {
        return valeurs.get(nom);
    }

    public String getNom() {
        return nom;
    }
}
