package Baekjoon.bronze;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/2748
 * 브론즈1 피보나치 수 2
 */

public class BJ2748_피보나치수2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long dp[] = new long[N + 1];

		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		System.out.println(dp[N]);
	}

}
