package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1707
 * 골드4 이분 그래프
 */

public class BJ1707_이분그래프 {

	static boolean flag;
	static int check[];
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			check = new int[V + 1];
			graph = new ArrayList<>();
			for (int i = 0; i <= V; i++) {
				graph.add(new ArrayList<>());
			}

			int start = 0;
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				graph.get(u).add(v);
				graph.get(v).add(u);

				start = u;
			}

			flag = true;
			
			for (int i = 1; i <= V; i++) {
				if(check[i] == 0) {
					flag = flag && bfs(i);
				}
			}

			System.out.println(flag ? "YES" : "NO");
		}
	}

	private static boolean bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		check[num] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int node : graph.get(now)) {
				
				if (check[node] == check[now]) {
					return false;
				}

				if (check[node] == 0) {
					check[node] = -1 * check[now];
					queue.add(node);
				}

			}
		}
		
		return true;
	}

}

/*
 * 여러 그래프가 나올 수 있기 때문에 for문으로 방문하지 않은 정점을 check[i] == 0로 판별한다.
 * 여러 그래프 중 하나라도 조건을 만족하지 않을 시 NO를 출력해야 하므로
 * 연산된 bfs의 결과를 현재 flag와 and 연산함으로써 하나라도 false가 나올 시 flag가 false가 되도록 한다.
 */
