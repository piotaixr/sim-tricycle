/*
 */
package sim.tricycle;

import java.util.ArrayList;
import sim.tricycle.mapping.CarteObjective;
import sim.tricycle.team.Ressource;
import sim.tricycle.team.Team;
import sim.tricycle.utils.ObjectBuilder;

/**
 * @author thomas
 * @author morgan
 */
public abstract class AbstractJeu {

    protected CarteObjective carte;
    protected ArrayList<Team> tabTeams;
    protected int teamNumber = 0;
    protected ArrayList<Ressource> ressourcesDefaut = null;
    protected ObjectBuilder ob;

    public int getTeamNumber() {
        return teamNumber;
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

    public ObjectBuilder getObjectBuilder() {
        return ob;
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

    public void setObjectBuilder(ObjectBuilder o) {
        this.ob = o;
    }

    public void addTeam(Team t) {
        if (t != null) {
            System.out.println("Nouvelle Team");
        }
        tabTeams.add(t);

    }
}
