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
     * 
     */
    public void put(String key, Character val) {

        if(key == null){
            return;
        }

        int index = hash(key);
        int startPosition = index; 

        if(val == null){
            delete(key);
            return;
        }

        while(keys[index] != null) {
            if(key.equals(keys[index])){
                vals[index] = val;
                return;
            }

            index++;
            index = index % maxSize;

            if(index==startPosition) {
                System.out.println("Listan är fullare än mig!");
                return;
            }    		
        }
        
    keys[index] = key;
    vals[index] = val;
    size++;
    return;
    } 

    /**
     * Return the value associated with the given key, null if no such
     * value.
     * 
     */
    public Character get(String key) {

        int index = hash(key);
        int startPosition = index; 

        if(key == null){
            System.out.println("fucking null key");
            return null;
        }

        if(keys[index] == null){
            return null;
        }


        if(keys[index].equals(key)){
            return vals[index];
        }

        while(!keys[index].equals(key)){// ! betyder sålänge detta är faskt
            index++;
            index = index % maxSize;
            if(keys[index] == null){
                return null;
            }
            //System.out.println(index + " print index for " + key);
            if(index == startPosition){
                System.out.println(key + " finns inte vid get");
                return null; //här dör allt när det returnas
            }
        } 
        return vals[index];
    } 
    
    /**
     * Delete the key (and associated value) from the symbol table.
     * 
     */
    public void delete(String key) {

        int index = hash(key);
        int startPosition = index; 

        if(key == null){
            System.out.println("fucking null key");
            return;
        }

        if(keys[index] == null){
            return;
        }
        
        while(!keys[index].equals(key)){
            index++;
            index = index % maxSize;
            if(index == startPosition){
                System.out.println(key + " finns inte vid delete");
                return;
            }
        }

        keys[index] = null;
        vals[index] = null;
        size--;
        index++;
        index = index % maxSize;

        while(index != startPosition){ //flytt tillbaka grej
            if(keys[index] == null){
                return;
            }

            size--;

            String keysOld = keys[index];
            keys[index] = null;
            char valsOld = vals[index];
            vals[index] = null;

            put(keysOld, valsOld);
            
            
            index++;
            index = index % maxSize;   
        }
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
