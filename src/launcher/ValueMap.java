package launcher;

import java.util.HashMap;

public class ValueMap {

	HashMap<String, Number> map;

	public ValueMap() {
		super();
		this.map = new HashMap<String, Number>();
	}

	public Number getValue(String name) {
		if (this.map.containsKey(name)) {
			return this.map.get(name);
		} else {
			throw new UnsupportedOperationException("Value not found for : " + name);
		}
	}

	public void put(String key, Number val) {
		this.map.put(key, val);
	}

	public String printValMap() {
		StringBuilder sb = new StringBuilder();
		this.map.keySet().forEach(key -> {
			sb.append("[");
			sb.append(key);
			sb.append(":");
			sb.append(this.map.get(key));
			sb.append("]");
		});
		return sb.toString();
	}
}
