package Softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ex1 {

	static int N;

	static class Tag {
		String key;
		String value;

		public Tag(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		Map<Integer, ArrayList<Tag>> map = new HashMap<>();

		for (int n = 1; n <= N; n++) {
			map.put(n, new ArrayList<>());
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();

			if (!input.contains(",")) {
				String[] split = input.split("=");
				map.get(n).add(new Tag(split[0], split[1]));
			} else {
				String[] inputArr = input.split(",");
				for (int i = 0; i < inputArr.length; i++) {
					String[] split = inputArr[i].split("=");
					map.get(n).add(new Tag(split[0], split[1]));
				}
			}

		}
		
		System.out.println(map);

	}

}
