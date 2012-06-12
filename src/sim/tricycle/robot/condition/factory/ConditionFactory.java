package sim.tricycle.robot.condition.factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sim.tricycle.robot.condition.ConditionInterface;
import sim.tricycle.utils.AbstractFactory;
import sim.tricycle.utils.params.ParamConverterProviderInterface;
import sim.tricycle.utils.params.Parameter;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class ConditionFactory extends AbstractFactory<String, ConditionInterface> implements ConditionFactoryInterface {

    public ConditionFactory(ParamConverterProviderInterface paramConverterProvider) {
        super(paramConverterProvider);
    }

    @Override
    public ConditionInterface doCreate(String nom, List<Parameter> parameters) {
        ConditionInterface returnValue = null;
        try {
            ConditionInterface obj = getValues().get(nom);
            ConditionInterface clone = obj.clone();
            Class c = obj.getClass();

            Method method = c.getMethod("setParameters", toRequiredTypes(parameters));

            method.invoke(clone, toConvertedValues(parameters));

        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ConditionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ConditionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ConditionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ConditionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ConditionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ConditionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return returnValue;
    }
}
