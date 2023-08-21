package Baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/1697
 * 실버1 숨바꼭질
 */

public class BJ1697_숨바꼭질 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();

		if (start == end) {
			System.out.println(0);
			return;
		}

		int ans = 0;
		int check[] = new int[100001];
		Queue<Integer> queue = new LinkedList<>();

		queue.add(start);
		check[start] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 0; i < 3; i++) {
				int next;

				if (i == 0) {
					next = now * 2;
				} else if (i == 1) {
					next = now + 1;
				} else {
					next = now - 1;
				}

				if (next == end) {
					System.out.println(check[now]);
					return;
				}

				if (next >= 0 && next < check.length && check[next] == 0) {
					queue.add(next);
					check[next] = check[now] + 1;
				}
			}

		}

	}

}
