/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils.params.types;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class BasicObjectAccessor extends VariableAccessor {

    public BasicObjectAccessor(Object variable) {
        super(variable);
    }

    @Override
    protected Object doGetValue(Object variable, String attribute) {
        Class c = variable.getClass();
        // test avec le champ et recherche d'un getter si le champ n'est pas accessible
        try {
            Field f = c.getDeclaredField(attribute);
            if (f.isAccessible()) {
                return f.get(variable);
            } else {
                Method m = getGetter(c, attribute);
                if (m == null) {
                    throw new RuntimeException("L'attribut auquel vous tentez d'acceder n'est pas accessible et il n'a pas de getter public");
                } else {
                    return m.invoke(variable);
                }
            }
        } catch (Exception ex) {
        }
        try {
            Method m = c.getDeclaredMethod(attribute);
            return m.invoke(variable);
        } catch (Exception ex) {
            throw new RuntimeException("L'objet ne possède ni attribut " + attribute + " ni getter (get" + attribute + ", is" + attribute + ") ni methode " + attribute + " n'ayant pas de parametre", ex);
        }


    }

    private Method getGetter(Class c, String attribute) {
        Method m = null;
        try {
            m = c.getDeclaredMethod("get" + ucfirst(attribute));
        } catch (NoSuchMethodException ex) {
            try {
                m = c.getDeclaredMethod("is" + ucfirst(attribute));
            } catch (NoSuchMethodException ex1) {
                return null;
            } catch (SecurityException ex1) {
                return null;
            }
        } catch (SecurityException ex) {
            return null;
        }

        return m;
    }

    @Override
    protected void doSetValue(Object var, String attribute, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
