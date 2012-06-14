package sim.tricycle.robot;

import java.util.ArrayDeque;
import java.util.Stack;
import sim.tricycle.Ordonnanceur.OrdonnancableInterface;
import sim.tricycle.mapping.Carte;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.mapping.elementCase.AbstractObstacle;
import sim.tricycle.robot.action.core.AbstractAction;
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
    protected ArrayDeque<AbstractAction> actions = new ArrayDeque();
    protected Stack<AbstractAction> pileActions = new Stack();
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

    public Robot(Team t, Carte mapObjective) {
        this.equipe = t;
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

    public ArrayDeque<AbstractAction> getActions() {
        return actions;
    }

    public void setActions(ArrayDeque<AbstractAction> fileActions) {
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

    public Carte getMapObjective() {
        return mapObjective;
    }

    /**
     * @deprecated
     */
    public void collerRobotSurMap() {
        if (!this.mapObjective.getCase(this.coordonnees.getX(), this.coordonnees.getY()).hasObstacle()) {
            this.mapObjective.getCase(this.coordonnees.getX(), this.coordonnees.getY()).setObstacle(this);
        }
    }

    /**
     * @deprecated
     */
    public void decollerRobotDeMap() {
        if (this.mapObjective.getCase(this.coordonnees.getX(), this.coordonnees.getY()).hasObstacle()) {
            this.mapObjective.getCase(this.coordonnees.getX(), this.coordonnees.getY()).suprObstacle();
        }
    }

    /**
     * @deprecated
     */
    @Override
    public TypeCase whoIam() {
        return (TypeCase.robot);
    }

    /**
     * Fonction appelée a chaque tick d'horloge
     *
     * @todo coder cette fonction
     */
    public void executeAction() {
//        if (actions.isEmpty()) {
//            // liste actions vide, on change d'état
//            etatCourant = etatDestination;
//            // parcours des transitions
//            List<Transition> transitions = etatCourant.getTransitions();
//            Iterator<Transition> it = transitions.iterator();
//            while (it.hasNext()) {
//                Transition t = it.next();
//                // si condition non valide, on passe à la suivante
//                if (!t.getCondition().test()) {
//                    continue;
//                }
//                //ajout des actions
//                List<ActionInterface> newActions = t.getActions();
//                actions.addAll(newActions);
//                //on donne l'etat de destination
//                etatDestination = t.getEtatDestination();
//                break;
//            }
//        }      
       
        if(!actions.isEmpty()){
          if(actions.getFirst().isComposee()){
              AbstractActionComposee a = (AbstractActionComposee)actions.pollFirst();
              pileActions.addAll(actions);
              actions.clear();
              actions.addAll(a.getSuiteActions());
              this.executeAction();
          }else{
              actions.pollFirst().executer(this);
          }
        }else{
            if(!pileActions.isEmpty()){
                actions.addAll(pileActions);
                pileActions.clear();
                this.executeAction();
            }
        }
    }

    public Environnement getEnvironnement() {
        if (environnement == null) {
            environnement = new Environnement(getTeam(), this);
        }
        return environnement;
    }
}
