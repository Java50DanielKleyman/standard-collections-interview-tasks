package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.interviews.Connection;
import telran.interviews.ConnectionsPoolClass;

class ConnectionsPoolTests {
	ConnectionsPoolClass map;
	Connection connection1 = new Connection(123, "abc", 1);
	Connection connection2 = new Connection(124, "abcd", 2);
	Connection connection3 = new Connection(125, "abcde", 3);
	Connection connection4 = new Connection(126, "abcdef", 4);

	@BeforeEach
	void setUp() throws Exception {
		map = new ConnectionsPoolClass(3);
		map.addConnection(connection1);
		map.addConnection(connection2);
		map.addConnection(connection3);

	}

	@Test
	void addTest() {
		assertTrue(map.addConnection(connection4));
		assertFalse(map.addConnection(connection4));
		assertEquals(3, map.size());
		assertEquals(null, map.getConnection(connection1.getId()));
	}

	@Test
	void getConnectionTest() {
		assertEquals(null, map.getConnection(456));
		assertEquals(connection1, map.getConnection(connection1.getId()));
		map.addConnection(connection4);
		assertEquals(null, map.getConnection(connection2.getId()));

	}
}
