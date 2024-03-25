package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main3 {

	static int V;
	static ArrayList<ArrayList<Edge>> tree = new ArrayList<>();
	static boolean[] visited;
	static int[] distance;

	static class Edge {
		int node;
		int value;

		public Edge(int node, int value) {
			this.node = node;
			this.value = value;
		}

		public String toString() {
			return node + " " + value;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(br.readLine());
		visited = new boolean[V + 1];
		distance = new int[V + 1];

		for (int i = 0; i <= V; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 0; i < V; i++) {
			String[] str = br.readLine().split(" ");
			int v = Integer.parseInt(str[0]);

			for (int j = 1; j < str.length; j += 2) {
				int n = Integer.parseInt(str[j]);
				if (n == -1)
					break;

				int val = Integer.parseInt(str[j + 1]);

				tree.get(v).add(new Edge(n, val));
			}
		}

		// 가장 긴 지름을 만드는 두 노드를 node1 node2라고 한다면, 임의의 노드에서 가장 먼 노드는 node1이나 node2이다.
		// 임의의 노드에서 가장 먼 node1을 구하고, node1을 기준으로 가장 먼 node2를 구하면 node1 node2 둘다 구할 수 있다.
		bfs(1);

		int max = 1;
		for (int i = 2; i <= V; i++) {
			if (distance[max] < distance[i]) {
				max = i;
			}
		}

		visited = new boolean[V + 1];
		distance = new int[V + 1];
		bfs(max);

		Arrays.sort(distance);
		System.out.println(distance[V]);

	}

	private static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		visited[num] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (Edge edge : tree.get(node)) {
				int n = edge.node;
				int v = edge.value;

				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
					distance[n] = distance[node] + v;
				}
			}
		}

	}

}
