package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2606
 * 실버3 바이러스
 */

public class BJ2606_바이러스2 {
	static int N, M;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] check;
	static int dfsCNT = 0, bfsCNT = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

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
		check = new boolean[N + 1];
		dfs(1);
		System.out.println(dfsCNT);
*/
		
		check = new boolean[N + 1];
		bfs(1);
		System.out.println(bfsCNT);

	}

	private static void dfs(int n) {
		check[n] = true;

		for (int i : graph.get(n)) {
			if (!check[i]) {
				dfsCNT++;
				dfs(i);
			}
		}
	}

	private static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		check[n] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i : graph.get(now)) {
				if (!check[i]) {
					bfsCNT++;
					queue.add(i);
					check[i] = true;
				}
			}
		}

	}

}
