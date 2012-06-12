package sim.tricycle.robot.action.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sim.tricycle.robot.condition.core.ConditionInterface;
import sim.tricycle.utils.AbstractFactory;
import sim.tricycle.utils.params.ParamConverterProviderInterface;
import sim.tricycle.utils.params.Parameter;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class ActionFactory extends AbstractFactory<String, ActionInterface> implements ActionFactoryInterface {

    public ActionFactory(ParamConverterProviderInterface paramConverterProvider) {
        super(paramConverterProvider);
    }

    @Override
    public ActionInterface doCreate(String nom, List<Parameter> parameters) {
        ActionInterface returnValue = null;
        try {
            ActionInterface obj = getValues().get(nom);
            returnValue = obj.clone();
            Class c = obj.getClass();

            Method method = c.getMethod("setParameters", toRequiredTypes(parameters));

            method.invoke(returnValue, toConvertedValues(parameters));

        } catch (Exception ex) {
            throw traiteException(ex);
        }

        return returnValue;
    }

    @Override
    public ActionInterface create(String nom, List<Parameter> parameters, String nomVariableDest) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
