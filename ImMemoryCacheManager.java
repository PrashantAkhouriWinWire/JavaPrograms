import java.util.*;

public class SimpleCacheManager {

  //What is HashMap in Java?
  //HashMap is a part of Java's collection framework and is used to store data in key-value pairs.
  //It allows for fast retrieval, insertion, and deletion of elements based on their keys.
  //HashMap is not synchronized, meaning it is not thread-safe for concurrent access
  //However, we can use Collections.synchronizedMap to make it thread-safe.
  // What is Map in Java?
  //Map is an interface in Java that represents a collection of key-value pairs.
  //It provides methods to add, remove, and retrieve elements based on their keys.

  // HashMap vs Hashtable
  //HashMap is not synchronized, while Hashtable is synchronized.
  //HashMap allows one null key and multiple null values, while Hashtable does not allow any null keys or values.
  //HashMap is generally faster than Hashtable due to the lack of synchronization.
 // HAshSet vs TreeSet
  //HashSet is an unordered collection that does not maintain any specific order of elements,
  //while TreeSet is a sorted collection that maintains elements in a specific order (natural ordering or custom comparator).
  //TreeSet implements the SortedSet interface, while HashSet implements the Set interface.


    private static SimpleCacheManager instance;
    private static Object monitor = new Object();
    private Map<String, Object> cache = Collections.synchronizedMap(new HashMap<String, Object>());

    private SimpleCacheManager() {
    }

    public void put(String cacheKey, Object value) {
        cache.put(cacheKey, value);
    }

    public Object get(String cacheKey) {
        return cache.get(cacheKey);
    }

    public void clear(String cacheKey) {
        cache.put(cacheKey, null);
    }

    public void clear() {
        cache.clear();
    }

    //singleton instance
    public static SimpleCacheManager getInstance() {
        if (instance == null) {
            synchronized (monitor) {
                if (instance == null) {
                    instance = new SimpleCacheManager();
                }
            }
        }
        return instance;
    }

}