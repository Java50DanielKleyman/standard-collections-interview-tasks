package add14;

import java.util.Arrays;
import java.util.Iterator;
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
		if (it.next() == null) {
			return false;
		}
		if (!(it.next() instanceof Iterable) && !it.next().getClass().isArray()) {
			next = (E) it.next();
			return true;
		}
		if (it.next() instanceof Iterable) {
			return stackIterable();
		}
		return stackArray();
	}

	private boolean stackArray() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean stackIterable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return this;
	}
}