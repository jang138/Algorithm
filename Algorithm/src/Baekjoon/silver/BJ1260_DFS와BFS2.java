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

public class BJ1260_DFS와BFS2 {

	static boolean visit[];
	static ArrayList<Integer>[] A;
	static ArrayList<ArrayList<Integer>> B;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
//		A = new ArrayList[N + 1];
		B = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
			B.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			A[s].add(e);
			A[e].add(s);
			
			B.get(s).add(e);
			B.get(e).add(s);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(A[i]);
			Collections.sort(B.get(i));
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(i + " => ");
			for (int j : A[i]) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i = 1; i <= N; i++) {
			System.out.print(i + " => ");
			for (int j : B.get(i)) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println();

		visit = new boolean[N + 1];
		dfs(start);
		System.out.println();
		visit = new boolean[N + 1];
		bfs(start);

	}

	private static void dfs(int n) {
		System.out.print(n + " ");
		visit[n] = true;

//		for (int i : A[n]) {
//			if (!visit[i]) {
//				dfs(i);
//			}
//		}
		
		for (int i : B.get(n)) {
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

//			for (int i : A[node]) {
//				if (!visit[i]) {
//					visit[i] = true;
//					queue.add(i);
//				}
//			}
			
			for (int i : B.get(node)) {
				if (!visit[i]) {
					visit[i] = true;
					queue.add(i);
				}
			}
		}
	}

}