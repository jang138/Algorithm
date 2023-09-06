package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/11725
 * 실버2 트리의 부모 찾기
 */

public class BJ11725_트리의부모찾기_dfs {

	static int N;
	static boolean[] visit;
	static int[] parentNode;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		visit = new boolean[N + 1];
		parentNode = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph.get(x).add(y);
			graph.get(y).add(x);
		}

		dfs(1);

		for (int i = 2; i <= N; i++) {
			sb.append(parentNode[i]).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void dfs(int n) {
		visit[n] = true;

		for (int node : graph.get(n)) {
			if (!visit[node]) {
				visit[node] = true;
				parentNode[node] = n;
				dfs(node);
			}
		}
	}

}
