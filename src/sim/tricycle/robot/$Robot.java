/*
 */
package sim.tricycle.robot;

import java.util.ArrayList;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
abstract class $Robot {

    protected Point position;
    protected Sens direction;
    protected int portee;
    protected ArrayList<$Action> fileActions;
    protected ArrayList<Type_Event> ordreTest;

    public $Robot() {
    }

    public Point GetPosition() {
        return this.position;
    }

    public void SetPosition(Point newP) {
        this.position = newP;
    }

    public Sens GetDirection() {
        return this.direction;
    }

    public void SetDirection(Sens newDirection) {
        this.direction = newDirection;
    }

    public int GetPortee() {
        return this.portee;
    }

    public void SetPortee(int newPortee) {
        this.portee = newPortee;
    }

    public void SetFileAction(ArrayList<$Action> newFileActions) {
        this.fileActions = newFileActions;
    }

    public ArrayList<$Action> GetFileAction() {
        return this.fileActions;
    }

    public $Evenement Scan() {

        int i = 0;
        boolean eventFound = false;
        $Evenement evt = new $Evenement();

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
