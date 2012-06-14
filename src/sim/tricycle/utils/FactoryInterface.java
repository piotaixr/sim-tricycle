package sim.tricycle.utils;

import java.util.Collection;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public interface FactoryInterface<K, V extends IdentifiableInterface<? extends K>> {

    public V create(K nom);

    public FactoryInterface<K, V> registerCollection(Collection<V> objet);

    public FactoryInterface<K, V> register(V objet);

    public boolean has(K nom);
}
