/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.mapping.mapException;

/**
 *
 * @author thomas
 */
public class CasesHorsMatriceDemandeException extends RuntimeException {

    /**
     * Creates a new instance of
     * <code>CasesHorsMatriceDemandeException</code> without detail message.
     */
    public CasesHorsMatriceDemandeException() {
    }

    /**
     * Constructs an instance of
     * <code>CasesHorsMatriceDemandeException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public CasesHorsMatriceDemandeException(String msg) {
        super(msg);
    }
}
