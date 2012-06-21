/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.Case;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *@author Marion DALLE mariondallesoulard@gmail.com
 * 
 * Augmente l'armure du robot de 10% et diminue la force de son attaque de 10% aussi seulement durant cette action
 */
public class Defendre extends AbstractAction{

    @Override
    protected Object doExecute(Robot bot) {
        
        Case c = bot.getTeam().getMap().getCaseDevant(bot);
        
        Robot adversaire = c.getRobotPresent();
        if(adversaire.getTeam()==bot.getTeam()){
            throw new RuntimeException ("Attention ce robot est dans ton équipe");
        }
        
        bot.setArmure(bot.getArmure()+10);
        
        adversaire.setPV((int)(adversaire.getPV()-(bot.getPA()*(0.10)*(adversaire.getArmure()/100))));
        if(adversaire.getPV()<=0){
            bot.getTeam().getMap().supprimer(adversaire, c);
        }
        
        return null;
    }

    @Override
    public String getId() {
        return "defense";
    }
    
}
