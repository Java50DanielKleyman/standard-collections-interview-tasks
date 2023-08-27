package add14;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
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
	Iterator<?> it;
	E[] array;

	@SuppressWarnings("unchecked")
	public NestedIterator(Object... params) {
		array = (E[]) params;
		it = Arrays.asList(array).iterator();
		// findNext();
		hasNext = it.hasNext();
		next = getNext();
	}

	private E getNext() {
		findNext();
		return next;
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
		hasNext = findNext();
		return result;
	}

	@SuppressWarnings("unchecked")
	private boolean findNext() {
		if (!it.hasNext()) {
			return false;
		}

		Object nextItem = it.next();
		if (nextItem == null) {
			return false;
		}

		if (!(nextItem instanceof Iterable) && !nextItem.getClass().isArray()) {
			next = (E) nextItem;
			return true;
		}

		return stackIterable(nextItem);
	}

	@SuppressWarnings("unchecked")
	private boolean stackIterable(Object nextItem) {
		LinkedList<Object> stack = new LinkedList<>();
		Iterator<Object> iterator = null;
		if (nextItem.getClass().isArray()) {
			iterator = Arrays.asList((Object[]) nextItem).iterator();
		} else {
			iterator = (Iterator<Object>) ((Iterable<?>) nextItem).iterator();
		}
		stack.add(iterator);

		while (!stack.isEmpty()) {
			Iterator<?> current = (Iterator<?>) stack.peek();
			if (current.hasNext()) {
				Object item = current.next();
				if (item instanceof Iterable) {
					stack.push(((Iterable<?>) item).iterator());
				} else if (item.getClass().isArray()) {
					stack.push(Arrays.asList((Object[]) item).iterator());
				} else {
					next = (E) item;
					return true;
				}
			} else {
				stack.pop();
			}
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return this;
	}
}