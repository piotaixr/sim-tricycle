/*
 */
package sim.tricycle;

import java.util.ArrayList;
import sim.tricycle.mapping.AbstractCarte;
import sim.tricycle.mapping.CarteObjective;
import sim.tricycle.team.Team;

/**
 * @author thomas
 * @author morgan
 */
public abstract class AbstractJeu {

    protected AbstractCarte carte;
    protected ArrayList<Team> tabTeams;
    protected int teamNumber = 0;

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public void setCarte(AbstractCarte carte) {
        this.carte = carte;
    }

    public void setTabTeams(ArrayList<Team> tabTeams) {
        this.tabTeams = tabTeams;
    }

    public AbstractCarte getCarte() {
        return carte;
    }

    public ArrayList<Team> getTabTeams() {
        return tabTeams;
    }

    public void addTeam(Team t) {
        tabTeams.add(t);
    }
}
