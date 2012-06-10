/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils.params;

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
