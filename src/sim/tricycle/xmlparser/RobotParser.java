package sim.tricycle.xmlparser;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import sim.tricycle.robot.Automate;
import sim.tricycle.robot.Etat;
import sim.tricycle.robot.Transition;
import sim.tricycle.robot.action.core.ActionFactoryInterface;
import sim.tricycle.robot.action.core.ActionInterface;
import sim.tricycle.robot.condition.core.ConditionInterface;
import sim.tricycle.utils.ParameterCreator;
import sim.tricycle.robot.condition.core.ConditionFactoryInterface;
import sim.tricycle.utils.params.ParamConverterProviderInterface;
import sim.tricycle.utils.params.Parameter;

/**
 * @todo implementation non finie. Il doit rester des fonctions a ajouter
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class RobotParser {

    private ConditionFactoryInterface condifionFactory;
    private ParamConverterProviderInterface paramConverterProvider;
    private ActionFactoryInterface actionFactory;
    private ParameterCreator parameterCreator = new ParameterCreator();

    public RobotParser(ConditionFactoryInterface condifionFactory, ParamConverterProviderInterface paramConverterProvider, ActionFactoryInterface actionFactory) {
        this.condifionFactory = condifionFactory;
        this.paramConverterProvider = paramConverterProvider;
        this.actionFactory = actionFactory;
    }

    public Automate parse(File f) {
        Automate automate = new Automate();
        try {
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build(f);

            Element racine = document.getRootElement();

            parseRobot(racine, automate);

        } catch (Exception ex) {
            throw new RuntimeException("Parse error :(", ex);
        }
        return automate;
    }

    private void parseRobot(Element racine, Automate automate) {
        System.out.println("parseRobot");
        List<Element> etats = racine.getChildren("etat");
        creerEtats(etats, automate);

        Iterator<Element> it = etats.iterator();
        while (it.hasNext()) {
            Element elementEtat = it.next();
            String id = elementEtat.getAttributeValue("id");
            Etat e = automate.getEtat(id);
            addTransitions(e, elementEtat, automate);
            addTags(e, elementEtat, automate);
        }

    }

    private void creerEtats(List<Element> etats, Automate automate) {
        System.out.println("creerEtats");
        Iterator<Element> it = etats.iterator();
        while (it.hasNext()) {
            Element e = it.next();
            String id = e.getAttributeValue("id");
            Etat etat = new Etat(id);
            automate.addEtat(etat);
        }
    }

    private void addTransitions(Etat e, Element elementEtat, Automate automate) {
        System.out.println("addTransitions");
        List<Element> transitions = elementEtat.getChildren("transition");
        Iterator<Element> it = transitions.iterator();
        while (it.hasNext()) {
            Element elemTransition = it.next();

            Element elemEtatDestination = elemTransition.getChild("etat");
            if (elemEtatDestination == null) {
                throw new DocumentMalformedException("etat");
            }
            String etatId = elemEtatDestination.getAttributeValue("id");
            Etat etatDestination = automate.getEtat(etatId);

            Element conditionTransitionElement = elemTransition.getChild("condition");
            ConditionInterface condition = creerCondition(conditionTransitionElement);

            Transition t = new Transition(e, etatDestination, condition);
            ajouterActions(t, elemTransition, automate);

            e.addTransition(t);
        }
    }

    /**
     * @todo Finir l'implementation de cette fonction
     *
     * @param t
     * @param elemTransition
     * @param automate
     */
    private void ajouterActions(Transition t, Element elemTransition, Automate automate) {
        System.out.println("ajouterActions");
        List<Element> actions = elemTransition.getChildren("action");
        Iterator<Element> it = actions.iterator();
        while (it.hasNext()) {
            Element actionelem = it.next();
            ActionInterface action = creerAction(actionelem);
            t.addAction(action);
        }
    }

    private ConditionInterface creerCondition(Element conditionTransitionElement) {
        if(conditionTransitionElement == null){
            return condifionFactory.create("true");
        }
        String conditionNom = conditionTransitionElement.getAttributeValue("nom").trim();
        System.out.println("creerCondition /" + conditionNom + "/");
        List<Parameter> parametersList = parameterCreator.toParameterList(conditionTransitionElement.getChildren("parametre"));

        return condifionFactory.create(conditionNom, parametersList);
    }

    private ActionInterface creerAction(Element actionElement) {
        String actionNom = actionElement.getAttributeValue("nom").trim();
        List<Parameter> parametersList = parameterCreator.toParameterList(actionElement.getChildren("parametre"));
        String variableDest = actionElement.getAttributeValue("dest");
        if(variableDest != null)
            variableDest = variableDest.trim();

        return actionFactory.create(actionNom, parametersList, variableDest);
    }

    private void addTags(Etat e, Element elementEtat, Automate automate) {
        List<Element> tags = elementEtat.getChildren("tag");
        Iterator<Element> it = tags.iterator();
        while (it.hasNext()) {
            Element tagElement = it.next();
            String nomTag = tagElement.getAttributeValue("nom").trim();
            if (nomTag.equals("")) {
                continue; // TODO: afficher un warning
            }
            e.addTag(nomTag);
        }
    }
}
