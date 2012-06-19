/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;
import sim.tricycle.team.Ressource;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author marion
 */
public class Deposer extends AbstractAction{
    
    private Variable varRessource;

    @Override
    protected Object doExecute(Robot bot) {
        Ressource r = (Ressource)varRessource.getValue();
        bot.getEquipe().ajouterRessource(r.getIdItem());
        bot.getMapTeam().getCase(bot.getCoordonnees().getX(), bot.getCoordonnees().getY()).getItem().supprimerObjet();
    //    System.out.println("Ramassage: " + bot.getCoordonnees().getX()+" "+bot.getCoordonnees().getY());
        return null;
    }

    @Override
    public String getId() {
        return "deposer";
    }

}
