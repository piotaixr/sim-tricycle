/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot;

import sim.tricycle.team.Team;

/**
 *
 * @author Adri
 */
public class Collecteur extends Robot{

    public Collecteur(Automate automate,Team equipe) {
        super(automate,equipe);
    }
    
    public Collecteur(Team equipe){
        super(equipe);
    }
}
