package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2258
 * 골드4 정육점
 */

public class BJ2258_정육점 {

	static class Meat {
		int weight;
		int price;

		public Meat(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}

		@Override
		public String toString() {
			return "weight=" + weight + ", price=" + price;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 덩어리 개수
		int M = Integer.parseInt(st.nextToken()); // 필요한 고기의 양

		// 가격이 싸고 무게가 무거운 고기가 좋다 => 가격 오름차순, 무게 내림차순
		PriorityQueue<Meat> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.price == o2.price) {
				return o2.weight - o1.weight;
			}
			return o1.price - o2.price;
		});

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			pq.offer(new Meat(w, p));
		}

		int sum = 0; // 고기 무게 합
		int totalPrice = 0; // 고기 가격 합
		int before = -1;
		int same = 0;
		int ans = Integer.MAX_VALUE;
		boolean flag = false;

		while (!pq.isEmpty()) {
			Meat m = pq.poll();

			int weight = m.weight;
			int price = m.price;

			if (before != price) {
				before = price;
				same = 0;
			} else {
				same += price;
			}

			sum += weight;
			totalPrice = price;

			if (sum >= M) {
				flag = true;
				ans = Math.min(ans, totalPrice + same);
			}

		}

		System.out.println(flag ? ans : -1);

	}

}
