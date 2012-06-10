/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import sim.tricycle.robot.action.Action;
import sim.tricycle.robot.action.ActionInterface;
import sim.tricycle.robot.condition.ConditionInterface;
import sim.tricycle.robot.condition.factory.ConditionFactoryInterface;
import sim.tricycle.utils.params.ParamConverterProviderInterface;

/**
 * @todo implementation non finie. Il doit rester des fonctions a ajouter
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class RobotParser {

    private ConditionFactoryInterface condifionFactory;
    private ParamConverterProviderInterface paramConverterProvider;

    public RobotParser(ConditionFactoryInterface condifionFactory, ParamConverterProviderInterface paramConverterProvider) {
        this.condifionFactory = condifionFactory;
        this.paramConverterProvider = paramConverterProvider;
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
        List<Element> etats = racine.getChildren("etat");
        creerEtats(etats, automate);

        Iterator<Element> it = etats.iterator();
        while (it.hasNext()) {
            Element elementEtat = it.next();
            String id = elementEtat.getAttributeValue("id");
            Etat e = automate.getEtat(id);
            addTransitions(e, elementEtat, automate);
        }

    }

    private void creerEtats(List<Element> etats, Automate automate) {
        Iterator<Element> it = etats.iterator();
        while (it.hasNext()) {
            Element e = it.next();
            String id = e.getAttributeValue("id");
            Etat etat = new Etat(id);
            automate.addEtat(etat);
        }
    }

    private void addTransitions(Etat e, Element elementEtat, Automate automate) {
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
 * @param t
 * @param elemTransition
 * @param automate 
 */
    private void ajouterActions(Transition t, Element elemTransition, Automate automate) {
        List<Element> actions = elemTransition.getChildren("action");
        Iterator<Element> it = actions.iterator();
        while (it.hasNext()) {
            Element actionelem = it.next();
            ActionInterface action = creerAction(actionelem);
        }
    }

    private ConditionInterface creerCondition(Element conditionTransitionElement) {
        String conditionNom = conditionTransitionElement.getAttributeValue("nom").trim();
        return condifionFactory.create(conditionNom, conditionTransitionElement.getChildren("parametre"));
    }

    private ActionInterface creerAction(Element actionelem) {
        ActionInterface action = null;
        
        
        return action;
    }
}
