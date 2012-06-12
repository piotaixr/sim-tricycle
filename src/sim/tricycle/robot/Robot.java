package sim.tricycle.robot;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import sim.tricycle.Ordonnanceur.OrdonnancableInterface;
import sim.tricycle.mapping.Carte;
import sim.tricycle.mapping.elementCase.AbstractObstacle;
import sim.tricycle.robot.action.ActionInterface;
import sim.tricycle.team.Team;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public abstract class Robot extends AbstractObstacle implements OrdonnancableInterface {

    protected Point coordonnees;
    protected Sens direction;
    protected int portee;
    protected ArrayDeque<ActionInterface> actions = new ArrayDeque();
    protected Etat etatCourant;
    protected Etat etatDestination;
    protected Automate automate;
    protected Team equipe;
    protected Carte mapTeam;
    protected Carte mapObjective;
    /**
     * @todo Initialiser le robot avec l'etat initial de l'automate
     *
     * @param automate
     */
    public Robot(Automate automate, Team equipe) {
        this.automate = automate;
        this.equipe = equipe;
        this.mapTeam = equipe.getMap();

    }

    public Robot(Automate automate, Carte mapObjective) {
        this.automate = automate;
        this.mapObjective = mapObjective;
    }
    
    public Robot(Automate automate, Team equipe, Carte mapObjective) {
        this.automate = automate;
        this.mapObjective = mapObjective;
        this.equipe = equipe;
        this.mapTeam = equipe.getMap();
    }    
    
    public Robot(Carte mapObjective) {
        this.mapObjective = mapObjective;
    }
    
    public Robot(Team equipe) {
        this.automate = null;
        this.equipe = equipe;
        this.mapTeam = equipe.getMap();
    }

    public Point getCoordonnees() {
        return this.coordonnees;
    }

    public void setCoordonnees(Point newP) {
        this.coordonnees = newP;
    }

    public Sens getDirection() {
        return this.direction;
    }

    public void setDirection(Sens newDirection) {
        this.direction = newDirection;
    }

    public int getPortee() {
        return this.portee;
    }

    public void setPortee(int newPortee) {
        this.portee = newPortee;
    }

    public ArrayDeque<ActionInterface> getActions() {
        return actions;
    }

    public void setActions(ArrayDeque<ActionInterface> fileActions) {
        this.actions = fileActions;
    }

    public Etat getEtat() {
        return this.etatCourant;
    }

    public void setEtat(Etat newEtat) {
        this.etatCourant = newEtat;
    }

    public Team getTeam() {
        return this.equipe;
    }

    public Carte getMapTeam() {
        return this.mapTeam;
    }

    private void collerRobotSurMap(){
        this.mapObjective.getCase(this.coordonnees.getX(), this.coordonnees.getY()).setObstacle(this);
    }
    
    private void decollerRobotDeMap(){
        this.mapObjective.getCase(this.coordonnees.getX(), this.coordonnees.getY()).setObstacle(null);
    }
    
    @Override
    /**
     * Fonction appelée a chaque tick d'horloge
     *
     * @todo coder cette fonction
     */
    public void executeAction() {
        decollerRobotDeMap();
        if (actions.isEmpty()) {
            // liste actions vide, on change d'état
            etatCourant = etatDestination;
            // parcours des transitions
            List<Transition> transitions = etatCourant.getTransitions();
            Iterator<Transition> it = transitions.iterator();
            while (it.hasNext()) {
                Transition t = it.next();
                // si condition non valide, on passe à la suivante
                if (!t.getCondition().test()) {
                    continue;
                }
                //ajout des actions
                List<ActionInterface> newActions = t.getActions();
                actions.addAll(newActions);
                //on donne l'etat de destination
                etatDestination = t.getEtatDestination();
                break;
            }
        }
        collerRobotSurMap();
    }
}
