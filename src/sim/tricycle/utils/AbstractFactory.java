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
    private ParameterCreator parameterCreator;

    public AbstractFactory(ParamConverterProviderInterface paramConverterProvider, ParameterCreator parameterCreator) {
        this.paramConverterProvider = paramConverterProvider;
        this.parameterCreator = parameterCreator;
    }

    public ParameterCreator getParameterCreator() {
        return parameterCreator;
    }

    public ParamConverterProviderInterface getParamConverterProvider() {
        return paramConverterProvider;
    }

    @Override
    public V create(K nom) {
        if (!has(nom)) {
            throw new RuntimeException("La condition/action de nom " + nom + " n'existe pas ou n'est pas enregistrée auprès du système.");
        }

        return doCreate(nom, new ArrayList());
    }

    public V create(K nom, List<Parameter> params) {
        if (!has(nom)) {
            throw new RuntimeException("La condition/action de nom " + nom + " n'existe pas ou n'est pas enregistrée auprès du système.");
        }

        return doCreate(nom, params);
    }

    @Override
    public FactoryInterface<K, V> registerCollection(Collection<V> collection) {
        for (V o : collection) {
            register(o);
        }
        return this;
    }

    @Override
    public FactoryInterface<K, V> register(V objet) {
        if (has(objet.getId())) {
            throw new RuntimeException("Une condition doit avoir un nom unique: " + objet.getId());
        }

        values.put(objet.getId(), objet);
        return this;
    }

    @Override
    public boolean has(K nom) {
        return values.containsKey(nom);
    }

    protected HashMap<K, V> getValues() {
        return values;
    }

    protected abstract V doCreate(K nom, List<Parameter> params);

    protected RuntimeException traiteException(Exception e) {
        return new RuntimeException("Erreur lors de l'instanciation de l'objet", e);
    }
}
