package Softeer.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * https://softeer.ai/practice/info.do?idx=1&eid=395
 * 금고털이
 */
/*
100 2
90 1
70 2
*/

public class 금고털이 {
	public static class Jewel {
		int weight;
		int value;

		public Jewel(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}

		public String toString() {
			return weight + " " + value;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		PriorityQueue<Jewel> pq = new PriorityQueue<>((o1, o2) -> (o2.value - o1.value));

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int ans = 0;
		while (!pq.isEmpty()) {
			Jewel j = pq.poll();

			if (W > j.weight) {
				ans += j.weight * j.value;
				W -= j.weight;
			} else {
				ans += W * j.value;
				break;
			}
		}

		System.out.println(ans);
	}
}
