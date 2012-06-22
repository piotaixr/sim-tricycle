/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.mapping;

import java.util.Comparator;
import sim.tricycle.mapping.elementCase.Base;
import sim.tricycle.robot.Point;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class CaseDistanceManhattanComparator implements Comparator<Case> {

    private Point base;

    public CaseDistanceManhattanComparator(Base base) {
        this.base = base.getPosition().toPoint();
    }

    @Override
    public int compare(Case c1, Case c2) {
        int distc1 = base.distanceDepuis(c1.toPoint());
        int distc2 = base.distanceDepuis(c2.toPoint());
        if (distc1 == distc2) {
            return 0;
        } else {
            return distc1 < distc2 ? -1 : 1;
        }
    }
}
