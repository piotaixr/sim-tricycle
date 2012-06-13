/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils.params.types;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class Variable extends Reference implements VariableInterface {

    public Variable(String selector, Environnement environnement) {
        super(selector, environnement);
    }

    @Override
    public void setValue(Object value) {
        try {
            new BasicObjectAccessor(getEnvironnement()).setValue(getSelector(), value);
        } catch (Exception ex) {
            throw traiteException(ex);
        }
    }
}
