package sim.tricycle.robot;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Stack;
import sim.tricycle.Ordonnanceur.OrdonnancableInterface;
import sim.tricycle.mapping.Carte;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.mapping.elementCase.AbstractObstacle;
import sim.tricycle.robot.action.Sleep;
import sim.tricycle.robot.action.core.AbstractActionComposee;
import sim.tricycle.robot.action.core.ActionInterface;
import sim.tricycle.team.Team;
import sim.tricycle.utils.params.types.Environnement;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public abstract class Robot extends AbstractObstacle implements OrdonnancableInterface {

    protected Environnement environnement = null;
    protected Point coordonnees;
    protected Sens direction;
    protected int portee;
    protected ArrayDeque<ActionInterface> actions = new ArrayDeque();
    protected Stack<AbstractActionComposee> pileActionsComposees = new Stack();
    protected Stack<ArrayDeque<ActionInterface>> pileFileActions = new Stack();
    protected Etat etatCourant;
    protected Etat etatDestination;
    protected Automate automate;
    protected Team equipe;
 
    /**
     * @todo Initialiser le robot avec l'etat initial de l'automate
     *
     * @param automate
     */
    public Robot(Automate automate, Team equipe) {
        this.automate = automate;
        this.equipe = equipe;
    }

    public Robot(Automate automate) {
        this.automate = automate;
    }

    public Robot(Team t) {
        this.equipe = t;
    }

    /**Retourne la case qui se trouve devant les robot*/

    

    public void collerRobotSurMap() {
        if (!this.getMapTeam().getCase(this.coordonnees.getX(), this.coordonnees.getY()).hasObstacle()) {
            this.getMapTeam().getCase(this.coordonnees.getX(), this.coordonnees.getY()).setObstacle(this);
        }
    }

    public void decollerRobotDeMap() {
        if (this.getMapTeam().getCase(this.coordonnees.getX(), this.coordonnees.getY()).hasObstacle()) {
            this.getMapTeam().getCase(this.coordonnees.getX(), this.coordonnees.getY()).suprObstacle();
        }
    }

      private Transition findTransition() {
        Iterator<Transition> it = etatCourant.getTransitions().iterator();
        Transition valide = null;
        System.out.println(etatCourant.getTransitions().size());
        while (valide == null && it.hasNext()) {
            Transition t = it.next();
            if (t.getCondition().test()) {
                valide = t;
            }
        }
        return valide;
    }

    /**
     * Fonction appelée a chaque tick d'horloge
     *
     * @todo coder cette fonction
     */
    @Override
    public void executeAction() {    

        if (!actions.isEmpty()) {
            if (actions.getFirst().isComposee()) {
                AbstractActionComposee a = (AbstractActionComposee) actions.pollFirst();
                pileActionsComposees.push(a);
                pileFileActions.push(actions);
                actions = new ArrayDeque();
                actions.addAll(a.getNewActions());
                this.executeAction();
            } else {
                actions.pollFirst().executer(this);
            }
        } else {
            if (!pileActionsComposees.isEmpty()) {
                actions.addAll(pileActionsComposees);
                pileActionsComposees.clear();
                this.executeAction();
            } else {
                if (etatDestination != null) {
                    System.out.println("change etat" + etatDestination.getId());
                    etatCourant = etatDestination;
                }
                Transition t = findTransition();
                if (t == null || t.getActions().isEmpty()) {
                    actions.add(new Sleep());
                }
                actions.addAll(t.getActions());
                etatDestination = t.getEtatDestination();
            }
        }
    }

    public Environnement getEnvironnement() {
        if (environnement == null) {
            environnement = new Environnement(equipe, this);
        }
        return environnement;
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
    
       public Automate getAutomate() {
        return automate;
    }

    public void setAutomate(Automate automate) {
        this.automate = automate;
    }

    public Team getEquipe() {
        return equipe;
    }

    public void setEquipe(Team equipe) {
        this.equipe = equipe;
    }

    public Etat getEtatDestination() {
        return etatDestination;
    }

    public void setEtatDestination(Etat etatDestination) {
        this.etatDestination = etatDestination;
    }
    
    public Carte getMapTeam(){
        return this.equipe.getMap();
    }
    
    @Override
    public TypeCase whoIam() {
        return (TypeCase.robot);
    }
}
