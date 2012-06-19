package sim.tricycle.robot.action;

import java.util.LinkedList;
import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.PossedeCaseInterface;
import sim.tricycle.mapping.elementCase.Piece;
import sim.tricycle.robot.Noeud;
import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.Sens;
import sim.tricycle.robot.action.core.AbstractAction;
import sim.tricycle.robot.action.core.AbstractActionComposee;
import sim.tricycle.utils.ActionBuilder;
import sim.tricycle.utils.params.types.Variable;

/**
 *
 * @author Adri
 */
public class AllerA extends AbstractActionComposee {

    private Variable varChemin;
//    private Variable courant;
    
    public AllerA(ActionBuilder builder) {
        super(builder);
    }

    @Override
    protected Object doExecute(Robot bot) {

        LinkedList<Noeud> chemin = (LinkedList<Noeud>) varChemin.getValue();
        Point courant = new Point(chemin.pollFirst().getPoint());
       
        while(!chemin.isEmpty()){
                   getBuilder().addNew("sedeplacerunecase",getBuilder().buildVariable("courant"));
                   courant = new Point(chemin.pollFirst().getPoint());
        }
        
        return null;
    }
    
    @Override
    public String getId() {
        return "allera";
    }
}
