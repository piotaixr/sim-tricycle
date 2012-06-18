/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractActionComposee;
import sim.tricycle.utils.ActionBuilder;

/**
 *
 * @author Adri
 */
public class RevenirBase extends AbstractActionComposee {

    public RevenirBase(ActionBuilder builder) {
        super(builder);
    }

    @Override
    protected Object doExecute(Robot bot) {
        getBuilder().addNewReturn("trouvechemin", "chemin", getBuilder().buildReference("team.base"))
                .addNew("allera", getBuilder().buildVariable("chemin"));

        return null;
    }

    @Override
    public String getId() {
        return "revenirBase";
    }
}
