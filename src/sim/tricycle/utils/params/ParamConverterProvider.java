/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils.params;

import java.util.Collection;
import java.util.HashMap;
import sim.tricycle.utils.ProviderInterface;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class ParamConverterProvider implements ParamConverterProviderInterface {

    private HashMap<String, ParamConverterInterface> converters = new HashMap();

    @Override
    public ParamConverterInterface get(String nom) {
        if (!hasConverter(nom)) {
            throw new RuntimeException("Le ParamConverter " + nom + " n'existe pas ou n'est pas enregistré dans le systeme.");
        }

        return converters.get(nom);
    }

    @Override
    public boolean hasConverter(String nom) {
        return converters.containsKey(nom);
    }

    @Override
    public void register(ParamConverterInterface paramConverter) {
        if (converters.containsKey(paramConverter.getName())) {
            throw new RuntimeException("Un ParamConverter doit avoir un nom unique: " + paramConverter.getName());
        }

        converters.put(paramConverter.getName(), paramConverter);
    }

    @Override
    public void registerCollection(Collection<ParamConverterInterface> paramsConverter) {
        for (ParamConverterInterface p : paramsConverter) {
            register(p);
        }
    }
}
