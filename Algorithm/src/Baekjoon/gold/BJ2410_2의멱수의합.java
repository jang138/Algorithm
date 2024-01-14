package Baekjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/2410
 * 골드5 2의 멱수의 합
 */

public class BJ2410_2의멱수의합 {

	static final int mod = 1000000000;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[] = new int[1000001];

		dp[1] = 1;
		dp[2] = 2;

		/*
		 * 홀수일 때: 이전 수식에 +1
		 * 짝수일 때: 이전 수식에 +1 / 그리고 i/2 식에서 x2
		 * ex) 4 => (1+1+1) +1 / (1+1) +2 / (1+1) X2 / 2 X2
		 */
		
		for (int i = 3; i < 1000001; i++) {
			if (i % 2 == 1) {
				dp[i] = dp[i - 1];
			} else {
				dp[i] = (dp[i - 1] + dp[i / 2]) % mod;
			}
		}

//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N] % mod);
	}

}
