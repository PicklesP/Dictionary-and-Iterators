package cs240;

import java.util.Iterator;
import java.util.List;

public class IteratorList<T> implements Iterator {

	List list;
	int index;
	
	public IteratorList(){
		index = 0;
	}
	
	@Override
	public boolean hasNext() {
		return (!list.isEmpty());
	}

	@Override
	public T next() {
		T result;
		if(hasNext()){
			result = (T) list.remove(index);
			index++;
			return result;
		}
		throw new NoSuchElementException("No more elements in the list.");
	}

}
