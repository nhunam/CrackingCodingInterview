package LinkedList2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheLCode146 {
	int capacity;
	LinkedList<Integer> ageList;
	HashMap<Integer, Integer> cache;

	public LRUCacheLCode146(int capacity) {
	    this.capacity = capacity;
	    ageList = new LinkedList<Integer>();
	    cache = new HashMap<>();
	}

	public int get(int key) {        
	    var result = cache.get(key);
	    if (result == null)
	        return -1;
	    ageList.remove(key);
	    ageList.addFirst(key);
	    return result;       
	}

	public void put(int key, int value) {
	    cache.put(key, value);
	    if (cache.size() > capacity){            
	        cache.remove(ageList.removeLast());            
	    }
	    ageList.remove(new Integer(key));
	    ageList.addFirst(key);
	}

}

