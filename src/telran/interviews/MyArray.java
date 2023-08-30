package telran.interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * All methods of the class should have complexity O[1]
 * 
 * @author User
 *
 * @param <T>
 */
public class MyArray<T> {
	Map<Integer, T> map;
	int size;

	public MyArray(int size) {
		map = new HashMap<>(size);
		this.size = size;
	}

	/**
	 * sets all array's elements with a given value
	 * 
	 * @param value
	 */
	public void setAll(T value) {

		for(int i = 0; i < size; i++) {
			map.put(i, value);
		}
	}


	/**
	 * 
	 * @param index
	 * @return value at given index or null if index is wrong
	 */
	public T get(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return map.get(index);
	}

	/**
	 * sets a given value at a given index throws IndexOutOfBoundsException in the
	 * case of wrong index
	 * 
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		map.put(index, value);
	}
}