package sim.tricycle.utils;

import sim.tricycle.Ordonnanceur.Ordonnanceur;
import sim.tricycle.robot.action.*;
import sim.tricycle.robot.action.core.ActionFactory;
import sim.tricycle.robot.action.core.ActionFactoryInterface;
import sim.tricycle.robot.condition.*;
import sim.tricycle.robot.condition.core.ConditionFactory;
import sim.tricycle.robot.condition.core.ConditionFactoryInterface;
import sim.tricycle.robot.condition.multiple.ConditionEt;
import sim.tricycle.robot.condition.multiple.ConditionNon;
import sim.tricycle.robot.condition.multiple.ConditionOu;
import sim.tricycle.utils.params.ParamConverterProvider;
import sim.tricycle.utils.params.ParamConverterProviderInterface;
import sim.tricycle.utils.params.converter.*;
import sim.tricycle.utils.params.types.VarBuilder;
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
    private Ordonnanceur ordonnanceur = null;
    private ActionBuilder actionBuilder = null;
    private VarBuilder varBuilder = null;
    private ParameterCreator parameterCreator = null;
    
    public RobotParser getRobotParser() {
        if (parser == null) {
            parser = new RobotParser(getConditionFactory(), getParamConverterProvider(), getActionFactory(), getParameterCreator());
        }
        
        return parser;
    }
    
    public ConditionFactoryInterface getConditionFactory() {
        if (conditionFactory == null) {
            conditionFactory = new ConditionFactory(getParamConverterProvider(), getParameterCreator());
            conditionFactory.register(new ConditionTrue())
                    .register(new PieceTrouvee())
                    .register(new TestCaseRobotEgalCasePiece(getVarBuilder().buildReference("self.case"), getVarBuilder().buildVariable("piece")))
                    .register(new TestCaseRobotEgalCaseBase(getVarBuilder().buildReference("self.case"), getVarBuilder().buildReference("team.base")))
                    .register(new Contains())
                    .register(new PieceExiste(getOrdonnanceur()))
                    .register(new ConditionEt())
                    .register(new ConditionNon())
                    .register(new ConditionOu());
        }
        
        return conditionFactory;
    }
    
    public ActionFactoryInterface getActionFactory() {
        if (actionFactory == null) {
            actionFactory = new ActionFactory(getVarBuilder(), getParamConverterProvider(), getParameterCreator());
            actionFactory.register(new Avancer())
                 //   .register(new RamasserPiece())
                    .register(new Tourner())
                    .register(new AllerA(getActionBuilder()))
                    .register(new ArreterTout())
                    .register(new SeTeleporterA())
                    .register(new Sleep())
                    .register(new Ramasser())
                    .register(new Deposer())
                    .register(new PiecePlusProche())
                    .register(new TrouveChemin())
                    .register(new Collecter(getActionBuilder()))
                    .register(new RevenirBase(getActionBuilder()));
        }
        
        return actionFactory;
    }
    
    public ParamConverterProviderInterface getParamConverterProvider() {
        if (paramConverterProvider == null) {
            paramConverterProvider = new ParamConverterProvider();
            paramConverterProvider.register(new IntegerConverter())
                    .register(new StringConverter())
                    .register(new ReferenceConverter(getOrdonnanceur()))
                    .register(new VariableConverter(getOrdonnanceur()))
                    .register(new PointConverter());
        }
        
        return paramConverterProvider;
    }
    
    public Ordonnanceur getOrdonnanceur() {
        if (ordonnanceur == null) {
            ordonnanceur = new Ordonnanceur();
        }

        return ordonnanceur;
    }
    public VarBuilder getVarBuilder() {
        if (varBuilder == null) {
            varBuilder = new VarBuilder(getOrdonnanceur());
        }

        return varBuilder;
    }

    public ActionBuilder getActionBuilder() {
        if (actionBuilder == null) {
            actionBuilder = new ActionBuilder(getOrdonnanceur(), getParameterCreator(), getActionFactory());
        }

        return actionBuilder;
    }

    public ParameterCreator getParameterCreator() {
        if (parameterCreator == null) {
            parameterCreator = new ParameterCreator(getParamConverterProvider());
        }

        return parameterCreator;
    }
}
