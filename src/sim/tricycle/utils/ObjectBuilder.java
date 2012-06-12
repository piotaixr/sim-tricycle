package sim.tricycle.utils;

import sim.tricycle.robot.action.core.ActionFactory;
import sim.tricycle.robot.action.core.ActionFactoryInterface;
import sim.tricycle.robot.condition.ConditionTrue;
import sim.tricycle.robot.condition.core.ConditionFactory;
import sim.tricycle.robot.condition.core.ConditionFactoryInterface;
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
    private ActionFactoryInterface actionFactory = null;
    private ParamConverterProviderInterface paramConverterProvider = null;

    public RobotParser getRobotParser() {
        if (parser == null) {
            parser = new RobotParser(getConditionFactory(), getParamConverterProvider(), getActionFactory());
        }

        return parser;
    }

    public ConditionFactoryInterface getConditionFactory() {
        if (conditionFactory == null) {
            conditionFactory = new ConditionFactory(getParamConverterProvider());
            conditionFactory.register(new ConditionTrue());
        }

        return conditionFactory;
    }

    public ActionFactoryInterface getActionFactory() {
        if (actionFactory == null) {
            actionFactory = new ActionFactory(getParamConverterProvider());
        }

        return actionFactory;
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
