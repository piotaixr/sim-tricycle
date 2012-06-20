/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.utils.params.converter;

import sim.tricycle.robot.Point;
import sim.tricycle.utils.params.ParamConverterInterface;

/**
 *
 * @author Adri
 */
public class PointConverter implements ParamConverterInterface{

    @Override
    public Object convert(String chaine) {
        String[] s = chaine.split(" ");
        return new Point(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
    }

    @Override
    public String getName() {
       return "point";
    }

    @Override
    public Class getOutputClass() {
       return Point.class;
    }

    @Override
    public String reveverseConvert(Object o) {
        Point p =(Point) o;
        return p.getStringedCoord();
    }

    public PointConverter() {
        super();
    }
    
}
