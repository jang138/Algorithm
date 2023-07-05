package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/9465
 * 실버1 스티커
 */

public class BJ9465_스티커 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int input[][] = new int[2][n + 1];
			int dp[][] = new int[2][n + 1];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][1] = input[0][1];
			dp[1][1] = input[1][1];

			/*
			 * 점화식: (0,1)에 해당하는 위치에서 다음에 올 스티커는 (1,2) (1,3) 중 큰 것이다
			 */
			for (int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + input[0][i];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + input[1][i];
			}

			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}

	}

}
