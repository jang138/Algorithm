package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/8979
 * 실버5 올림픽
 */

public class BJ8979_올림픽 {

	static class Medal {
		int number;
		int gold;
		int silver;
		int bronze;

		public Medal(int number, int gold, int silver, int bronze) {
			this.number = number;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		@Override
		public String toString() {
			return number + " / gold=" + gold + ", silver=" + silver + ", bronze=" + bronze;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<Medal> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.gold == o2.gold) {
				if (o1.silver == o2.silver) {
					return o2.bronze - o1.bronze;
				}
				return o2.silver - o1.silver;
			}
			return o2.gold - o1.gold;
		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			pq.add(new Medal(n, g, s, b));
		}

		int rank = 1;
		int same = 0;

		Medal m = pq.poll();
		if (m.number == K) {
			System.out.println(rank);
			return;
		}

		int beforeG = m.gold;
		int beforeS = m.silver;
		int beforeB = m.bronze;

		while (!pq.isEmpty()) {
			m = pq.poll();
			//System.out.println(m);

			// 이전 나라의 기록과 다르다면 (순위가 동률이 아니라면)
			if (!(beforeG == m.gold && beforeS == m.silver && beforeB == m.bronze)) {
				beforeG = m.gold;
				beforeS = m.silver;
				beforeB = m.bronze;
				
				rank++;
				
				// 앞선 동순위 나라들 개수만큼 더해준다
				if(same > 0) {
					rank +=same;
					same = 0;
				}
				
			} else {
				same++;
			}
			
			if (m.number == K) {
				System.out.println(rank);
				break;
			}

		}


	}

}
