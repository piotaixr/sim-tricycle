/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle;

import java.util.HashMap;
import java.util.Map;
import sim.tricycle.utils.ObjectBuilder;
import sim.tricycle.utils.params.types.BasicObjectAccessor;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class TestReference {

    public Map<String, Object> map = new HashMap();
    private int privateproperty = 42;
    public int publicproperty = 21;
    private int privatepropertygetter = 66;

    public String meth() {
        return "ok";
    }

    private String privateMeth() {
        return "private";
    }

    public int getPrivatepropertygetter() {
        return privatepropertygetter;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public static void main(String[] args) {
        ObjectBuilder builder = new ObjectBuilder();

        TestReference test = new TestReference();


        BasicObjectAccessor objectAccessor = new BasicObjectAccessor(test);

        objectAccessor.setValue("map.aaa", new Exception());

        System.out.println(objectAccessor.getValue("privateproperty"));
    }
}
