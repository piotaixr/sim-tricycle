package sim.tricycle.robot.action.core;

import java.lang.reflect.Method;
import java.util.List;
import sim.tricycle.utils.AbstractFactory;
import sim.tricycle.utils.ParameterCreator;
import sim.tricycle.utils.params.ParamConverterProviderInterface;
import sim.tricycle.utils.params.Parameter;
import sim.tricycle.utils.params.types.VarBuilder;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class ActionFactory extends AbstractFactory<String, ActionInterface> implements ActionFactoryInterface {

    private VarBuilder varBuilder;

    public ActionFactory(VarBuilder varBuilder, ParamConverterProviderInterface paramConverterProvider, ParameterCreator parameterCreator) {
        super(paramConverterProvider, parameterCreator);
        this.varBuilder = varBuilder;
    }

    @Override
    public ActionInterface doCreate(String nom, List<Parameter> parameters) {
        ActionInterface returnValue = null;
        try {
            ActionInterface obj = getValues().get(nom);
            returnValue = obj.clone();
            Class c = obj.getClass();

            Method method = c.getMethod("setParameters", getParameterCreator().toRequiredTypes(parameters));

            method.invoke(returnValue, getParameterCreator().toConvertedValues(parameters));

        } catch (Exception ex) {
            throw traiteException(ex);
        }

        return returnValue;
    }

    @Override
    public ActionInterface create(String nom, List<Parameter> parameters, String nomVariableDest) {
        ActionInterface action = super.create(nom, parameters);
        if (nomVariableDest != null) {
            action.setVariableDestination(varBuilder.buildVariable(nomVariableDest.trim()));
        }
        return action;
    }
}
