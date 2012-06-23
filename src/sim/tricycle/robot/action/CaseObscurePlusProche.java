/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.action;

import java.util.Iterator;
import java.util.List;
import sim.tricycle.mapping.CarteTeam;
import sim.tricycle.mapping.Case;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.action.core.AbstractAction;

/**
 *
 * @author Adri
 */
public class CaseObscurePlusProche extends AbstractAction {

    public CaseObscurePlusProche() {
    }

    @Override
    protected Object doExecute(Robot bot) {
        List<Case> cases = bot.getTeam().getCasesObscures();
        Iterator<Case> it = cases.iterator();
        while (it.hasNext()) {
            Case c = it.next();
            if (c.JamaisVu()) {
                return c;
            } else {
                it.remove();
            }
        }
        throw new RuntimeException("Plus de cases obscures");
    }

    @Override
    public String getId() {
        return "case_obscure_plus_proche";
    }
}
