package Baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/15649
 * 실버3 N과 M 1
 */

public class BJ15649_N과M1 {

	static int N, M;
	static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];
		visit = new boolean[N];

		dfs(0);
		
		
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
//			System.out.println("==return==");
			return;
		}

		for (int i = 0; i < N; i++) {
//			System.out.println("visit : " + i + " depth : " + depth + " " + visit[i]);
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				dfs(depth + 1);
				visit[i] = false;
			}
		}
		
		
//		System.out.println("=================================");
	}

}
