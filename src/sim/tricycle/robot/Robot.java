/*
 */
package sim.tricycle.robot;

import java.util.ArrayList;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
abstract class Robot {

    protected Point position;
    protected Sens direction;
    protected int portee;
    protected ArrayList<Action> fileActions;
    protected ArrayList<EventType> ordreTest;

    public Robot() {
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point newP) {
        this.position = newP;
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

    public void setFileAction(ArrayList<Action> newFileActions) {
        this.fileActions = newFileActions;
    }

    public ArrayList<Action> setFileAction() {
        return this.fileActions;
    }

    public Evenement scan() {

        int i = 0;
        boolean eventFound = false;
        Evenement evt = new Evenement();

        while (i < this.ordreTest.size() && !eventFound) {

            switch (this.ordreTest.get(i)) {
                case BALLE:

                    break;

                case ENNEMI:
                    break;
            }
        }
        return evt;
    }
}
