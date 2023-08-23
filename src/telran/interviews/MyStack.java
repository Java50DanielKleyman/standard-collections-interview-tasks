package telran.interviews;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class MyStack<T> {
	private LinkedList<T> myLinkedList = new LinkedList<T>();
	
	private PriorityQueue<T> myPriorityQueue; 
	
	public MyStack(Comparator<T> comp) {
		  myPriorityQueue = new PriorityQueue<>(comp);
		
	}
	@SuppressWarnings("unchecked")
	public MyStack() {
		this((Comparator<T>) Comparator.reverseOrder());
	}
	
  public void push(T element) {
	  myLinkedList.add(element);
	  myPriorityQueue.add(element);
  }
  public T pop() {
	 if(isEmpty()) {
		 throw new NoSuchElementException("empty stack");
	 }	 
	 T removedElement = myLinkedList.removeLast();
	  myPriorityQueue.remove(removedElement);
	 
	  return removedElement;
  }
  public boolean isEmpty() {
	  if(myLinkedList.size() == 0 && myPriorityQueue.size()==0) {
		  return true;
	  }
	  return false;
  }
  public T getMax() {
	  if(isEmpty()) {
			 throw new NoSuchElementException("empty stack");
		 }	  
	 
	  return myPriorityQueue.peek();
  }
  @SuppressWarnings("unchecked")
public T [] toArray() {
	  return (T[]) myLinkedList.toArray();
  }
}