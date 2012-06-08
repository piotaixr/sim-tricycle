/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim.tricycle.xmlparser;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class RobotParser {

    
    public Object parse(File f){
        Object retour = null;
        try {
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build(f);
            
            Element e = document.getRootElement();
            
            
        } catch (JDOMException ex) {
            Logger.getLogger(RobotParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RobotParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retour;
    }
}
