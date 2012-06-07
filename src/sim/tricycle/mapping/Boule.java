/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim.tricycle.mapping;

import sim.tricycle.mapping.mapException.CaseMultipleObjetException;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Boule extends AbstractObjet{
    private int equipe;
    
    /*
     * Constructeur d'une boule.
     * @param equipe l'équipe propriétaire de la boule
     * @param pos la case de la boule.
     */
    public Boule(int equipe, Case pos) {
        this.equipe = equipe;
        this.pos=pos;
        pos.setItem(this);
    }
    
}
