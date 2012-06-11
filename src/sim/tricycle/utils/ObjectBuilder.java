/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils;

import sim.tricycle.robot.condition.ConditionTrue;
import sim.tricycle.robot.condition.factory.ConditionFactory;
import sim.tricycle.robot.condition.factory.ConditionFactoryInterface;
import sim.tricycle.utils.params.IntegerConverter;
import sim.tricycle.utils.params.ParamConverterProvider;
import sim.tricycle.utils.params.ParamConverterProviderInterface;
import sim.tricycle.utils.params.StringConverter;
import sim.tricycle.xmlparser.RobotParser;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class ObjectBuilder {

    private RobotParser parser = null;
    private ConditionFactoryInterface conditionFactory = null;
    private ParamConverterProviderInterface paramConverterProvider = null;

    public RobotParser getRobotParser() {
        if (parser == null) {
            parser = new RobotParser(getConditionFactory(), getParamConverterProvider());
        }

        return parser;
    }

    public ConditionFactoryInterface getConditionFactory() {
        if (conditionFactory == null) {
            conditionFactory = new ConditionFactory(getParamConverterProvider());
            conditionFactory.registerCondition(new ConditionTrue());
        }

        return conditionFactory;
    }

    public ParamConverterProviderInterface getParamConverterProvider() {
        if (paramConverterProvider == null) {
            paramConverterProvider = new ParamConverterProvider();
            paramConverterProvider.register(new IntegerConverter());
            paramConverterProvider.register(new StringConverter());
        }

        return paramConverterProvider;
    }
}
