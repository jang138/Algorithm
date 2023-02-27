package Baekjoon.gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/16400
 * 골드5 소수 화폐
 */

public class BJ16400_소수화폐 {

	static final int MOD = 123456789;
	static boolean prime[];
	static ArrayList<Integer> primeList;
	static int dp[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		prime = new boolean[N + 1];
		primeList = new ArrayList<>();
		dp = new int[N + 1];

		Arrays.fill(prime, true);
		// 소수는 true 아니면 false
		prime[0] = prime[1] = false;

		// 에라토스테네스의 채
		for (int i = 2; i * i <= N; i++) {
			for (int j = i * i; j <= N; j += i) {
				prime[j] = false;
			}
		}

		for (int i = 0; i <= N; i++) {
			if (prime[i]) {
//				System.out.println(i);
				primeList.add(i);
			}
		}

		dp[0] = 1;
		for (int i = 0; i < primeList.size(); i++) {
			int primeMoney = primeList.get(i);
			for (int j = primeMoney; j <= N; j++) {
				dp[j] = (dp[j] + dp[j - primeMoney]) % MOD;
			}
		}

		System.out.println(dp[N]);

	}

}
