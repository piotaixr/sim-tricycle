/*
 */
package sim.tricycle.mapping.nosCarte;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class MapTest extends AbstractCarteGlobal {

    public MapTest() {
        String[][] mat = new String[][]{
            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "X", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "V", "V", "V", "V", "V", "@", "V", "V", "V", "V", "V", "V", "V"},
            {"V", "V", "B", "V", "V", "V", "X", "V", "V", "V", "V", "V", "V", "V", "V"},
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
