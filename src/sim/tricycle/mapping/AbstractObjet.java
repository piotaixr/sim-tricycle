/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.mapping;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public abstract class AbstractObjet implements PossedeCase{

    protected Case pos;

    /*
     * getPosition retourne la case sur laquelle se trouve la boule. @return La
     * case de la boule
     */
    public Case getPosition() {
        return pos;
    }
}