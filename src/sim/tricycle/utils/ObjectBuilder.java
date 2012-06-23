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
    private static Ordonnanceur ordonnanceur = null;
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
            conditionFactory
                    .register(new BouleExiste(getOrdonnanceur()))
                    .register(new CaseObscureExiste(getOrdonnanceur()))
                    .register(new ConditionEt())
                    .register(new ConditionNon())
                    .register(new ConditionOu())
                    .register(new ConditionTrue())
                    .register(new Contains())
                    .register(new EnnemiDevant(getOrdonnanceur()))
                    .register(new NonVide())
                    .register(new PieceExiste(getOrdonnanceur()))
                    .register(new PtControleTrouve(getOrdonnanceur()))
                    .register(new PvNecessaires(getOrdonnanceur()))
                    .register(new TestCaseRobotEgalCaseBase(getVarBuilder().buildReference("self.case"), getVarBuilder().buildReference("team.base")))
                    .register(new TestCaseRobotEgalCasePiece(getVarBuilder().buildReference("self.case"), getVarBuilder().buildVariable("piece")));
        }
        
        return conditionFactory;
    }
    
    public ActionFactoryInterface getActionFactory() {
        if (actionFactory == null) {
            actionFactory = new ActionFactory(getVarBuilder(), getParamConverterProvider(), getParameterCreator());
            actionFactory
                    .register(new AllerIci(getActionBuilder()))
                    .register(new ArreterTout())
                    .register(new Attaquer())
                    .register(new Avancer())
                    .register(new BoulePlusProche())
                    .register(new CaseObscurePlusProche())
                    .register(new Collecter(getActionBuilder()))
                    .register(new CollecterPiecesEnContinu(getActionBuilder()))
                    .register(new Construction(getActionBuilder()))
                    .register(new ConstructionApInit(getActionBuilder()))
                    .register(new ConstructionEnCours())
                    .register(new Defendre())
                    .register(new Deposer())
                    .register(new Destruction())
                    .register(new DestructionTotale(getActionBuilder()))
                    .register(new InitialisationConstruction())
                    .register(new PiecePlusProche())
                    .register(new PtDeControlIdeal())
                    .register(new Ramasser())
                    .register(new RevenirBase(getActionBuilder()))
                    .register(new RobotDevant())
                    .register(new SeDeplacerUneCase(getActionBuilder()))
                    .register(new SeTeleporterA())
                    .register(new Sleep())
                    .register(new Step(getActionBuilder()))
                    .register(new SuivreChemin(getActionBuilder()))
                    .register(new Tourner())
                    .register(new TrouveCaseDevant())
                    .register(new TrouveChemin())
                    .register(new TrouveCollectable())
                    .register(new TrouveDirection())
                    .register(new TrouveZone());
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
    
    public static Ordonnanceur getOrdonnanceur() {
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
            return new ActionBuilder(getOrdonnanceur(), getParameterCreator(), getActionFactory());
    }

    public ParameterCreator getParameterCreator() {
        if (parameterCreator == null) {
            parameterCreator = new ParameterCreator(getParamConverterProvider());
        }

        return parameterCreator;
    }
}
