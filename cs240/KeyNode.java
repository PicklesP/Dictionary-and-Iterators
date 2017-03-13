package cs240;

public class KeyNode<K, V>{
	
	KeyNode nextNode;
	K key;
	ValueNode value;
	int numValues;
	
	public KeyNode(K key, V value, KeyNode nextNode){
		this.key = key;
		this.value = new ValueNode(value, nextNode.getValueNode());
		this.nextNode = nextNode;
		numValues = 1;
	}
	
	public K getKey(){
		return key;
	}
	
	public void setKey(K key){
		this.key = key;
	}
	
	public KeyNode getNextNode(){
		return nextNode;
	}
	
	public void setNextNode(KeyNode nextNode){
		this.nextNode = nextNode;
	}
	
	public ValueNode getValueNode(){
		return value;
	}
	
	public int getNumValues(){
		return numValues;
	}
	
	public void addValue(V value){
		ValueNode newValue = new ValueNode(value, nextNode.getValueNode());
		this.value.setNextNode(newValue);
		numValues++;
	}
	
	class ValueNode{
		ValueNode nextNode;
		V value;
		
		public ValueNode(V value, ValueNode nextNode){
			this.value = value;
			this.nextNode = nextNode;
		}
		
		public V getValue(){
			return value;
		}
		
		public void setValue(V value){
			this.value = value;
		}
		
		public ValueNode getNextNode(){
			return nextNode;
		}
		
		public void setNextNode(ValueNode nextNode){
			this.nextNode = nextNode;
		}
	}
}