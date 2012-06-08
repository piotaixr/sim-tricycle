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

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class RobotParser {

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
        createEtats(etats, automate);
        
        Iterator<Element> it = etats.iterator();
        while(it.hasNext()){
            Element elementEtat = it.next();
            int id = Integer.parseInt(elementEtat.getAttributeValue("id"));
            Etat e = automate.getEtat(id);
            addTransitions(e, elementEtat, automate);
        }
        
    }

    private void createEtats(List<Element> etats, Automate automate) {
        Iterator<Element> it = etats.iterator();
        while(it.hasNext()){
            Element e = it.next();
            int id = Integer.parseInt(e.getAttributeValue("id"));
            Etat etat = new Etat(id);
            automate.addEtat(etat);
        }
    }

    private void addTransitions(Etat e, Element elementEtat, Automate automate) {
        List<Element> transitions = elementEtat.getChildren("transition");
        
    }
}
