package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/11053
 * 실버2 가장 긴 증가하는 부분 수열
 */

public class BJ11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int seq[] = new int[N];
		int dp[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;

		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			int max = 0;

			for (int j = 0; j < i; j++) {
				if (seq[j] < seq[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + 1;
			ans = Math.max(ans, dp[i]);
		}

//		System.out.println(Arrays.toString(dp));
		System.out.println(ans);

	}

}
