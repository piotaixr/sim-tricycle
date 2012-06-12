package sim.tricycle.robot.condition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Element;
import sim.tricycle.utils.params.Parameter;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class ParameterCreator {

    public List<Parameter> toParameterList(List<Element> parametersElements) {
        List<Parameter> params = new ArrayList<Parameter>(parametersElements.size());
        Iterator<Element> it = parametersElements.iterator();
        while (it.hasNext()) {
            Element elem = it.next();
            String type = elem.getAttributeValue("type");
            if (type == null) {
                type = "string";
            }

            String value = elem.getTextNormalize();
            params.add(new Parameter(type, value));
        }

        return params;
    }
}
