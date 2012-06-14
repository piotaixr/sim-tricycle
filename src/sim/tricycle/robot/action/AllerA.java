package sim.tricycle.robot.action;

import java.util.ArrayDeque;
import java.util.LinkedList;
import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.PossedeCaseInterface;
import sim.tricycle.robot.Noeud;
import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.Sens;
import sim.tricycle.robot.action.core.AbstractAction;
import sim.tricycle.robot.action.core.ActionInterface;

/**
 *
 * @author Adri
 */
public class AllerA extends AbstractAction {

    private Point p;

    public AllerA() {
        super();
    }
    
    public AllerA(Point p) {
        super();
        this.p = p;
    }

    public AllerA(Case c) {
        this(new Point(c.getX(), c.getY()));
    }

    public AllerA(PossedeCaseInterface pc) {
        this(pc.getPosition());
    }

    @Override
    protected Object doExecute(Robot bot) {
        TrouveChemin tc = new TrouveChemin(this.p);
        tc.executer(bot);
        System.out.println("TailleChemin :" + tc.getChemin().size());
        creerChemin(tc.getChemin(), bot);
        
        return null;
    }

//    private void creerChemin2(LinkedList<Noeud> cheminTrouve, Robot bot) {
//        ArrayDeque<ActionInterface> chemin = new ArrayDeque<ActionInterface>();
//        Sens directCourante;
//        Point posCourante = cheminTrouve.getFirst().getPoint();
//        Noeud n;
//        for (int i=0;i<cheminTrouve.size();i++){
//
//            n=cheminTrouve.pollFirst();
//           // n.setPoint(new Point(n.getPoint().getY(),n.getPoint().getX()));
//            directCourante = trouveDirection(posCourante, n.getPoint());
//            //System.out.println("sens:" + directCourante);
//
//            posCourante = n.getPoint();
//            System.out.println("case:" + posCourante.getX() + " " + posCourante.getY());
//
//            chemin.addFirst(new Tourner(directCourante));
//            chemin.addFirst(new Avancer());
//
//        }
//        chemin.removeFirst();
//        chemin.removeFirst();  
//        bot.getActions().addAll(chemin);
//    }
    
    private void creerChemin(LinkedList<Noeud> cheminTrouve, Robot bot) {
        while(! cheminTrouve.isEmpty()){
            SeTeleporterA tp = new SeTeleporterA(1,cheminTrouve.pollFirst().getPoint());
            bot.getActions().addFirst(tp);
        }
    }

    private Sens trouveDirection(Point p1, Point p2) {

        Sens newSens = Sens.NORD;

        if (p1.getX() < p2.getX()) {
            newSens = Sens.NORD;
        } else if (p1.getY() < p2.getY()) {
            newSens = Sens.OUEST;
        } else if (p2.getX() < p1.getX()) {
            newSens = Sens.SUD;
        } else if (p2.getY() < p1.getY()) {
            newSens = Sens.EST;
        }

        return newSens;
    }

    public void setP(Point newP) {
        this.p = newP;
    }

    public Point getP() {
        return this.p;
    }

    @Override
    public String getId() {
        return "allera";
    }
}
