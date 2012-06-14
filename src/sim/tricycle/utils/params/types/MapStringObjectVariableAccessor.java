/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim.tricycle.utils.params.types;

import java.util.Map;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class MapStringObjectVariableAccessor extends VariableAccessor {

    public MapStringObjectVariableAccessor(Object variable) {
        super(variable);
    }

    @Override
    protected Object doGetValue(Object variable, String attribute) {
        Map<String, Object> map = (Map) variable;
        return map.get(attribute);
    }

    @Override
    protected void doSetValue(Object var, String attribute, Object value) {
        Map<String, Object> map = (Map) var;
        map.put(attribute, value);
    }

}
