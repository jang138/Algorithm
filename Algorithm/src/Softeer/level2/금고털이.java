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

	static class Jewel {
		int weight;
		int price;

		public Jewel(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		PriorityQueue<Jewel> pq = new PriorityQueue<>((o1, o2) -> {
			return o2.price - o1.price;
		});

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			pq.offer(new Jewel(weight, price));
		}

		int answer = 0;

		while (!pq.isEmpty()) {
			Jewel jewel = pq.poll();
			if (W < jewel.weight) {
				answer = answer + W * jewel.price;
				break;
			} else {
				answer = answer + jewel.weight * jewel.price;
				W = W - jewel.weight;
			}
		}

		System.out.print(answer + "");
	}
}