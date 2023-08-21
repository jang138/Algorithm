package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/11724
 * 실버2 연결 요소의 개수
 */

public class BJ11724_연결요소의개수_dfs {

	static int N, M;
	static boolean check[];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		check = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		int ans = 0;
		for (int i = 1; i <= N; i++) {
//			System.out.println(check[i]);
			if (!check[i]) {
				ans++;
				dfs(i);
			}
		}

		System.out.println(ans);
	}

	private static void dfs(int num) {
		check[num] = true;
//		System.out.println(num);

		for (int now : graph.get(num)) {
			if (!check[now]) {
				dfs(now);
			}
		}
	}

}
