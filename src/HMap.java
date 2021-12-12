package HMap;

import java.util.Objects;

public class HMap<K, V> {
	
		static int DEFAULT_INITIAL_CAPACITY = 16;
		static float DEFAULT_LOAD_FACTOR = 0.75f;
		
		transient Entity<K,V>[]  dataArray;
		
		public HMap() {
			dataArray = new Entity[DEFAULT_INITIAL_CAPACITY];
			System.out.println("default  done: Size "+dataArray.length);

		}
		public HMap(int initialCap) {
			DEFAULT_INITIAL_CAPACITY = initialCap;
			dataArray = new Entity[DEFAULT_INITIAL_CAPACITY];
			System.out.println("initial cap done");
		}
		
		public V put(K key,V value) {
			int index = getIndex(getHashCode(key));
			
			Entity<K,V> node = new Entity<>(key, value, index);
			
			Entity<K,V> storedObj = dataArray[index];

			// index data is null
			if(storedObj == null) {
				dataArray[index]=node;
			}else {
				// linked new data to old index value and return value
				Entity<K,V> currentNode = storedObj;
				while(true) {
				       if(currentNode.key.equals(node.key)) {
				    	  dataArray[index]=node;
				    	  return node.getValue();
				       }else {
				    	   if(currentNode.nextNode==null) {
				    		   currentNode.setNextNode(node);
						       return node.getValue();
							}else {
								currentNode=currentNode.nextNode;
							}
				       }
				 }
			}
			return value;
		}
		public V get(Object key) throws Exception {
			
			Entity<K,V> currentNode = dataArray[getIndex(getHashCode(key))];
				while(true) {
				       if(currentNode.key.equals(key)) {
				    	  return currentNode.getValue();
				       }else {
				    	   if(currentNode.nextNode==null) {
						       throw new Exception("Key Not found");
							}else {
								currentNode=currentNode.nextNode;
							}
				       }
				}
			
		}
		public boolean containsKey(Object key) {			
			Entity<K,V> currentNode = dataArray[getIndex(getHashCode(key))];
			
				while(true) {
				       if(currentNode.key.equals(key)) {
							return true;
				       }else {
				    	   if(currentNode.nextNode==null) {
								return false;
							}else {
								currentNode=currentNode.nextNode;
							}
				       }
				}			
		}
		
		static final int getHashCode(Object key) {
	        int h;
	        return (key==null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	    }
		
		static final int getIndex(int hash) {
			return  hash & (DEFAULT_INITIAL_CAPACITY-1);
		}
		
		
		public static void main(String[] args) throws Exception {
			HMap<Integer,Integer> map = new HMap<Integer, Integer>();
			for(int i=1; i<50 ; i++)
			System.out.println(map.put(i, i));
			
			System.out.println("get Object with key-"+map.get(1));
			System.out.println("get Object with key-"+map.get(49));

		}
		
}

class Entity<K, V> {

	K key;
	V value;
	Entity<K, V> nextNode;
	int hash;

	
	public Entity() {
		
	}
    public Entity(K key, V value,int hash ) {
		this.key=key;
		this.value=value;
		this.hash=hash;
	}
	
	
	public K getKey() {
		return this.key;
	}

	public V getValue() {
		return this.value;
	}

	public V setValue(V value) {
		return this.value = value;
	}
	
	public Entity<K,V> setNextNode(Entity<K,V> next) {
		return this.nextNode = next;
	}
	
	
	public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }
	
	public final boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof Entity) {
          Node<K,K> e = (Node<K,K>)o;

        	if(this.key.equals(e.getKey()) && this.value.equals(e.getValue())) {
        		return true;
        	}
        }
        return false;
    }
}

