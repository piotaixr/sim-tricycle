package sim.tricycle.utils.params;

import java.util.Map;
import sim.tricycle.utils.ProviderInterface;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public interface ParamConverterProviderInterface extends ProviderInterface<String, ParamConverterInterface> {
    public Map<String, ParamConverterInterface> getConverters();
}
