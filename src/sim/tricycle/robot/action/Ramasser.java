/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.elementCase.AbstractObjet;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;
import sim.tricycle.team.Ressource;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author marion
 */
public class Ramasser extends AbstractAction{
    
    private Variable varRessource;

    @Override
    protected Object doExecute(Robot bot) {
        Ressource r = (Ressource)varRessource.getValue();
        bot.getT().ajouterRessource(r.getItem());
        bot.getT().getMap().getCase(bot.getCoordonnees().getX(), bot.getCoordonnees().getY()).getItem().supprimerObjet();
    //    System.out.println("Ramassage: " + bot.getCoordonnees().getX()+" "+bot.getCoordonnees().getY());
        return null;
    }

    @Override
    public String getId() {
        return "ramasser";
    }
 
    public void setParameters(Variable varRessource){
        this.varRessource = varRessource;
    }

}
