package Baekjoon.gold;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/2023
 * 골드5 신기한 소수
 */

public class BJ2023_신기한소수 {

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);

	}

	private static void dfs(int n, int d) {
		if (d == N) {
			if (isPrime(n)) {
				System.out.println(n);
			}
			return;
		}

		for (int i = 1; i < 10; i++) {
			// 짝수는 탐색할 필요 없음
			if (i % 2 == 0)
				continue;

			// 소수라면 다음 자릿수 늘려서 판별
			if (isPrime(n * 10 + i)) {
				dfs(n * 10 + i, d + 1);
			}
		}
	}

	private static boolean isPrime(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
