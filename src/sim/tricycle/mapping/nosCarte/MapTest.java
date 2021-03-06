/*
 */
package sim.tricycle.mapping.nosCarte;

import sim.tricycle.mapping.AbstractCarte;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class MapTest extends AbstractCarte {

    public MapTest() {
        String[][] mat = new String[][]{
            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "X", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "A1", "A2", "A3", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "A4", "@", "A6", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "B", "V", "V", "V", "A7", "A8", "A9", "V", "V", "V", "V", "V", "V"},
            {"V", "X", "X", "V", "V", "V", "X", "X", "V", "V", "V", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "X", "V", "V", "V", "V", "X", "V", "V", "V"},
            {"V", "V", "B", "V", "V", "V", "X", "V", "V", "V", "V", "X", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "X", "V", "V", "V", "V", "X", "V", "V", "P"},
            {"V", "V", "V", "V", "V", "V", "X", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "B", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "P"},
            {"V", "P", "V", "V", "P", "P", "V", "V", "V", "V", "V", "V", "V", "V", "P"},
            {"V", "p", "B", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},};
        this.startInit(mat);
    }
}
