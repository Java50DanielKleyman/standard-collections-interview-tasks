package add14;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * TODO: implement methods below to support the following functionality...
 * 
 * This is Nested Flatten Iterator, which is able to iterate over specified type
 * of objects, extracting them from nested collection. (Example: iterate over
 * all Strings in the list of sets of arrays of String-s. etc.) - The iterator
 * could be constructed from any list of objects, including other Iterators,
 * Iterable-s (Collections, etc.) and arrays of any dimensions. - The iterator
 * is Iterable itself. - The iterator permits usage of null values in the nested
 * collections - The implementation does not use recursion. - Note: actually
 * this is not final solution because it is type-unsafe (heap poluition is
 * possible)
 */
public class NestedIterator<E> implements Iterator<E>, Iterable<E> {

	private E next;
	private boolean hasNext;	
	private LinkedList<Iterator<?>> stack;

	public NestedIterator(Object... params) {
		List<Object> paramList = Arrays.asList(params);
		stack = new LinkedList<>();
		stack.push(paramList.iterator());
		findNext();
	}

	@SuppressWarnings("unchecked")
	private void findNext() {
		while (!stack.isEmpty()) {
			Iterator<?> current = stack.peek();
			if (current.hasNext()) {
				Object item = current.next();
				if (item == null) {
					next = null;
					hasNext = true;
					return;
				} else if (item instanceof Iterable) {
					stack.push(((Iterable<?>) item).iterator());
				} else if (item.getClass().isArray()) {
					stack.push(Arrays.asList((Object[]) item).iterator());
				} else {
					next = (E) item;
					hasNext = true;
					return;
				}
			} else {
				stack.pop();
			}
		}
		hasNext = false;
	}

	@Override
	public boolean hasNext() {
		return hasNext;
	}

	@Override
	public E next() {
		if (!hasNext) {
			throw new NoSuchElementException();
		}
		E result = next;
		findNext();
		return result;
	}

	@Override
	public Iterator<E> iterator() {
		return this;
	}

}