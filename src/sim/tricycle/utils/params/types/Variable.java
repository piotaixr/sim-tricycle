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
public class Variable extends Reference implements VariableInterface {

    public Variable(String selector, OrdonnanceurInterface ordonnanceur) {
        super(selector, ordonnanceur);
    }

    @Override
    public void setValue(Object value) {
        try {
            new BasicObjectAccessor(getEnvironnementRobotCourant()).setValue(getSelector(), value);
        } catch (Exception ex) {
            throw traiteException(ex);
        }
    }
}
