/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils.params.types;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class Reference implements ReferenceInterface {

    private String selector;
    private Environnement environnement;

    public Reference(String selector, Environnement environnement) {
        this.selector = selector;
        this.environnement = environnement;

    }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public String getSelector() {
        return selector;
    }
    

    @Override
    public Object getValue() {
        try {
            return new BasicObjectAccessor(environnement).getValue(selector);
        } catch (Exception ex) {
            throw traiteException(ex);
        }
    }

    protected RuntimeException traiteException(Exception ex) {
        return new RuntimeException("Erreur d'accès a la variable avec le selector " + selector, ex);
    }
}
