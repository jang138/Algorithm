package Baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/2164
 * 실버4 카드2
 */

public class BJ2164_카드2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		while (queue.size() > 1) {
			// 1. 맨 위 카드를 버린다.
			queue.poll();

			// 2. 다음 맨 위 카드는 맨 아래로 넣는다.
			int bottom = queue.poll();
			queue.add(bottom);
		}

		System.out.println(queue.poll());
	}

}
