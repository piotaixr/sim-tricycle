/*
 */
package sim.tricycle;

import java.util.ArrayList;
import sim.tricycle.mapping.AbstractCarte;
import sim.tricycle.mapping.CarteObjective;
import sim.tricycle.team.Ressource;
import sim.tricycle.team.Team;

/**
 * @author thomas
 * @author morgan
 */
public abstract class AbstractJeu {

    protected CarteObjective carte;
    protected ArrayList<Team> tabTeams;
    protected int teamNumber = 0;
    protected ArrayList<Ressource> ressourcesDefaut = null;
    
    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public void setCarte(CarteObjective carte) {
        this.carte = carte;
    }

    public void setTabTeams(ArrayList<Team> tabTeams) {
        this.tabTeams = tabTeams;
    }

    public CarteObjective getCarte() {
        return carte;
    }

    public ArrayList<Team> getTabTeams() {
        return tabTeams;
    }

    public ArrayList<Ressource> getRessourcesDefaut() {
        return ressourcesDefaut;
    }

    public void addTeam(Team t) {
        if (t != null) {
            System.out.println("AAAAAAAAAAAAAAAAAaa");
        }
        tabTeams.add(t);
        
    }
}
