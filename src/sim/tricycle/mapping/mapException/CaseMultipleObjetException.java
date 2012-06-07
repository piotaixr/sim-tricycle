/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.mapping.mapException;

/**
 *
 * @author thomas
 */
public class CaseMultipleObjetException extends RuntimeException {

    /**
     * Creates a new instance of
     * <code>CaseMultipleObjet</code> without detail message.
     */
    public CaseMultipleObjetException() {
    }

    /**
     * Constructs an instance of
     * <code>CaseMultipleObjet</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public CaseMultipleObjetException(String msg) {
        super(msg);
    }
}
