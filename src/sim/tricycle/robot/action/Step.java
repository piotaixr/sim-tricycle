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
        Noeud n = chemin.pollLast();
        getBuilder().addNew("sedeplacerunecase", n.getPoint());
        
        return null;
    }
    
    public void setParameters(Variable varChemin){
        this.varChemin = varChemin;
    }

    @Override
    public String getId() {
        return "step";
    }
}
