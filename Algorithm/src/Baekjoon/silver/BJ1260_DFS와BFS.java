package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1260
 * 실버2 DFS와 BFS
 */

public class BJ1260_DFS와BFS {

	static int N, M, V;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (ArrayList<Integer> arrayList : graph) {
			Collections.sort(arrayList);
		}

		dfs(V);
		System.out.println(sb);
		Arrays.fill(visited, false);
		sb.setLength(0);
		bfs(V);
		System.out.println(sb);
	}

	public static void dfs(int n) {
		visited[n] = true;
		sb.append(n).append(" ");

		for (int target : graph.get(n)) {
			if (!visited[target]) {
				visited[target] = true;
				dfs(target);
			}
		}
	}

	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		visited[n] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			sb.append(node).append(" ");

			for (int target : graph.get(node)) {
				if (!visited[target]) {
					visited[target] = true;
					queue.add(target);
				}
			}
		}
	}

}
