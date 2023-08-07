package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/11722
 * 실버2 가장 긴 감소하는 부분 수열
 */

public class BJ11722_가장긴감소하는부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int seq[] = new int[N];
		int dp[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int max = 0;

			for (int j = 0; j < i; j++) {
				if (seq[j] > seq[i]) {
					max = Math.max(max, dp[j]);
				}
			}

			dp[i] = max + 1;
			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans);

	}

}
