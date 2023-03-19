package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2579_계단오르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[N + 1];
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = stair[1];
		if (N >= 2)
			dp[2] = stair[1] + stair[2];

		// i-2와 i 가 선택된 경우
		// i-3 i-1 i 가 선택된 경우
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i];
		}

		System.out.println(dp[N]);
	}

}
