/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.elementCase.AbstractObjet;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;
import sim.tricycle.team.Ressource;

/**
 *
 * @author marion
 */
public class Ramasser extends AbstractAction{
    
    private Ressource ressource;

    @Override
    protected Object doExecute(Robot bot) {
        bot.getTeam().ajouterRessource(ressource.getItem());
        bot.getMapObjective().getCase(bot.getCoordonnees().getX(), bot.getCoordonnees().getY()).myItem().supprimerObjet();
    //    System.out.println("Ramassage: " + bot.getCoordonnees().getX()+" "+bot.getCoordonnees().getY());
        return null;
    }

    @Override
    public String getId() {
        return "ramasser";
    }
    
    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }
    
    public void setRessourceParItem(AbstractObjet ao){
        this.ressource = new Ressource();
        this.ressource.setItem(ao);
    }

}
