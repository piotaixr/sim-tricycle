package sim.tricycle.robot;

import sim.tricycle.mapping.Carte;
import sim.tricycle.team.Team;

/**
 *
 * @author Adri
 */
public class Collecteur extends Robot {

    public Collecteur(Automate automate, Team equipe) {
        super(automate, equipe);
    }

    public Collecteur(Team equipe) {
        super(equipe);
    }

    
    public Collecteur(Team equipe, Automate a) {
        super(equipe);
        this.automate = a;
        this.etatCourant = a.getEtat("1");
    }
}
