package Baekjoon.silver;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/10844
 * 실버1 쉬운 계단 수
 */

public class BJ10844_쉬운계단수 {

	final static long mod = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		/*
		 * dp[i][j] = i번째 자리수의 값이 j일때 
		 * dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] 
		 * 단 끝자리가 0이나 9인 경우, 1과 8 밖에 오지 않는다.
		 */

		long dp[][] = new long[N + 1][10];

		// 첫번째 자리수 = 일의 자리이므로 경우의 수가 하나씩 밖에 없다.
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][0] = dp[i - 1][1] % mod;
					continue;
				}

				if (j == 9) {
					dp[i][9] = dp[i - 1][8] % mod;
					continue;
				}

				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
			}
		}

		long sum = 0;
		
		for (int i = 0; i < 10; i++) {
			sum += dp[N][i];
		}
		
		System.out.println(sum % mod);
	}

}
