package sim.tricycle.robot.action;

import java.util.HashSet;
import java.util.LinkedList;
import sim.tricycle.mapping.Case;
import sim.tricycle.robot.Noeud;
import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Adri
 */
public class TrouveChemin extends AbstractAction {

    private Point pDest;
    private LinkedList<Noeud> chemin;

    public TrouveChemin(Point pDest) {
        super();
        this.pDest = pDest;
        this.chemin = new LinkedList<Noeud>();
    }

    public LinkedList<Noeud> getChemin() {
        return this.chemin;
    }

    @Override
    protected Object doExecute(Robot bot) {
        this.chemin = plusCourtChemin(new Point(bot.getCoordonnees().getX(), bot.getCoordonnees().getY()), bot);
        //  System.out.print("Coucou");
        return null;
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
        while (!listeOuverte.isEmpty() && courant.getPoint().distanceDepuis(this.pDest) != 0) {

            listeFermee.addFirst(courant);
            //  System.out.println("X :"+courant.getPoint().getX()); 
            // System.out.println("Y :"+courant.getPoint().getY());
            listeOuverte.removeFirst();


            // System.out.println("Courant :"); 
            // System.out.println("X :"+courant.getPoint().getX()); 
            //  System.out.println("Y :"+courant.getPoint().getY());
            //System.out.println("Bot :"+bot.getPosition().getX());

            bot.getMapTeam().casesVoisines(bot.getMapTeam(), new Case(courant.getPoint().getX(), courant.getPoint().getY()), listeVoisins);
            //        System.out.println("nbVoisins :"+listeVoisins.size());
            for (Case c : listeVoisins) {
                if (!c.hasObstacle()) {
                    n = new Noeud(new Point(c.getX(), c.getY()), courant);
                    n.setPoids(n.getPoint().distanceDepuis(pDest));
                    //  System.out.println(n.getPoids());
                    //   System.out.println("Liste ouverte: "+n.getPoint().getX()+" "+n.getPoint().getY());
                    if (!listeOuverte.contains(n)) {
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
            // System.out.println("Liste ouverte: "+lastNode.getPoint().getX()+" "+lastNode.getPoint().getY());
            lastNode = lastNode.getParent();
        }
        //cheminFinal.add(lastNode);
        return cheminFinal;
    }

    @Override
    public String getId() {
        return "trouvechemin";
    }
}
