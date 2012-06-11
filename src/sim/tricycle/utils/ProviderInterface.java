package sim.tricycle.utils;

import java.util.Collection;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public interface ProviderInterface<K, V> {

    public V get(K nom);

    public boolean has(K nom);

    public void register(V paramConverter);

    public void registerCollection(Collection<V> paramsConverter);
}
