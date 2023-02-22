package Baekjoon.silver;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/1463
 * 실버3 1로 만들기
 */

public class BJ1463_1로만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] memoi = new int[N + 1];

		// memoi[5] : 4 <= 5를 1로 만드는 데 최소 연산 횟수가 4

		memoi[1] = 0;

		for (int i = 2; i <= N; i++) {
			// 3가지 연산 각각에 대해서 따져본다. 최소값을 찾는다.

			// -1
			// 항상 할 수 있는 연산
			memoi[i] = memoi[i - 1] + 1;

			// /2
			if (i % 2 == 0)
				memoi[i] = Math.min(memoi[i], memoi[i / 2] + 1);

			// /3
			if (i % 3 == 0)
				memoi[i] = Math.min(memoi[i], memoi[i / 3] + 1);
		}

		System.out.println(memoi[N]);
	}

}
