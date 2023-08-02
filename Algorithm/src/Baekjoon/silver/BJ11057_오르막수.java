package Baekjoon.silver;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/11057
 * 실버1 오르막 수
 */

public class BJ11057_오르막수 {

	static final int mod = 10007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int dp[][] = new int[N + 1][10];

		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			dp[i][9] = 1;

			for (int j = 8; j >= 0; j--) {
				dp[i][j] += (dp[i - 1][j] + dp[i][j + 1]) % mod;
			}
		}

		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[N][i];
		}

		System.out.println(sum % mod);
	}

}
