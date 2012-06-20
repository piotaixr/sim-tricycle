/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.mapping.elementCase.AbstractObstacle;
import sim.tricycle.mapping.elementCase.Tour;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author marion
 */
public class InitialisationConstruction extends AbstractAction {

    private String nomBatiment;

    @Override
    protected Object doExecute(Robot bot) {

        Case c = bot.getTeam().getMap().getCaseDevant(bot);
        if (c.whoIam() == TypeCase.vide) {
            c.setObstacle(getBatimentFromNom());
        } else {
            throw new RuntimeException("la case n'est pas vide, la construction ne devrait pas etre possible");
        }

        return c.getObstacle();
    }

    public void setParameters(String nomBatiment) {
        this.nomBatiment = nomBatiment;
    }

    @Override
    public String getId() {
        return "initialisation construction";
    }

    private AbstractObstacle getBatimentFromNom() {
        return new Tour();
    }
}
