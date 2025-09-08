
/** 
 * This class represents a symbol table, or hash table, with a very
 * simple hash function. Observe that you are not supposed to change
 * hash function. Ensure that you use linear probing as your method of
 * collision handling.
 *
 * @author Magnus Nielsen, Tommy Färnqvist ...
 */
public class SymbolTable {
    private static final int INIT_CAPACITY = 7;

    /* Number of key-value pairs in the symbol table */
    private int size;
    /* Size of linear probing table */
    private int maxSize;
    /* The keys */
    private String[] keys;
    /* The values */
    private Character[] vals;

    /**
     * Create an empty hash table - use 7 as default size
     */
    public SymbolTable() {
	this(INIT_CAPACITY);
    }

    /**
     * Create linear probing hash table of given capacity
     */
    public SymbolTable(int capacity) {
	size = 0;
	maxSize = capacity;
	keys = new String[maxSize];
	vals = new Character[maxSize];
    }

    /**
     * Return the number of key-value pairs in the symbol table
     */
    public int size() {
	return size;
    }

    /**
     * Is the symbol table empty?
     */
    public boolean isEmpty() {
	return size() == 0;
    }

    /**
     * Does a key-value pair with the given key exist in the symbol table?
     */
    public boolean contains(String key) {
	return get(key) != null;
    }

    /**
     * Hash function for keys - returns value between 0 and maxSize-1
     */
    public int hash(String key) {
	int i;
	int v = 0;

	for (i = 0; i < key.length(); i++) {
	    v += key.charAt(i);
	}
	return v % maxSize;
    }

    /**
     * Insert the key-value pair into the symbol table.
     * TODO: implement the put method.
     */
    public void put(String key, Character val) {
	return;
    } 

    /**
     * Return the value associated with the given key, null if no such
     * value.
     * TODO: implement the get method.
     */
    public Character get(String key) {
	return null;
    } 

    /**
     * Delete the key (and associated value) from the symbol table.
     * TODO: implement the delete method.
     */
    public void delete(String key) {
	return;
    } 

    /**
     * Print the contents of the symbol table.
     */
    public void dump() {
	String str = "";

	for (int i = 0; i < maxSize; i++) {
	    str = str + i + ". " + vals[i];
	    if (keys[i] != null) {
		str = str + " " + keys[i] + " (";
		str = str + hash(keys[i]) + ")";
	    } else {
		str = str + " -";
	    }
	    System.out.println(str);
	    str = "";
	}
    }
}
