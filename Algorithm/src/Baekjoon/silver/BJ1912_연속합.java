package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1912
 * 실버2 연속합
 */

public class BJ1912_연속합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int seq[] = new int[N];
		int dp[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = seq[0];
		int ans = dp[0];
		
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i-1] + seq[i], seq[i]);
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
	}

}
