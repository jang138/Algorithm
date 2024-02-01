package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * https://www.acmicpc.net/problem/11286
 * 실버1 절댓값 힙
 */

public class BJ11286_절댓값힙 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);

			if (abs1 == abs2) {
				return o1 - o2;
			}

			return abs1 - abs2;
		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());

			if (input == 0) {
				if (pq.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}

				continue;
			}

			pq.add(input);
		}

		System.out.println(sb);
	}
}
