package telran.interviews;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStackTest {

	private MyStack<Integer> myStack;
	private Integer[] testArray = { 5, 12, 957, -30, 46, 85 };

	@BeforeEach
	void setUp() {
		myStack = new MyStack<>();
		for (Integer elm : testArray) {
			myStack.push(elm);
		}
	}

	@Test
	void pushTest() {
		Integer[] expected = { 5, 12, 957, -30, 46, 85 };
		assertArrayEquals(expected, myStack.toArray());
	}

	@Test
	void popTest() {
		Integer[] expected = { 5, 12, 957, -30, 46 };
		int removed = myStack.pop();
		assertArrayEquals(expected, myStack.toArray());
		assertEquals(85, removed);
		removed = myStack.pop();
		assertEquals(46, removed);
		for (int i = 0; i < expected.length - 1; i++) {
			myStack.pop();
		}
		assertThrowsExactly(NoSuchElementException.class, () -> myStack.pop());
	}

	@Test
	void isEmptyTest() {
		for (int i = 0; i < testArray.length; i++) {
			myStack.pop();
		}
		assertTrue(myStack.isEmpty());
	}

	@Test
	void getMaxTest() {
		assertEquals(957, myStack.getMax());
		myStack.pop();
		assertEquals(957, myStack.getMax());
		MyStack<Integer> newStack = new MyStack<Integer>();
		assertThrowsExactly(NoSuchElementException.class, () -> newStack.getMax());
	}
}
