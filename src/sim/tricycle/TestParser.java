/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle;

import java.io.File;
import sim.tricycle.utils.ObjectBuilder;
import sim.tricycle.xmlparser.RobotParser;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class TestParser {

    public static void main(String[] args) {
        ObjectBuilder builder = new ObjectBuilder();


        RobotParser parser = builder.getRobotParser();

        //System.out.println("aaaa");
        //parser.parse(new File("./test_basique.xml"));
        parser.parse(new File("./test.xml"));
        //System.out.println("aaaa");
     //   parser.parse(new File("./test_basique.xml"));
        parser.parse(new File("./Automates/guerrier.xml"));

    }
}
