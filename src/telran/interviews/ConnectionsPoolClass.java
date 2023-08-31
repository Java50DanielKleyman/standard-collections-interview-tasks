package telran.interviews;

import java.util.LinkedHashMap;

public class ConnectionsPoolClass implements ConnectionsPool {
	LinkedHashMap<Integer, Connection> map;
	int size;

	public ConnectionsPoolClass(int size) {
		this.size = size;
		map = new LinkedHashMap<>(size, 0.75f, true);
	}

	@Override
	public boolean addConnection(Connection connection) {
		if (map.get(connection.getId()) == null) {
			if (map.size() == size) {
				map.remove(map.keySet().iterator().next());
			}
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
