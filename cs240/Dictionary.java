package cs240;

import java.util.Iterator;

import cs240.KeyNode.ValueNode;

public class Dictionary<K, V> implements DictionaryInterface<K, V> {

	KeyNode firstKey;
	int numKeys;
	Iterator keyIterator;
	Iterator valueIterator;
	
	public Dictionary(){
		numKeys = 0;
	}
	
	@Override
	public void add(K key, V value) {
		if(contains(key)){
			KeyNode currentNode = firstKey;
			while(!currentNode.getKey().equals(key))
				currentNode = currentNode.getNextNode();
			currentNode.addValue(value);
		}
		else{
			KeyNode newNode = new KeyNode(key, value, firstKey);
			firstKey = newNode;
		}
	}

	@Override
	public V[] remove(K key) {
		if(!contains(key))
			return null;
		KeyNode currentNode = firstKey;
		KeyNode previousNode = null;
		V[] value = getValue(key);
		while(!currentNode.equals(key)){
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		previousNode.setNextNode(currentNode.getNextNode());
		numKeys--;
		return value;
	}

	@Override
	public V[] getValue(K key) {
		if(!contains(key))
			return null;
		KeyNode currentNode = firstKey;
		while(!currentNode.equals(key))
			currentNode = currentNode.getNextNode();
		V[] result = (V[]) new Object[currentNode.getNumValues()];
		ValueNode value = currentNode.getValueNode();
		for(int i = 0; i < currentNode.getNumValues(); i++){
			result[i] = (V) value.getValue();
			value = value.getNextNode();
		}
		return result;
	}

	@Override
	public boolean contains(K key) {
		Iterator search = getKeyIterator();
		boolean exists = false;
		do{
			K entry = (K) search.next();
			if(entry.equals(key) && entry != null)
				exists = true;
			else if(entry == null)
				return false;
		}while(!exists);
		return exists;
	}

	@Override
	public Iterator getKeyIterator() {
		keyIterator = new IteratorDictionary(firstKey);
		return keyIterator;
	}

	@Override
	public Iterator<V> getValueIterator() {
		valueIterator = new IteratorDictionary(firstKey.getValueNode());
		return valueIterator;
	}

	@Override
	public boolean isEmpty() {
		return(firstKey == null);
	}

	@Override
	public int getSize() {
		return numKeys;
	}

	@Override
	public void clear() {
		firstKey = null;
		numKeys = 0;
	}

}
