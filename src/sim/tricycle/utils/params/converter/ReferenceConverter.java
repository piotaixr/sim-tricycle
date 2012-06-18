/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils.params.converter;

import sim.tricycle.Ordonnanceur.OrdonnanceurInterface;
import sim.tricycle.utils.params.ParamConverterInterface;
import sim.tricycle.utils.params.types.Reference;

public class ReferenceConverter implements ParamConverterInterface {

    private OrdonnanceurInterface ordonnanceur;

    public ReferenceConverter(OrdonnanceurInterface ordonnanceur) {
        this.ordonnanceur = ordonnanceur;
    }

    @Override
    public Object convert(String chaine) {
        return new Reference(chaine.trim(), ordonnanceur);
    }

    @Override
    public String getName() {
        return "ref";
    }

    @Override
    public Class getOutputClass() {
        return Reference.class;
    }

    @Override
    public String reveverseConvert(Object o) {
        return ((Reference) o).getSelector();
    }
}
