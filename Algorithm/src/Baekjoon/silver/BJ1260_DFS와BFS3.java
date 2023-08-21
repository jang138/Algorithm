package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1260
 * 실버2 DFS와 BFS
 */

public class BJ1260_DFS와BFS3 {

	static int N, M, V;
	static boolean visit[];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			graph.get(s).add(e);
			graph.get(e).add(s);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}

		/*
		 * for (int i = 0; i <= N; i++) { System.out.println(graph.get(i)); }
		 */

		visit = new boolean[N + 1];
		dfs(V);
		System.out.println();
		visit = new boolean[N + 1];
		bfs(V);

	}

	private static void dfs(int n) {
		System.out.print(n + " ");
		visit[n] = true;

		for (int i : graph.get(n)) {
			if (!visit[i]) {
				dfs(i);
			}
		}
	}

	private static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		visit[n] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");

			for (int i : graph.get(node)) {
				if (!visit[i]) {
					visit[i] = true;
					queue.add(i);
				}
			}
		}

	}

}