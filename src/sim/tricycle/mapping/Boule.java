/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim.tricycle.mapping;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Boule extends Objet{
    private int equipe;
    private Case pos;
    
    /*
     * Constructeur d'une boule.
     * @param equipe l'équipe propriétaire de la boule
     * @param pos la case de la boule.
     */
    public Boule(int equipe, Case pos){
        this.equipe = equipe;
        this.pos=pos;
        pos.setItem(this);
    }
        
    /*
     * getPosition retourne la case sur laquelle se trouve la boule.
     * @return La case de la boule
     */
    public Case getPosition(){
        return pos;
    }

    

}
