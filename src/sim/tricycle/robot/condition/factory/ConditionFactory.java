/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.condition.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Element;
import sim.tricycle.robot.condition.ConditionInterface;
import sim.tricycle.robot.condition.ParameterCreator;
import sim.tricycle.utils.params.ParamConverterProviderInterface;
import sim.tricycle.utils.params.Parameter;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class ConditionFactory implements ConditionFactoryInterface {

    private HashMap<String, ConditionInterface> conditions = new HashMap<String, ConditionInterface>();
    private ParamConverterProviderInterface paramConverterProvider;

    public ConditionFactory(ParamConverterProviderInterface paramConverterProvider) {
        this.paramConverterProvider = paramConverterProvider;
    }

    
    @Override
    public ConditionInterface create(String nom, List<Parameter> parameters) {
        ConditionInterface returnValue = null;
        try {
            if (!conditions.containsKey(nom)) {
                throw new RuntimeException("La condition de nom " + nom + " n'existe pas ou n'est pas enregistrée auprès du système.");
            }

            Class c = conditions.get(nom).getClass();

            Constructor construct = c.getConstructor(toRequiredTypes(parameters));

            returnValue = (ConditionInterface) construct.newInstance(toConvertedValues(parameters));

            return null;
        } catch (InstantiationException ex) {
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

    @Override
    public void registerConditions(Collection<ConditionInterface> conditions) {
        for (ConditionInterface c : conditions) {
            registerCondition(c);
        }
    }

    @Override
    public void registerCondition(ConditionInterface condition) {
        if (conditions.containsKey(condition.getName())) {
            throw new RuntimeException("Une condition doit avoir un nom unique: " + condition.getName());
        }

        conditions.put(condition.getName(), condition);
    }

    private Class[] toRequiredTypes(List<Parameter> parameters) {
        int nombre = parameters.size();
        Class[] types = new Class[nombre];
        int i = 0;
        Iterator<Parameter> it = parameters.iterator();
        while (it.hasNext()) {
            Parameter param = it.next();

            types[i++] = paramConverterProvider.get(param.getType()).getOutputClass();
        }

        return types;
    }

    private Object[] toConvertedValues(List<Parameter> parameters) {
        int nombre = parameters.size();
        Object[] values = new Object[nombre];
        int i = 0;
        Iterator<Parameter> it = parameters.iterator();
        while (it.hasNext()) {
            Parameter param = it.next();

            values[i++] = paramConverterProvider.get(param.getType()).convert(param.getValue());
        }

        return values;
    }
}
