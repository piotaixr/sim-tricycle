/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils.params.types;

import sim.tricycle.Ordonnanceur.OrdonnancableInterface;
import sim.tricycle.Ordonnanceur.OrdonnanceurInterface;
import sim.tricycle.robot.Robot;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class Reference implements ReferenceInterface {

    private String selector;
    private OrdonnanceurInterface ordonnanceur;

    public Reference(String selector, OrdonnanceurInterface ordonnanceur) {
        this.selector = selector;
        this.ordonnanceur = ordonnanceur;

    }

    public Environnement getEnvironnement() {
        OrdonnancableInterface tache = ordonnanceur.getActiveTask();
        if(tache instanceof Robot)
            return ((Robot) tache).getEnvironnement();
        else return null;
    }

    public String getSelector() {
        return selector;
    }
    

    @Override
    public Object getValue() {
        try {
            return new BasicObjectAccessor(getEnvironnement()).getValue(selector);
        } catch (Exception ex) {
            throw traiteException(ex);
        }
    }

    protected RuntimeException traiteException(Exception ex) {
        return new RuntimeException("Erreur d'accès a la variable avec le selector " + selector, ex);
    }
}
