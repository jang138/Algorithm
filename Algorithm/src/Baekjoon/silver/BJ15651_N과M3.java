package Baekjoon.silver;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/15651
 * 실버3 N과 M 3
 */

public class BJ15651_N과M3 {

	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];

		dfs(0);

		System.out.println(sb.toString());
	}

	private static void dfs(int depth) {
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');

			return;
		}

		for (int i = 1; i <= N; i++) {
			//System.out.println(depth + " " + i);

			arr[depth] = i;
			dfs(depth + 1);

			//System.out.println("after dfs");

		}
	}

}
