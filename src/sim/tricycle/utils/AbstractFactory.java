package sim.tricycle.utils;

import java.util.*;
import sim.tricycle.utils.params.ParamConverterProviderInterface;
import sim.tricycle.utils.params.Parameter;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public abstract class AbstractFactory<K, V extends IdentifiableInterface<? extends K>> implements FactoryInterface<K, V> {

    private HashMap<K, V> values = new HashMap();
    private ParamConverterProviderInterface paramConverterProvider;

    public AbstractFactory(ParamConverterProviderInterface paramConverterProvider) {
        this.paramConverterProvider = paramConverterProvider;
    }

    public ParamConverterProviderInterface getParamConverterProvider() {
        return paramConverterProvider;
    }

    @Override
    public V create(K nom) {
        if (!has(nom)) {
            throw new RuntimeException("La condition de nom " + nom + " n'existe pas ou n'est pas enregistrée auprès du système.");
        }

        return doCreate(nom, new ArrayList());
    }

    public V create(K nom, List<Parameter> params) {
        if (!has(nom)) {
            throw new RuntimeException("La condition de nom " + nom + " n'existe pas ou n'est pas enregistrée auprès du système.");
        }

        return doCreate(nom, params);
    }

    @Override
    public void registerCollection(Collection<V> collection) {
        for (V o : collection) {
            register(o);
        }
    }

    @Override
    public void register(V objet) {
        if (has(objet.getId())) {
            throw new RuntimeException("Une condition doit avoir un nom unique: " + objet.getId());
        }
    }

    @Override
    public boolean has(K nom) {
        return values.containsKey(nom);
    }

    protected HashMap<K, V> getValues() {
        return values;
    }

    protected abstract V doCreate(K nom, List<Parameter> params);

    protected Class[] toRequiredTypes(List<Parameter> parameters) {
        int nombre = parameters.size();
        Class[] types = new Class[nombre];
        int i = 0;
        Iterator<Parameter> it = parameters.iterator();
        while (it.hasNext()) {
            Parameter param = it.next();

            types[i++] = paramConverterProvider.get(param.getType()).getOutputClass();
        }

        return types;
    }

    protected Object[] toConvertedValues(List<Parameter> parameters) {
        int nombre = parameters.size();
        Object[] arrayParams = new Object[nombre];
        int i = 0;
        Iterator<Parameter> it = parameters.iterator();
        while (it.hasNext()) {
            Parameter param = it.next();

            arrayParams[i++] = paramConverterProvider.get(param.getType()).convert(param.getValue());
        }

        return arrayParams;
    }

    protected RuntimeException traiteException(Exception e) {
        return new RuntimeException("Erreur lord de l'instanciation de l'objet", e);
    }
}
