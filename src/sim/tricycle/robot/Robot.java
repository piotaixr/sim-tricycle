/*
 */
package sim.tricycle.robot;

import java.util.ArrayDeque;
import java.util.ArrayList;
import sim.tricycle.robot.action.Action;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public abstract class Robot {

    protected Point position;
    protected Sens direction;
    protected int portee;
    protected ArrayDeque<Action> fileActions = new ArrayDeque();
    protected ArrayList<EventType> ordreTest = new ArrayList();

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

    public ArrayDeque<Action> getFileActions() {
        return fileActions;
    }

    public void setFileActions(ArrayDeque<Action> fileActions) {
        this.fileActions = fileActions;
    }

    public ArrayList<EventType> getOrdreTest() {
        return ordreTest;
    }

    public void setOrdreTest(ArrayList<EventType> ordreTest) {
        this.ordreTest = ordreTest;
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
