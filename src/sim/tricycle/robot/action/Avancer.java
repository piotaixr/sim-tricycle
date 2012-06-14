package sim.tricycle.robot.action;

import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Adri
 */
public class Avancer extends AbstractAction {

    private int nbCases;

    public Avancer() {
        super();
        nbCases = 1;
        this.setPoids(1);
    }

    public Avancer(int nbCases) {
        super();
        this.nbCases = nbCases;
        this.setPoids(1);
    }

    @Override
    protected Object doExecute(Robot bot) {

        Point p = new Point(bot.getCoordonnees());
        bot.decollerRobotDeMap();
        
        for (int i = 0; i < nbCases; i++) {
            switch (bot.getDirection()) {
                case NORD:
                    p.setX(p.getX() - 1);
                    break;

                case EST:
                    p.setY(p.getY() + 1);
                    break;

                case OUEST:
                    p.setY(p.getY() - 1);
                    break;

                case SUD:
                    p.setX(p.getX() + 1);
                    break;

                case SUD_EST:
                    p.setX(p.getX() - 1);
                    p.setY(p.getY() + 1);
                    break;

                case SUD_OUEST:
                    p.setX(p.getX() - 1);
                    p.setY(p.getY() - 1);
                    break;

                case NORD_EST:
                    p.setX(p.getX() + 1);
                    p.setY(p.getY() + 1);
                    break;

                case NORD_OUEST:
                    p.setX(p.getX() + 1);
                    p.setY(p.getY() - 1);
                    break;
            }
        }
        bot.setCoordonnees(p);
        bot.collerRobotSurMap();
        return null;
    }

    @Override
    public String getId() {
        return "avancer";
    }
}
