/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils.params;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class Parameter {

    private String type;
    private String value;

    public Parameter(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
