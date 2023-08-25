package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1010
 * 실버5 다리 놓기
 */

/*
 * 조합의 성질
 * 1번: n+1 C r+1 = n C r + n C r+1
 * 2번: n C 0 = n C n = 1
 */

public class BJ1010_다리놓기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		int[][] dp = new int[30][30];

		// 2번 성질 (n == r, r == 0)
		for (int i = 0; i < 30; i++) {
			dp[i][i] = 1;
			dp[i][0] = 1;
		}

		for (int i = 2; i < 30; i++) {
			for (int j = 1; j < 30; j++) {
				// 1번 성질
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			System.out.println(dp[M][N]);
		}

	}

}
