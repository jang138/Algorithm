package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/13023
 * 골드5 ABCDE
 */

public class BJ13023_ABCDE {

	static ArrayList<Integer>[] A;
	static boolean visit[];
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		A = new ArrayList[N];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			A[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}

		for (int i = 0; i < N; i++) {
			dfs(i, 1);

			if (flag) {
				break;
			}
		}
		
		System.out.println(flag ? 1 : 0);

	}

	private static void dfs(int n, int depth) {
		if (depth == 5 || flag) {
			flag = true;
			return;
		}
		
		visit[n] = true;
		
		for (int i : A[n]) {
			if(!visit[i]) {
				dfs(i, depth + 1);
			}
		}
		
		// 탐색이 끝날 때 다시 false로 바꿔준다.
		visit[n] = false;
	}

}
