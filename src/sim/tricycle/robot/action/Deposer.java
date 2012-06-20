/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;
import sim.tricycle.team.Ressource;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author marion
 */
public class Deposer extends AbstractAction{
    
   

    @Override
    protected Object doExecute(Robot bot) {
        
        if (bot.getItemPorte()==null)throw new RuntimeException ("le robot ne porte pas d'objet");
        
        Case c = bot.getTeam().getMap().getCase(bot.getCoordonnees().getX(), bot.getCoordonnees().getY());
        if (c.whoIam()== TypeCase.base){
            bot.getTeam().ajouterRessource(bot.getItemPorte().getId());
        }
        else {
            if (c.whoIam() == TypeCase.vide){
                bot.getTeam().getMap().pop(bot.getItemPorte(),c);                       
            }
            else throw new RuntimeException ("la case n'est pas vide et n'est pas une base on ne peut déposer quelque chose dessus");
        } 
        bot.setItemPorte(null);
        
    //    System.out.println("Ramassage: " + bot.getCoordonnees().getX()+" "+bot.getCoordonnees().getY());
        return null;
    }

    @Override
    public String getId() {
        return "deposer";
    }

}
