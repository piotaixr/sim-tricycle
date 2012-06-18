package sim.tricycle.robot.condition.core;

import java.lang.reflect.Method;
import java.util.List;
import sim.tricycle.utils.AbstractFactory;
import sim.tricycle.utils.ParameterCreator;
import sim.tricycle.utils.params.ParamConverterProviderInterface;
import sim.tricycle.utils.params.Parameter;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class ConditionFactory extends AbstractFactory<String, ConditionInterface> implements ConditionFactoryInterface {

    public ConditionFactory(ParamConverterProviderInterface paramConverterProvider, ParameterCreator parameterCreator) {
        super(paramConverterProvider, parameterCreator);
    }



    @Override
    public ConditionInterface doCreate(String nom, List<Parameter> parameters) {
        ConditionInterface returnValue = null;
        try {
            ConditionInterface obj = getValues().get(nom);
            returnValue = obj.clone();
            Class c = obj.getClass();

            Method method = c.getMethod("setParameters", getParameterCreator().toRequiredTypes(parameters));

            method.invoke(returnValue, getParameterCreator().toConvertedValues(parameters));

        } catch (Exception ex) {
            throw traiteException(ex);
        }

        return returnValue;
    }
}
