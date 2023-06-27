package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/9095
 * 실버3 1, 2, 3 더하기
 */

public class BJ9095_123더하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int dp[] = new int[12];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i < 12; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}

}


