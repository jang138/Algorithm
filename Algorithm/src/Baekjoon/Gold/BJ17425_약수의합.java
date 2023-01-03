package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/17425
 * 골드4 약수의 합
 */

public class BJ17425_약수의합 {
	static final int MAX = 1000001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long f[] = new long[MAX];
		long g[] = new long[MAX];

		// 에라토스테네스의 체 f()
		Arrays.fill(f, 1);

		for (int i = 2; i < MAX; i++) {
			for (int j = 1; i * j < MAX; j++) {
				f[i * j] += i;
			}
		}

		// g()
		for (int i = 1; i < MAX; i++) {
			g[i] = g[i - 1] + f[i];
		}

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(g[n]).append("\n");
		}
		System.out.println(sb);
	}

}