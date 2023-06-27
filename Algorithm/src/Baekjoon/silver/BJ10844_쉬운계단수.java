package Baekjoon.silver;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/10844
 * 실버1 쉬운 계단 수
 */

public class BJ10844_쉬운계단수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long dp[] = new long[N + 1];
		dp[1] = 9;
		dp[2] = 17;
		
		for (int i = 3; i <= N; i++) {
			dp[i] = (2 * (dp[i - 1] - 2) + 2) % 1000000000;
		}

		System.out.println(dp[N]);
	}

}
