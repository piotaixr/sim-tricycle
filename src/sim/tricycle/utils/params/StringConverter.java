/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils.params;

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
}
