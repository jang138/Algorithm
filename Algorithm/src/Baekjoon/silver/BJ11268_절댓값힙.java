package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * https://www.acmicpc.net/problem/11286
 * 실버1 절댓값 힙
 */

public class BJ11268_절댓값힙 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int abso1 = Math.abs(o1);
			int abso2 = Math.abs(o2);

			if (abso1 == abso2) {
				return o1 - o2;
			}
			return abso1 - abso2;
		});

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				pq.add(input);
			}
		}

	}

}
