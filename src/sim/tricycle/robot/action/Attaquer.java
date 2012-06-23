/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import sim.tricycle.mapping.Case;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author marion DALLE mariondallesoulard@gmail.com
 * 
 * diminue les PV du robot en face de lui (si il n'est pas de la même équipe)
 * de la force d'attaque du robot en fonction de l'armure du robot adversaire
 */
public class Attaquer extends AbstractAction {

    @Override
    protected Object doExecute(Robot bot) {
        Case c = bot.getTeam().getMap().getCaseDevant(bot);
        Robot adversaire = c.getRobotPresent();
        if(adversaire.getTeam()==bot.getTeam()){
            throw new RuntimeException ("Attention ce robot est dans ton équipe");
        }
        adversaire.setPV((int)adversaire.getPV()-(bot.getPA()*(1-adversaire.getArmure()/100)));
        if(adversaire.getPV()<=0){
            bot.mourrir();
        }
        return null;
    }

    @Override
    public String getId() {
        return "attaquer";
    }
    
    
}
