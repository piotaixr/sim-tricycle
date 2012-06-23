package sim.tricycle.robot;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Stack;
import sim.tricycle.Ordonnanceur.OrdonnancableInterface;
import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.mapping.elementCase.AbstractObjet;
import sim.tricycle.mapping.elementCase.AbstractVision;
import sim.tricycle.robot.action.Sleep;
import sim.tricycle.robot.action.core.AbstractActionComposee;
import sim.tricycle.robot.action.core.ActionInterface;
import sim.tricycle.team.Team;
import sim.tricycle.utils.params.types.Environnement;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Robot extends AbstractVision implements OrdonnancableInterface {

    protected Environnement environnement = null;
    protected Point coordonnees;
    protected Sens direction = Sens.NORD;
    protected ArrayDeque<ActionInterface> actions = new ArrayDeque();
    protected Stack<AbstractActionComposee> pileActionsComposees = new Stack();
    protected Stack<ArrayDeque<ActionInterface>> pileFileActions = new Stack();
    protected Etat etatCourant;
    protected Etat etatDestination;
    protected Automate automate;
    protected boolean plante = false;
    protected AbstractObjet ItemPorte = null;
    protected int tempsConstruction = 3;//arbitrarire
    protected int armure = 0;
    protected int PV = 42;
    protected int PA = 10;
    protected String imgBase;

    public String getImgBase() {
        return imgBase;
    }

    public void setImgBase(String imgBase) {
        this.imgBase = imgBase;
    }

    public int getArmure() {
        return armure;
    }

    public void setArmure(int armure) {
        this.armure = armure;
    }

    public int getPA() {
        return PA;
    }

    public void setPA(int PA) {
        this.PA = PA;
    }

    public int getPV() {
        return PV;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }

    /**
     *
     * @param automate
     */
    public Robot(Automate automate, Team equipe, String imgB) {
        this.automate = automate;
        this.setTeam(equipe);
        this.etatCourant = automate.getEtat("init");
        this.imgBase = imgB;
    }

    public Robot(Automate automate, String imgB) {
        this.automate = automate;
        this.etatCourant = automate.getEtat("init");
        this.imgBase = imgB;
    }

    public Robot(Automate automate) {
        this.automate = automate;
        this.etatCourant = automate.getEtat("init");
    }

    public Robot(Team equipe) {
        this.setTeam(equipe);
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
     */
    @Override
    public void tick() {
        if (plante) {
            System.out.println("Robot planté!");
            new Sleep().executer(this);
            return;
        }
        // l'action coute plus d'un toc, le robot doit attendre
        if (prix > 0) {
            prix--;
            return;
        }
        //dans le cas ou il n'a pas a attendre, on cherche l'action a executer. 
        //On boucle tant que l'on n'execute des actions qui ne coutent rien.
        while (prix == 0) {
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
                        prix++;
                    } else {
                        // transition trouvée. On récupère les actions a executer ainsi que l'etet de destination
                        actions.addAll(t.getActions());
                        etatDestination = t.getEtatDestination();
                    }
                }
            }
        }
    }

    public Environnement getEnvironnement() {
        if (environnement == null) {
            environnement = new Environnement(this.getTeam(), this);
        }
        return environnement;
    }

    public Sens getDirection() {
        return this.direction;
    }

    public void setDirection(Sens newDirection) {
        System.out.println("changeDirection " + newDirection.name());
        this.direction = newDirection;
    }

    @Override
    public int getPortee() {
        return this.portee;
    }

    @Override
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

    public Etat getEtatDestination() {
        return etatDestination;
    }

    public void setEtatDestination(Etat etatDestination) {
        this.etatDestination = etatDestination;
    }

    public AbstractObjet getItemPorte() {
        return ItemPorte;
    }

    public void setItemPorte(AbstractObjet ItemPorte) {
        this.ItemPorte = ItemPorte;
    }

    public int getTempsConstruction() {
        return tempsConstruction;
    }

    public void setTempsConstruction(int tempsConstruction) {
        this.tempsConstruction = tempsConstruction;
    }

    @Override
    public TypeCase whoIam() {
        return (TypeCase.robot);
    }

    private void executerAction(ActionInterface action) {
        try {
            action.executer(this);
            System.out.println(">>>>>>>>>>>>>>>>>>>>ACTION: " + action.getId().toUpperCase() + " <<<<<<<<<<<<<<<<<<<<<<<<<<<<");

            prix = etatCourant.getValeurAction(action);
            if (action instanceof AbstractActionComposee) {
                actions.addAll(((AbstractActionComposee) action).getNewActions());
            }
        } catch (Exception e) {//erreur lors de l'execution de l'action
            /*
             * Si action composée empilée, on vide la file et on relance SAUF SI
             * ON PLANTE LORS DU LANCEMENT D'UNE ACTION COMPOSEE
             */
            System.out.println("Exception levee");
            e.printStackTrace();
            if (pileActionsComposees.isEmpty()) {
                //on plante
                backToInit();
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
                backToInit();
                return;
            }
            //ICI, on a une action comp a relancer

            actions.clear();
            AbstractActionComposee acomp = pileActionsComposees.peek();
            acomp.relaunch();
            actions.addAll(acomp.getNewActions());
        }
    }

    private void backToInit() {
        etatDestination = null;
        etatCourant = automate.getEtat("init");
        getEnvironnement().cleanVars();
    }
}
