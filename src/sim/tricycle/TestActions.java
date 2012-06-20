/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle;


import java.io.File;
import sim.tricycle.robot.Automate;
import sim.tricycle.robot.Robot;
import sim.tricycle.utils.ObjectBuilder;

/**
 *
 * @author Adri
 */
public class TestActions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObjectBuilder builder = new ObjectBuilder();
        
        Automate automate = builder.getRobotParser().parse(new File("./test_basique.xml"));
        
        Robot robot = new Robot(automate);
        System.out.println(automate.getEtat("init"));
        
        builder.getOrdonnanceur().add(robot);
        builder.getOrdonnanceur().start();
    }
}
