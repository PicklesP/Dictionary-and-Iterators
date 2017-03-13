package cs240;

public class IteratorDictionary<K, V> implements java.util.Iterator{
	
	KeyNode previousNode;
	KeyNode nextNode;
	
	public IteratorDictionary(KeyNode firstNode){
		previousNode = null;
		nextNode = firstNode;
	}
	
	public boolean hasNext(){
		return (nextNode != null);
	}
	
	public Object next(){
		if(hasNext()){
			previousNode = nextNode;
			nextNode = nextNode.getNextNode();
		}
		
		return previousNode;
	}
}

