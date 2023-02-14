package Baekjoon.gold;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/17268
 * 골드3 미팅의 저주
 */

// 카탈린 수열
public class BJ17268_미팅의저주 {

	static final int NUM = 987654321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		N = N / 2;
		int dp[] = new int[N + 1];
		dp[0] = 1;

		// 점화식: Cn+1 = C0Cn + C1Cn-1 + C2Cn-2 + ... + CnC0
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += ((dp[j] % NUM) * (dp[i - 1 - j] % NUM)) % NUM;
			}
			dp[i] %= NUM;
		}

		System.out.println(dp[N]);

	}

}
