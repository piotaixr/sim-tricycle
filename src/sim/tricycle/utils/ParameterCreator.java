package sim.tricycle.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Element;
import sim.tricycle.utils.params.ParamConverterInterface;
import sim.tricycle.utils.params.ParamConverterProviderInterface;
import sim.tricycle.utils.params.Parameter;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class ParameterCreator {

    ParamConverterProviderInterface paramConverterProvider;

    public ParameterCreator(ParamConverterProviderInterface paramConverterProvider) {
        this.paramConverterProvider = paramConverterProvider;
    }

    public List<Parameter> elementListToParameterList(List<Element> parametersElements) {
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

    public List<Parameter> arrayParameterToParameterList(Object[] paramsArray) {
        List<Parameter> params = new ArrayList<Parameter>(paramsArray.length);


        for (Object o : paramsArray) {
            ParamConverterInterface correspondant = null;
            for (ParamConverterInterface pci : paramConverterProvider.getConverters().values()) {
                if (pci.getOutputClass().isInstance(o)) {// le provider correspond a la classe mais on veut le plus precis
                    if (correspondant == null) {
                        correspondant = pci;
                    } else {
                        List<Class> supClassCorrespondant = Arrays.asList(correspondant.getOutputClass().getClasses());
                        if (!supClassCorrespondant.contains(pci.getOutputClass())) {
                            correspondant = pci;
                        }
                    }
                }
            }
            if (correspondant == null) {
                throw new RuntimeException("impossible de trouver un converter pour ce type de variable: " + o.getClass().getName());
            }
            params.add(new Parameter(correspondant.getName(), correspondant.reveverseConvert(o)));
        }

        return params;
    }

    public Class[] toRequiredTypes(List<Parameter> parameters) {
        int nombre = parameters.size();
        Class[] types = new Class[nombre];
        int i = 0;
        Iterator<Parameter> it = parameters.iterator();
        while (it.hasNext()) {
            Parameter param = it.next();

            types[i++] = paramConverterProvider.get(param.getType()).getOutputClass();
        }

        return types;
    }

    public Object[] toConvertedValues(List<Parameter> parameters) {
        int nombre = parameters.size();
        Object[] arrayParams = new Object[nombre];
        int i = 0;
        Iterator<Parameter> it = parameters.iterator();
        while (it.hasNext()) {
            Parameter param = it.next();

            arrayParams[i++] = paramConverterProvider.get(param.getType()).convert(param.getValue());
        }

        return arrayParams;
    }
}
