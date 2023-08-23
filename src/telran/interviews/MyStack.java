package telran.interviews;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyStack<T> {
	private LinkedList<T> myLinkedList;
	private ArrayList<T> maxValues;
	private Comparator<T> comparator;

	public MyStack(Comparator<T> comp) {
		comparator = comp;		
		myLinkedList = new LinkedList<T>();
		maxValues = new ArrayList<T>();

	}

	@SuppressWarnings("unchecked")
	public MyStack() {
		this((Comparator<T>) Comparator.naturalOrder());
	}

	public void push(T element) {
		myLinkedList.add(element);
		if (maxValues.isEmpty() || comparator.compare(element, maxValues.get(maxValues.size() - 1)) >= 0) {
			maxValues.add(element);
		} else {
			maxValues.add(maxValues.get(maxValues.size() - 1));
		}		
	}

	public T pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("empty stack");
		}
		T removedElement = myLinkedList.removeLast();
		maxValues.remove(maxValues.size() - 1);		
		return removedElement;
	}

	public boolean isEmpty() {
		if (myLinkedList.size() == 0 && maxValues.size() == 0) {
			return true;
		}
		return false;
	}

	public T getMax() {
		if (isEmpty()) {
			throw new NoSuchElementException("empty stack");
		}

		return maxValues.get(maxValues.size() - 1);
	}

	@SuppressWarnings("unchecked")
	public T[] toArray() {
		return (T[]) myLinkedList.toArray();
	}
}