package sim.tricycle.utils.params.types;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public interface VariableAccessorInterface {

    public Object getValue(String selector);

    public void setValue(String selector, Object value);
}
