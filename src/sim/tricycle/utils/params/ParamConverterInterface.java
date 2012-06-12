package sim.tricycle.utils.params;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public interface ParamConverterInterface {

    public Object convert(String chaine);

    public String getName();

    public Class getOutputClass();
}
