/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import java.util.LinkedList;
import sim.tricycle.robot.Noeud;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractActionComposee;
import sim.tricycle.utils.ActionBuilder;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class Step extends AbstractActionComposee {
    
    private Variable varChemin;

    public Step(ActionBuilder builder) {
        super(builder);
    }

    @Override
    protected Object doExecute(Robot bot) {
        LinkedList<Noeud> chemin = (LinkedList<Noeud>) varChemin.getValue();
        Noeud n = chemin.pollFirst();
        getBuilder().addNew("sedeplacerunecase", n.getPoint());
        
        return null;
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
