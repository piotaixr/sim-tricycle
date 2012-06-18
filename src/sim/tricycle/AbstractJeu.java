/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle;

import java.util.ArrayList;
import sim.tricycle.mapping.CarteGlobalInterface;
import sim.tricycle.team.Team;

/**
 *
 * @author morgan
 */
public abstract class AbstractJeu {
    
    protected CarteGlobalInterface carte;
    protected ArrayList<Team> tabTeams;

    public void setCarte(CarteGlobalInterface carte) {
        this.carte = carte;
    }

    public void setTabTeams(ArrayList<Team> tabTeams) {
        this.tabTeams = tabTeams;
    }

    public CarteGlobalInterface getCarte() {
        return carte;
    }

    public ArrayList<Team> getTabTeams() {
        return tabTeams;
    }
    
    public void addTeam(Team t){
        tabTeams.add(t);
    }
    
}
