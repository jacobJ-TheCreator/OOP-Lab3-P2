package exceptions;

/**
 * Exception thrown when attempting to access a key that does not exist in the dictionary.
 */
public class KeyNotFoundException extends Exception {
    
    /**
     * Constructs a new KeyNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public KeyNotFoundException(String message) {
        super(message);
    }
}
