/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import sim.tricycle.Ordonnanceur.OrdonnanceurInterface;
import sim.tricycle.robot.action.core.ActionFactoryInterface;
import sim.tricycle.robot.action.core.ActionInterface;
import sim.tricycle.utils.params.Parameter;
import sim.tricycle.utils.params.types.VarBuilder;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class ActionBuilder extends VarBuilder {

    private Deque<ActionInterface> actions = new ArrayDeque<ActionInterface>();
    private ParameterCreator parameterCreator;
    private ActionFactoryInterface actionFactory;

    public ActionBuilder(OrdonnanceurInterface ordonnanceur, ParameterCreator parameterCreator, ActionFactoryInterface actionFactory) {
        super(ordonnanceur);
        this.parameterCreator = parameterCreator;
        this.actionFactory = actionFactory;
    }

    public ActionBuilder addNew(String actionNom, Object... paramsArray) {
        List<Parameter> params = parameterCreator.arrayParameterToParameterList(paramsArray);
        actions.add(actionFactory.create(actionNom, params));

        return this;
    }

    public ActionBuilder addNew(String actionNom, String varDestNom, Object... paramsArray) {
        List<Parameter> params = parameterCreator.arrayParameterToParameterList(paramsArray);
        actions.add(actionFactory.create(actionNom, params, varDestNom));

        return this;
    }

    public Deque<ActionInterface> getActions() {
        return actions;
    }
}
