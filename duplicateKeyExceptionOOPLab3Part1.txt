package exceptions;

/**
 * Exception thrown when attempting to insert a key that already exists in the dictionary.
 */
public class DuplicateKeyException extends Exception {
    
    /**
     * Constructs a new DuplicateKeyException with the specified detail message.
     *
     * @param message the detail message
     */
    public DuplicateKeyException(String message) {
        super(message);
    }
}

