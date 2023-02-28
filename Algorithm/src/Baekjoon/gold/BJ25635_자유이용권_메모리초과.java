package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/25635
 * 골드4 자유 이용권
 */

public class BJ25635_자유이용권_메모리초과 {

	static class Rides {
		int number;
		int count;

		public Rides(int number, int count) {
			this.number = number;
			this.count = count;
		}

		@Override
		public String toString() {
			return "number=" + number + ", count=" + count;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 탑승 기회가 많은 놀이기구 순으로 정렬
		PriorityQueue<Rides> pq = new PriorityQueue<>((o1, o2) -> {
			return o2.count - o1.count;
		});

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int count = Integer.parseInt(st.nextToken());
			pq.offer(new Rides(i, count));
		}

		ArrayList<Integer> arrayList = new ArrayList<>();
		Rides rd = pq.poll();
		arrayList.add(rd.number);

		if (rd.count > 1) {
			pq.offer(new Rides(rd.number, rd.count - 1));
		}

		int ans = 1;
		while (!pq.isEmpty()) {
			Rides rides = pq.poll();
//			System.out.println(rides);

			if (arrayList.get(arrayList.size() - 1) == rides.number) {
				if (pq.isEmpty()) {
					break;
				}

				Rides next = pq.poll();
				arrayList.add(next.number);

				if (next.count > 1) {
					pq.offer(new Rides(next.number, next.count - 1));
				}

				ans++;
				pq.offer(rides);
			}

			else {
				arrayList.add(rides.number);
				if (rides.count > 1) {
					pq.offer(new Rides(rides.number, rides.count - 1));
				}
				ans++;
			}
		}

		System.out.println(ans);
	}

}
