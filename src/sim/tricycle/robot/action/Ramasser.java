/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.Case;
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
    
    private AbstractObjet Item;
    
    @Override
    protected Object doExecute(Robot bot) {        
        if (bot.getItemPorte()!=null){
            throw new RuntimeException ("Le robot porte déjà un objet");                    
        }
        Case c = bot.getT().getMap().getCase(bot.getCoordonnees().getX(), bot.getCoordonnees().getY());
        bot.setItemPorte(c.getItem());
        c.getItem().supprimerObjet();
    //    System.out.println("Ramassage: " + bot.getCoordonnees().getX()+" "+bot.getCoordonnees().getY());
        return null;
    }

    @Override
    public String getId() {
        return "ramasser";
    }
 
    
}
