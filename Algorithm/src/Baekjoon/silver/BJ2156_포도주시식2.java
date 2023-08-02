package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/2156
 * 실버1 포도주 시식
 */

public class BJ2156_포도주시식2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int dp[] = new int[N + 1];
		int input[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = input[1];

		for (int i = 2; i <= N; i++) {
			if (i == 2) {
				dp[i] = input[1] + input[2];
				continue;
			}

			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + input[i], dp[i - 3] + input[i - 1] + input[i]));
		}

		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);

	}

}
