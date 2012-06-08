/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class Automate {

    private Map<Integer, Etat> etats = new HashMap();

    public void addEtat(Etat etat) {
        if (!hasEtat(etat.getId())) {
            etats.put(etat.getId(), etat);
        }
    }

    public boolean hasEtat(int id) {
        return etats.containsKey(id);
    }

    public Etat getEtat(int id) {
        return etats.get(id);
    }
}
