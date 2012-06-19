/*
 */
package sim.tricycle;

import java.io.File;
import java.util.TimerTask;
import sim.tricycle.robot.Automate;
import sim.tricycle.utils.ObjectBuilder;
import sim.tricycle.xmlparser.RobotParser;

/**
 *
 * @author nell
 */
public class TestReference {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestReference tr = new TestReference();
        //MapTest cr = new MapTest();
        // Carte c = cr.getCarte();
        ObjectBuilder ob = new ObjectBuilder();
        RobotParser parser = ob.getRobotParser();
        Automate a = parser.parse(new File("./test_basique.xml"));

    }
}
