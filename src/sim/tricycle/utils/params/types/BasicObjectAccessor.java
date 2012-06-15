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
//         test avec le champ et recherche d'un getter si le champ n'est pas accessible 
//        for(Method m :c.getMethods())
//            System.out.println(m.getName());

        try {
            Field f = c.getField(attribute);
            return f.get(variable);

        } catch (Exception efield) {
            Method m = getGetter(c, attribute);

            try {
                return m.invoke(variable);
            } catch (Exception egetter) {
                try {
                    m = c.getMethod(attribute);
                    return m.invoke(variable);
                } catch (Exception ex) {
                    throw new RuntimeException("L'objet ne possède ni attribut " + attribute + " ni getter (get" + attribute + ", is" + attribute + ") ni methode " + attribute + " n'ayant pas de parametre", ex);
                }
            }
        }
    }

    private Method getGetter(Class c, String attribute) {
        System.out.println("getter");
        Method m = null;
        try {
            m = c.getMethod("get" + ucfirst(attribute));
        } catch (NoSuchMethodException ex) {
            System.out.println("pas get" + ucfirst(attribute));
            try {
                m = c.getMethod("is" + ucfirst(attribute));
            } catch (NoSuchMethodException ex1) {
                System.out.println("pas is" + ucfirst(attribute));
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
