//Jaocbs v
package utilities;

import exceptions.DuplicateKeyException;
import exceptions.KeyNotFoundException;

/**
 * The {@code DictionaryADT} interface defines a contract for a dictionary (map) 
 * that stores key-value pairs, where each key is unique and maps to a corresponding value.
 * This interface allows inserting, removing, updating, and retrieving values efficiently.
 *
 * Implementations should ensure that duplicate keys are not allowed 
 * and that all operations adhere to the specified behavior.
 *
 * @param <K> the type of keys maintained by this dictionary (keys must be unique)
 * @param <V> the type of values mapped to each key
 * 
 * @author Christin Racicot, Noah Jobse, Jacob Jobse, Parth Nileshkumar Dave
 * @version 1.0
 */
public interface DictionaryADT<K, V> {

    /**
     * Inserts a new key-value pair into the dictionary.
     *
     * - The key must be unique; if it already exists, an exception is thrown.
     * - The key cannot be {@code null}.
     * - The value can be {@code null}.
     * - After a successful insert, the key-value pair is stored in the dictionary.
     *
     * @param key the unique identifier that is used to retrieve the associated value
     * @param value the value associated with the key
     * @throws DuplicateKeyException if the key is already present in the dictionary
     * @throws IllegalArgumentException if the key is {@code null}
     */
    void insert(K key, V value) throws DuplicateKeyException;

    /**
     * Removes a key-value pair from the dictionary based on the provided key.
     *
     * - The key must exist in the dictionary; otherwise, an exception is thrown.
     * - If successful, the key and its associated value are removed.
     *
     * @param key the key to remove from the dictionary
     * @return the value previously associated with the removed key
     * @throws KeyNotFoundException if the key is not found in the dictionary
     * @throws IllegalArgumentException if the key is {@code null}
     */
    V remove(K key) throws KeyNotFoundException;

    /**
     * Updates the value associated with an existing key.
     *
     * - The key must already exist in the dictionary; otherwise, an exception is thrown.
     * - The new value replaces the existing value for the given key.
     *
     * @param key the key whose value should be updated
     * @param value the new value to be associated with the key
     * @throws KeyNotFoundException if the key is not found in the dictionary
     * @throws IllegalArgumentException if the key is {@code null}
     */
    void update(K key, V value) throws KeyNotFoundException;

    /**
     * Retrieves the value associated with a given key.
     *
     * - If the key exists, the corresponding value is returned.
     * - If the key is not found, an exception is thrown.
     * - The dictionary remains unchanged.
     *
     * @param key the key whose associated value is to be retrieved
     * @return the value mapped to the given key
     * @throws KeyNotFoundException if the key is not found in the dictionary
     * @throws IllegalArgumentException if the key is {@code null}
     */
    V lookup(K key) throws KeyNotFoundException;

    /**
     * Checks whether the dictionary is empty.
     *
     * - Returns {@code true} if the dictionary contains no key-value pairs.
     * - Returns {@code false} if at least one key-value pair exists.
     *
     * @return {@code true} if the dictionary is empty, {@code false} otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of key-value pairs currently stored in the dictionary.
     *
     * - The dictionary remains unchanged after calling this method.
     *
     * @return the number of key-value pairs in the dictionary
     */
    int size();
}
