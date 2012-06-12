/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils.params.types;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class Reference implements ReferenceInterface {

    private Object variable;
    private String selector;
    private Object cible;
    private Field lastField = null;

    public Reference(String selector, Object variable) {
        this.selector = selector;
        this.variable = variable;
        resolveCible();
    }

    @Override
    public Object getValue() {
        try {
            if (lastField.isAccessible()) {
                    return lastField.get(cible);
                } else {
                    Method m = cible.getClass().getMethod("get" + ucfirst(lastField.getName()));
                    return m.invoke(cible);
                }
        } catch (Exception ex) {
            throw traiteException(ex);
        }
    }

    @Override
    public void setValue(Object value) {
        try {
            lastField.set(cible, value);
        } catch (Exception ex) {
            throw traiteException(ex);
        }
    }

    private void resolveCible() {
        try {
            LinkedList<String> attributes = new LinkedList();
            attributes.addAll(Arrays.asList(selector.split(selector)));

            if (attributes.isEmpty()) {
                throw new RuntimeException("Cible incorrecte: " + selector);
            }
            Iterator<String> it = attributes.iterator();
            cible = variable;
            lastField = cible.getClass().getDeclaredField(it.next());
            while (it.hasNext()) {
                if (lastField.isAccessible()) {
                    cible = lastField.get(cible);
                } else {
                    Method m = cible.getClass().getMethod("get" + ucfirst(lastField.getName()));
                    cible = m.invoke(cible);
                }
                lastField = cible.getClass().getDeclaredField(it.next());
            }
        } catch (Exception ex) {
            throw traiteException(ex);
        }
    }

    private RuntimeException traiteException(Exception ex) {
        return new RuntimeException("Erreur d'accès a la variable avec le selector " + selector, ex);
    }

    private String ucfirst(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);

    }
}
