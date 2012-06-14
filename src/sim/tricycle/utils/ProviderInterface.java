package sim.tricycle.utils;

import java.util.Collection;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public interface ProviderInterface<K, V> {

    public V get(K nom);

    public boolean has(K nom);

    public ProviderInterface<K, V> register(V paramConverter);

    public ProviderInterface<K, V> registerCollection(Collection<V> paramsConverter);
}
