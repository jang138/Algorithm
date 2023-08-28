package Baekjoon.silver;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/15650
 * 실버3 N과 M 2
 */

public class BJ15650_N과M2 {

	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];

		dfs(0, 0);

		System.out.println(sb.toString());

	}

	private static void dfs(int depth, int start) {
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');

			return;
		}

		for (int i = start; i < N; i++) {
			arr[depth] = i + 1;
			dfs(depth + 1, i + 1);
		}
	}

}
