package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2636_치즈 {

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static int cheese[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheese = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int hour = 0;

		while (true) {
			if (done()) {
				break;
			}

			melt();
		}

	}

	private static boolean done() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cheese[i][j] == 1) {
					return false;
				}
			}
		}

		return true;
	}

	private static void melt() {
		boolean edge[][] = new boolean[N][M];

		bfs(0, 0, edge);
	}

	private static void bfs(int x, int y, boolean[][] edge) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = node.x + dx[d];
				int ny = node.y + dy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if(cheese[nx][ny] == 0)
				}
			}
		}
	}
}
