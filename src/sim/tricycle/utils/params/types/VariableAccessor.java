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
public abstract class VariableAccessor implements VariableAccessorInterface {

    private Object variable;

    public VariableAccessor(Object variable) {
        this.variable = variable;
    }

    protected abstract Object doGetValue(Object variable, String attribute);

    protected abstract void doSetValue(Object var, String attribute, Object value);

    @Override
    public Object getValue(String selector) {
        if (selector.trim().equals("")) {
            return variable;
        }

        int pointIndex = selector.indexOf(".");
        String attribute = selector;
        String newSelector = "";
        if (pointIndex == -1) {
            attribute = attribute.trim();
        } else {
            attribute = selector.substring(0, pointIndex).trim();
            newSelector = selector.substring(pointIndex + 1).trim();
        }

        Object value = doGetValue(variable, attribute);

        if (selector.equals("")) {
            return value;
        } else {
            return getAccessorFor(value).getValue(newSelector);
        }
    }

    @Override
    public void setValue(String selector, Object value) {
        if (selector.trim().equals("")) {
            throw new RuntimeException("Le selecteur ne doit pas etre vide");
        }

        int pointIndex = selector.indexOf(".");
        if (pointIndex == -1) {//pas besoin de chercher plus loin, on veut modifier un attribut de la variable de base, juste appel de doSetValue
            doSetValue(variable, selector.trim(), value);
            return;
        }
        //sinon, il faut avancer
        String attribute = selector.substring(0, pointIndex).trim();
        String newSelector = selector.substring(pointIndex + 1).trim();

        Object var = doGetValue(variable, attribute);

        getAccessorFor(var).setValue(newSelector, value);
    }

    protected String ucfirst(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);

    }

    private VariableAccessorInterface getAccessorFor(Object value) {
        if (value instanceof Map) {
            return new MapStringObjectVariableAccessor(value);
        } else {// objet classique
            return new BasicObjectAccessor(value);
        }
    }
}
