/*
 */
package sim.tricycle.robot;

import sim.tricycle.robot.action.Action;
import java.util.ArrayList;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public abstract class Robot {

    protected Point position;
    protected Sens direction;
    protected int portee;
    protected ArrayList<Action> fileActions;
    protected ArrayList<EventType> ordreTest;
    protected Etat etatCourant;
    
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
    
    public Etat getEtat(){
        return this.etatCourant;
    }
    
    public void setEtat(Etat newEtat){
        this.etatCourant=newEtat;
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

    public void depilerActionCourante() {
        this.fileActions.get(0).executer(this);
        this.fileActions.remove(0);
    }
    
    public void changerEtat(Evenement evt){
         
    }
    
    public void agir(){
        changerEtat(scan());
        depilerActionCourante();
    }
}
