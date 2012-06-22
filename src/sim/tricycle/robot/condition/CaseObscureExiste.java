/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot.condition;

import java.util.Iterator;
import java.util.List;
import sim.tricycle.Ordonnanceur.OrdonnanceurInterface;
import sim.tricycle.mapping.CarteTeam;
import sim.tricycle.mapping.Case;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.condition.core.AbstractCondition;

/**
 *
 * @author Adri
 */
public class CaseObscureExiste extends AbstractCondition {

    private OrdonnanceurInterface ordonnanceur;

    public CaseObscureExiste(OrdonnanceurInterface ordonnanceur) {
        this.ordonnanceur = ordonnanceur;
    }

    @Override
    public boolean test() {
        Robot bot = (Robot) ordonnanceur.getActiveTask();
        List<Case> cases = bot.getTeam().getCasesObscures();
        Iterator<Case> it = cases.iterator();
        while (it.hasNext()) {
            Case c = it.next();
            if (c.JamaisVu()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getId() {
        return "case_obscure_existe";
    }
}
