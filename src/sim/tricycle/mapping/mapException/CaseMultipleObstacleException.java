package sim.tricycle.mapping.mapException;

/**
 *
 * @author thomas
 */
public class CaseMultipleObstacleException extends RuntimeException  {

    /**
     * Creates a new instance of
     * <code>CaseMultipleObstacleException</code> without detail message.
     */
    public CaseMultipleObstacleException() {
    }

    /**
     * Constructs an instance of
     * <code>CaseMultipleObstacleException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public CaseMultipleObstacleException(String msg) {
        super(msg);
    }
}
