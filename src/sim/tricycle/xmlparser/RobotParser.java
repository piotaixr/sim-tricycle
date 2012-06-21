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
import sim.tricycle.robot.condition.core.AbstractConditionMultiple;
import sim.tricycle.robot.condition.core.ConditionInterface;
import sim.tricycle.utils.ParameterCreator;
import sim.tricycle.robot.condition.core.ConditionFactoryInterface;
import sim.tricycle.utils.params.ParamConverterProviderInterface;
import sim.tricycle.utils.params.Parameter;
import sim.tricycle.utils.tag.Tag;

/**
 * @todo implementation non finie. Il doit rester des fonctions a ajouter
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class RobotParser {

    private ConditionFactoryInterface condifionFactory;
    private ParamConverterProviderInterface paramConverterProvider;
    private ActionFactoryInterface actionFactory;
    private ParameterCreator parameterCreator;

    public RobotParser(ConditionFactoryInterface condifionFactory, ParamConverterProviderInterface paramConverterProvider, ActionFactoryInterface actionFactory, ParameterCreator parameterCreator) {
        this.condifionFactory = condifionFactory;
        this.paramConverterProvider = paramConverterProvider;
        this.actionFactory = actionFactory;
        this.parameterCreator = parameterCreator;
    }

    public Automate parse(File f) {
        Automate automate = new Automate();
        try {
             System.out.println("PARSER: fichier : " + f.getAbsolutePath());
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build(f);
            System.out.println("PARSER: fichier parsé");
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
        
        if(automate.getEtat("init") == null)
            throw new RuntimeException("Un automate doit obligatoirement définir un état initial de nom 'init'");

        parseTags(racine, automate);

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
            System.out.println("CREER ETAT: " + id);
            Etat etat = new Etat(id, automate);
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

    private ConditionInterface creerCondition(Element conditionElement) {
        if (conditionElement == null) {
            return condifionFactory.create("true");
        }
        String conditionNom = conditionElement.getAttributeValue("nom").trim();
        System.out.println("creerCondition /" + conditionNom + "/");

        String typeCondition = conditionElement.getAttributeValue("type");
        System.out.println("TYPE:" + typeCondition);
        if (typeCondition == null || typeCondition.trim().equals("simple")) {
            //condition simple
            List<Parameter> parametersList = parameterCreator.elementListToParameterList(conditionElement.getChildren("parametre"));
            return condifionFactory.create(conditionNom, parametersList);
        } else {
            System.out.println("conditionmultiple");
            //condition multiple
            ConditionInterface condition = condifionFactory.create(conditionNom);
            if(condition instanceof AbstractConditionMultiple){
                AbstractConditionMultiple acm = (AbstractConditionMultiple) condition;
                List<Element> listSousConditionElements = conditionElement.getChildren("condition");
                for(Element e:listSousConditionElements){
                    acm.addCondition(creerCondition(e));
                }
                return acm;
            } else {
                throw new RuntimeException("La condition de nom " + conditionNom + " n'est pas une condition multiple");
            }
        }
    }

    private ActionInterface creerAction(Element actionElement) {
        String actionNom = actionElement.getAttributeValue("nom").trim();
        List<Parameter> parametersList = parameterCreator.elementListToParameterList(actionElement.getChildren("parametre"));
        String variableDest = actionElement.getAttributeValue("dest");
        if (variableDest != null) {
            variableDest = variableDest.trim();
        }

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
            e.addTag(automate.getTag(nomTag));
        }
    }

    private void parseTags(Element racine, Automate automate) {
        List<Element> elemsTags = racine.getChildren("tag");
        for (Element elem : elemsTags) {
            String nomtag = elem.getAttributeValue("nom");
            Tag t = new Tag(nomtag);
            addActionCout(t, elem.getChildren("action"), automate);
            automate.addTag(t);
        }
    }

    private void addActionCout(Tag t, List<Element> children, Automate automate) {
        for (Element elem : children) {
            String actionNom = elem.getAttributeValue("nom");
            int value = Integer.parseInt(elem.getAttributeValue("val").trim());
            t.addValeur(actionNom, value);
        }
    }
}
