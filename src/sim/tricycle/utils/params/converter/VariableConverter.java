/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils.params.converter;

import sim.tricycle.Ordonnanceur.OrdonnanceurInterface;
import sim.tricycle.utils.params.ParamConverterInterface;
import sim.tricycle.utils.params.types.Variable;

public class VariableConverter implements ParamConverterInterface {

    private OrdonnanceurInterface ordonnanceur;

    public VariableConverter(OrdonnanceurInterface ordonnanceur) {
        this.ordonnanceur = ordonnanceur;
    }

    @Override
    public Object convert(String chaine) {
        return new Variable(chaine.trim(), ordonnanceur);
    }

    @Override
    public String getName() {
        return "var";
    }

    @Override
    public Class getOutputClass() {
        return Variable.class;
    }
}
