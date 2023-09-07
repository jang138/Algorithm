package Programmers.LV3;

import java.util.Arrays;
import java.util.Scanner;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898
 * LV3 등굣길
 */

public class 등굣길 {

	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int puddles[][] = { { 2, 2 } };
		int answer = solution(m, n, puddles);

		System.out.println(answer);
	}

	private static int solution(int m, int n, int[][] puddles) {
		int mod = 1000000007;
		int dp[][] = new int[n + 1][m + 1];

		for (int[] pud : puddles) {
			dp[pud[1]][pud[0]] = -1;
		}

		dp[1][1] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (dp[i][j] == -1) {
					dp[i][j] = 0;
					continue;
				}

				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1] + dp[i][j]) % mod;

			}
		}

		return dp[n][m] % mod;
	}
}
