/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils.params.types;

import sim.tricycle.Ordonnanceur.OrdonnanceurInterface;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class VarBuilder {

    private OrdonnanceurInterface ordonnanceur;

    public VarBuilder(OrdonnanceurInterface ordonnanceur) {
        this.ordonnanceur = ordonnanceur;
    }
    
    public Reference buidReference(String selector){
        return new Reference(selector, ordonnanceur);
    }
    
    public Variable buildVariable(String selector){
        return new Variable(selector, ordonnanceur);
    }
}
