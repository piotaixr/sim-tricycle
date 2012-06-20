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
import sim.tricycle.robot.action.core.AbstractAction;
import sim.tricycle.robot.action.core.AbstractActionComposee;
import sim.tricycle.utils.ActionBuilder;

/**
 *
 * @author Marion DALLE mariondallesoulard@gmail.com
 */
public class ConstructionEnCours extends AbstractAction {

  

    @Override
    protected Object doExecute(Robot bot) {

        Case c = bot.getTeam().getMap().getCaseDevant(bot);
        
        if (!c.hasObstacle())throw new RuntimeException("Pas de batiment");
        
        if (c.getObstacle() instanceof AbstractBatiment){
            AbstractBatiment bat = (AbstractBatiment) c.getObstacle();
            if (bat.getTemps() == 0) {
                bot.getTeam().supprimerRessource("Piece", bat.getPrix());
                bat.setTemps(bat.getTemps() + 1);
                bot.getTeam().getMap().getCaseDevant(bot).setObstacle(bat);
            } else {
            bat.setTemps(bat.getTemps() + 1);
            }
        }
        else throw new RuntimeException("Pas de batiment");
        return null;
    }

    @Override
    public String getId() {
        return "construction";
    }
}
