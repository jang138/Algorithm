package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2294
 * 골드5 동전2
 */

public class BJ2294_동전2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int coin[] = new int[n];
		int dp[] = new int[k + 1];
		Arrays.fill(dp, 10001);
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		for (int i : coin) {
			for (int j = i; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - i] + 1);
			}
		}

		System.out.println(dp[k] != 10001 ? dp[k] : -1);

	}

}
