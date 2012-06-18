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
    protected Stack<ArrayDeque<AbstractAction>> pileActions = new Stack();
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
    
    /**
     * Fonction appelée a chaque tick d'horloge
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
              pileActions.add(actions);
              actions=new ArrayDeque<AbstractAction>();
              actions.addAll(a.getSuiteActions());
              this.executeAction();
          }else{
              actions.pollFirst().executer(this);
          }
        }else{
            if(!pileActions.isEmpty()){
                actions.addAll(pileActions.pop());
                pileActions.clear();
                this.executeAction();
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

    public Stack<ArrayDeque<AbstractAction>> getPileActions() {
        return pileActions;
    }

    public void setPileActions(Stack<ArrayDeque<AbstractAction>> pileActions) {
        this.pileActions = pileActions;
    }
    
    public Carte getMapTeam(){
        return this.equipe.getMap();
    }
    
    @Override
    public TypeCase whoIam() {
        return (TypeCase.robot);
    }
}
