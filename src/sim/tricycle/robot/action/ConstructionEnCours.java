/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.elementCase.AbstractBatiment;
import sim.tricycle.mapping.elementCase.AbstractObjet;
import sim.tricycle.mapping.elementCase.Piece;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractActionComposee;
import sim.tricycle.utils.ActionBuilder;

/**
 *
 * @author Marion DALLE mariondallesoulard@gmail.com
 */
public class ConstructionEnCours extends AbstractActionComposee {

    public ConstructionEnCours(ActionBuilder builder) {
        super(builder);
    }

    @Override
    protected Object doExecute(Robot bot) {

        Case c = bot.getMapTeam().getCaseDevant(bot);
        AbstractBatiment bat = (AbstractBatiment) c.getObstacle();

        if (bat.getTemps() == 0) {
            bot.getEquipe().supprimerRessource("Piece", bat.getPrix());
            bat.setTemps(bat.getTemps() + 1);
            bot.getMapTeam().getCaseDevant(bot).setObstacle(bat);
        } else {
            bat.setTemps(bat.getTemps() + 1);
        }
        return null;
    }

    @Override
    public String getId() {
        return "construction";
    }
}
