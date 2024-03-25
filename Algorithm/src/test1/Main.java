package test1;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws Exception {
		HashMap<String, Integer> map = new HashMap<>();

		map.put("apple", 1);
		map.put("banana", 1);
		map.put("orange", 1);

		String key = "hi";

		if (map.containsKey(key)) {
			int value = map.get(key);
			System.out.println(map.get(key));
		} else {
			System.out.println("no");
		}

	}

}
