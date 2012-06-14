package sim.tricycle.utils.params;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class ParamConverterProvider implements ParamConverterProviderInterface {

    private HashMap<String, ParamConverterInterface> converters = new HashMap();

    @Override
    public ParamConverterInterface get(String nom) {
        if (!has(nom)) {
            throw new RuntimeException("Le ParamConverter " + nom + " n'existe pas ou n'est pas enregistré dans le systeme.");
        }

        return converters.get(nom);
    }

    @Override
    public boolean has(String nom) {
        return converters.containsKey(nom);
    }

    @Override
    public ParamConverterProviderInterface register(ParamConverterInterface paramConverter) {
        if (converters.containsKey(paramConverter.getName())) {
            throw new RuntimeException("Un ParamConverter doit avoir un nom unique: " + paramConverter.getName());
        }

        converters.put(paramConverter.getName(), paramConverter);
        return this;
    }

    @Override
    public ParamConverterProviderInterface registerCollection(Collection<ParamConverterInterface> paramsConverter) {
        for (ParamConverterInterface p : paramsConverter) {
            register(p);
        }
        return this;
    }
}
