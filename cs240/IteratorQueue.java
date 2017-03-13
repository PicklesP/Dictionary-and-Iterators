package cs240;

import java.util.Iterator;
import java.util.Queue;

public class IteratorQueue<T> implements Iterator<T>{

	Queue queue;
	
	@Override
	public boolean hasNext() {
		return(!queue.isEmpty());
	}

	@Override
	public T next() {
		T result;
		if(hasNext()){
			result = queue.dequeue();
			return result;
		}
		throw new NoSuchElementException("No more elements in the queue");
	}

}
