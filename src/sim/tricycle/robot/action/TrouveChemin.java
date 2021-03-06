package sim.tricycle.robot.action;

import java.util.HashSet;
import java.util.LinkedList;
import sim.tricycle.mapping.Case;
import sim.tricycle.robot.Noeud;
import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;
import sim.tricycle.utils.params.types.Reference;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author Adri
 */
public class TrouveChemin extends AbstractAction {

    private Point pDest = null;
    private LinkedList<Noeud> chemin = new LinkedList<Noeud>();
    private Reference refPointDest = null;

    public TrouveChemin(Point pDest) {
        super();
        this.pDest = pDest;
    }

    public TrouveChemin() {
        super();
    }

    public LinkedList<Noeud> getChemin() {
        return this.chemin;
    }

    @Override
    protected Object doExecute(Robot bot) {
        //  System.out.print("Coucou");
        if (refPointDest != null) {
            System.out.println(refPointDest.getValue().getClass().toString());
            if (refPointDest.getValue() instanceof Case) {
                Case c = (Case) refPointDest.getValue();
                pDest = new Point(c.getX(), c.getY());
            } else {
                pDest = (Point) refPointDest.getValue();
                System.out.println(pDest.getStringedCoord());
            }
        }
        return plusCourtChemin(bot.getPosition().toPoint(), bot);
    }

    private void insereEnOrdre(Noeud n, LinkedList<Noeud> listeNoeuds) {
        //  listeNoeuds
        int i = 0;
        while (i < listeNoeuds.size() && n.getPoids() >= listeNoeuds.get(i).getPoids()) {
            i++;
        }
        listeNoeuds.add(i, n);
    }

    private LinkedList<Noeud> plusCourtChemin(Point pDep, Robot bot) {

        LinkedList<Noeud> listeOuverte = new LinkedList();
        LinkedList<Noeud> listeFermee = new LinkedList();
        HashSet<Case> listeVoisins = new HashSet<Case>();
        Noeud n = new Noeud(pDep);
        n.setPoids(n.getPoint().distanceDepuis(pDest));
        n.setParent(null);
        listeOuverte.add(n);
        Noeud courant = listeOuverte.getFirst();

        //    System.out.println("Bot : "+bot.getPosition().getX()+" "+bot.getPosition().getY());
        // System.out.println("Case 3 9:"+bot.getMapObjective().getCase(3, 9).whoIam());
        while (!listeOuverte.isEmpty() && courant.getPoint().distanceDepuis(this.pDest) != 0) {

            listeFermee.addFirst(courant);
            //  System.out.println("X :"+courant.getPoint().getX()); 
            // System.out.println("Y :"+courant.getPoint().getY());
            listeOuverte.removeFirst();


            // System.out.println("Courant :"); 
            // System.out.println("X :"+courant.getPoint().getX()); 
            //  System.out.println("Y :"+courant.getPoint().getY());
            //System.out.println("Bot :"+bot.getPosition().getX());

            bot.getTeam().getMap().casesVoisines(bot.getTeam().getMap(), new Case(courant.getPoint().getX(), courant.getPoint().getY()), listeVoisins);
            //        System.out.println("nbVoisins :"+listeVoisins.size());
            for (Case c : listeVoisins) {
                if (!c.hasObstacle() && isAuMoinsUneVoisineConnexe(bot,c)) {
                    n = new Noeud(new Point(c.getX(), c.getY()), courant);
                    n.setPoids(n.getPoint().distanceDepuis(pDest));
                    //  System.out.println(n.getPoids());
                    //System.out.println("Liste ouverte: "+n.getPoint().getX()+" "+n.getPoint().getY());
                    //  System.out.println("Type Case: "+c.whoIam());
                    if (!listeOuverte.contains(n) && !listeFermee.contains(n)) {
                        insereEnOrdre(n, listeOuverte);
                    }
                }
            }

            courant = listeOuverte.getFirst();
        }
        listeFermee.addFirst(courant);
        return retrouveChemin(pDep, listeFermee.getFirst());
    }

    private LinkedList<Noeud> retrouveChemin(Point pDep, Noeud lastNode) {

        LinkedList<Noeud> cheminFinal = new LinkedList<Noeud>();
        //  cheminFinal.add(lastNode);
        while (lastNode != null) {
            cheminFinal.add(lastNode);
            System.out.println("Chemin final: " + lastNode.getPoint().getX() + " " + lastNode.getPoint().getY());
            lastNode = lastNode.getParent();
        }
        //cheminFinal.add(lastNode);
        cheminFinal.pollLast();
        return cheminFinal;
    }

    @Override
    public String getId() {
        return "trouvechemin";
    }

    public Point getpDest() {
        return pDest;
    }

    public void setpDest(Point pDest) {
        this.pDest = pDest;
    }

    public void setParameters(Reference refPointDest) {
        this.refPointDest = refPointDest;
    }

    public void setParameters(Variable refPointDest) {
        this.refPointDest = refPointDest;
    }

    public void setParameters(Point pointDest) {
        this.pDest = pointDest;
    }

    private boolean isAuMoinsUneVoisineConnexe(Robot bot, Case c) {

        HashSet<Case> v = new HashSet<Case>();
        bot.getTeam().getMap().casesVoisines(bot.getTeam().getMap(), c, v);
        for (Case test : v) {
            if (bot.getTeam().getMap().isConnexe(bot.getPosition(),test)) {
               return true;
            }
        }
        return false;
    }
}
