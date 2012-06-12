package sim.tricycle.utils.params.converter;

import sim.tricycle.utils.params.ParamConverterInterface;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class IntegerConverter implements ParamConverterInterface {

    @Override
    public Object convert(String chaine) {
        return Integer.parseInt(chaine.trim());
    }

    @Override
    public String getName() {
        return "integer";
    }

    @Override
    public Class getOutputClass() {
        return Integer.class;
    }
}
