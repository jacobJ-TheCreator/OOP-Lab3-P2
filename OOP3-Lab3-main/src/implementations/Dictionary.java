//Jacobs version 2025-03-11

package implementations;

import java.util.ArrayList;
import exceptions.DuplicateKeyException;
import utilities.DictionaryADT;

/**
 * A simple dictionary that stores key-value pairs using ArrayLists.
 * This class follows the DictionaryADT interface and ensures that each key is unique.
 *
 * @param <K> The type of keys stored in the dictionary.
 * @param <V> The type of values associated with the keys.
 */
public class Dictionary<K, V> implements DictionaryADT<K, V> {
    private static final int DEFAULT_SIZE = 10;

    private ArrayList<K> keys;
    private ArrayList<V> values;

    /**
     * Creates a dictionary with a default size.
     */
    public Dictionary() {
        this(DEFAULT_SIZE);
    }

    /**
     * Creates a dictionary with a specified starting size.
     * 
     * @param size The initial capacity of the dictionary.
     */
    public Dictionary(int size) {
        keys = new ArrayList<>(size);
        values = new ArrayList<>(size);
    }

    /**
     * Clears the dictionary and resets it to the given size.
     * 
     * @param size The new capacity of the dictionary.
     */
    @Override
    public void create(int size) {
        keys.clear();
        values.clear();
    }

    /**
     * Adds a new key-value pair to the dictionary.
     * If the key already exists, an exception is thrown.
     * 
     * @param key   The key to add.
     * @param value The value associated with the key.
     * @return true if the pair was added successfully.
     * @throws DuplicateKeyException if the key is already in the dictionary.
     */
    @Override
    public boolean insert(K key, V value) throws DuplicateKeyException {
        if (keys.contains(key)) {
            throw new DuplicateKeyException("Key already exists: " + key);
        }
        keys.add(key);
        values.add(value);
        return true;
    }

    /**
     * Removes a key-value pair from the dictionary.
     * 
     * @param key The key to remove.
     * @return The value that was removed, or null if the key wasn't found.
     */
    @Override
    public V remove(K key) {
        int index = keys.indexOf(key);
        if (index == -1) {
            return null;
        }
        keys.remove(index);
        return values.remove(index);
    }

    /**
     * Updates the value of an existing key.
     * 
     * @param key   The key whose value needs to be updated.
     * @param value The new value to assign.
     * @return true if the update was successful, false if the key wasn't found.
     */
    @Override
    public boolean update(K key, V value) {
        int index = keys.indexOf(key);
        if (index == -1) {
            return false;
        }
        values.set(index, value);
        return true;
    }

    /**
     * Finds the value associated with a given key.
     * 
     * @param key The key to look up.
     * @return The corresponding value, or null if the key isn't in the dictionary.
     */
    @Override
    public V lookup(K key) {
        int index = keys.indexOf(key);
        return (index != -1) ? values.get(index) : null;
    }
}
