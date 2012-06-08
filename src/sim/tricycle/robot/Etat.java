/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot;

import java.util.ArrayList;

/**
 *
 * @author Adri
 */
public class Etat {

    private int id;
    private ArrayList<Transition> listeTransition;

    public Etat(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Transition> getListeTransition() {
        return listeTransition;
    }

    public void setListeTransition(ArrayList<Transition> listeTransition) {
        this.listeTransition = listeTransition;
    }
}
