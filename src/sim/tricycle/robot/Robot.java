package sim.tricycle.robot;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Stack;
import sim.tricycle.Ordonnanceur.OrdonnancableInterface;
import sim.tricycle.mapping.CarteTeam;
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
    protected boolean plante = false;
    protected int cout = 0;

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

    /**
     * Retourne la case qui se trouve devant les robot
     *
     * @deprecated
     */
    public void collerRobotSurMap() {
        if (!this.getMapTeam().getCase(this.coordonnees.getX(), this.coordonnees.getY()).hasObstacle()) {
            this.getMapTeam().getCase(this.coordonnees.getX(), this.coordonnees.getY()).setObstacle(this);
        }
    }

    /**
     * @deprecated
     */
    public void decollerRobotDeMap() {
        if (this.getMapTeam().getCase(this.coordonnees.getX(), this.coordonnees.getY()).hasObstacle()) {
            this.getMapTeam().getCase(this.coordonnees.getX(), this.coordonnees.getY()).suprObstacle();
        }
    }

    private Transition findTransition() {
        Iterator<Transition> it = etatCourant.getTransitions().iterator();
        Transition valide = null;
        while (valide == null && it.hasNext()) {
            Transition t = it.next();
            if (t.getCondition().test()) {
                System.out.println("Robot: transition choisie. Condition: " + t.getCondition().getId());
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
    public void tick() {
        if (plante) {
            System.out.println("Robot planté!");
            new Sleep().executer(this);
            return;
        }
        // l'action coute plus d'un toc, le robot doit attendre
        if (cout > 0) {
            cout--;
            return;
        }
        //dans le cas ou il n'a pas a attendre, on cherche l'action a executer. 
        //On boucle tant que l'on n'execute des actions qui ne coutent rien.
        while (cout == 0) {
            if (!actions.isEmpty()) {
                //si il y aune action, on depile l'action
                if (actions.getFirst().isComposee()) {
                    //si composée on sauvegarde le contexte
                    AbstractActionComposee a = (AbstractActionComposee) actions.pollFirst();
                    //sauvegarde du contexte
                    pileActionsComposees.push(a);
                    pileFileActions.push(actions);
                    actions = new ArrayDeque();

                    //on execute et on récupère les actions générées
                    executerAction(a);
                } else {
                    //si simple, on execute simplement
                    executerAction(actions.pollFirst());
                }
            } else {
                //si file action vide
                if (!pileActionsComposees.isEmpty()) {
                    //fin d'une action composée -> rechargement du contexte: on depile
                    pileActionsComposees.pop();
                    actions = pileFileActions.pop();
                } else {
                    //actions vides, il faut changer d'etat et trouver une transition a prendre
                    if (etatDestination != null) {
                        System.out.println("change etat" + etatDestination.getId());
                        etatCourant = etatDestination;
                    }
                    Transition t = findTransition();
                    if (t == null) {
                        //si on ne trouve pas de transition, on ajoute une action vide de cout 1: sleep
                        cout++;
                    }
                    // transition trouvée. On récupère les actions a executer ainsi que l'etet de destination
                    actions.addAll(t.getActions());
                    etatDestination = t.getEtatDestination();
                }
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

    public CarteTeam getMapTeam() {
        return this.equipe.getMap();
    }

    @Override
    public TypeCase whoIam() {
        return (TypeCase.robot);
    }

    private void executerAction(ActionInterface action) {
        try {
            action.executer(this);
            cout = action.getPoids();
            if (action instanceof AbstractActionComposee) {
                actions.addAll(((AbstractActionComposee) action).getNewActions());
            }
        } catch (Exception e) {//erreur lors de l'execution de l'action
            /*
             * Si action composée empilée, on vide la file et on relance SAUF SI
             * ON PLANTE LORS DU LANCEMENT D'UNE ACTION COMPOSEE
             */
            if (pileActionsComposees.isEmpty()) {
                //on plante
                plante = true;
                return;
            }
            //si action composee au sommet de la pile est l'action qui a planté, on la depile.
            if (pileActionsComposees.peek() == action) {
                pileActionsComposees.pop();
                actions = pileFileActions.pop();
            }
            //si il n'y a plus d'actions composées, on plante
            if (pileActionsComposees.isEmpty()) {
                //on plante
                plante = true;
                return;
            }
            //ICI, on a une action comp a relancer

            actions.clear();
            AbstractActionComposee acomp = pileActionsComposees.peek();
            acomp.relaunch();
            actions.addAll(acomp.getNewActions());
        }
    }
}
