package sim.tricycle.utils.params.converter;

import sim.tricycle.utils.params.ParamConverterInterface;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class StringConverter implements ParamConverterInterface {

    @Override
    public Object convert(String chaine) {
        return chaine.trim();
    }

    @Override
    public String getName() {
        return "string";
    }

    @Override
    public Class getOutputClass() {
        return String.class;
    }

    @Override
    public String reveverseConvert(Object o) {
        return (String) o;
    }
}
