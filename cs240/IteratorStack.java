package cs240;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class IteratorStack<T> implements Iterator<T>{

	Stack<T> stack;
	T previous;
	T next;
	
	public IteratorStack(Stack<T> stack){
		this.stack = stack;
		previous = null;
		next = stack.pop();
	}
	
	@Override
	public boolean hasNext() {
		return (stack.peek() != null);
	}

	@Override
	public T next() {
		T result;
		if(hasNext()){
			result = next;
			previous = next;
			next = stack.pop();
			return result;
		}
		throw new NoSuchElementException("No more elements in the stack.");
	}
}
