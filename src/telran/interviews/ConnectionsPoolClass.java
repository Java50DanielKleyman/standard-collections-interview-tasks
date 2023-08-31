package telran.interviews;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConnectionsPoolClass implements ConnectionsPool {
	LinkedHashMap<Integer, Connection> map;
	int size;

	@SuppressWarnings("serial")
	public ConnectionsPoolClass(int size) {
		this.size = size;
		map = new LinkedHashMap<Integer, Connection>(16, 0.75f, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, Connection> entry) {
				return size() > size;
			};
		};
	}

	@Override
	public boolean addConnection(Connection connection) {
		if (map.get(connection.getId()) == null) {
			map.put(connection.getId(), connection);

			return true;
		}
		return false;

	}

	@Override
	public Connection getConnection(int id) {
		return map.get(id);
	}

	public int size() {
		return map.size();
	}
}
