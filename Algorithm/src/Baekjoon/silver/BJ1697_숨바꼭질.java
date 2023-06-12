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

		int ans = 0;
		boolean check[] = new boolean[100001];
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { start, 0 });
		check[start] = true;

		while (!queue.isEmpty()) {
			int now[] = queue.poll();

			if (now[0] == end) {
				ans = now[1];
				break;
			}



		}

		System.out.println(ans);
	}

}
