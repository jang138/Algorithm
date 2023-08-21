package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2178
 * 실버1 미로 탐색
 */

public class BJ2178_미로탐색하기2 {

	static class Node {
		int x;
		int y;
		int cnt;

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "x=" + x + ", y=" + y + ", cnt=" + cnt;
		}

	}

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int map[][];
	static boolean visit[][];
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		bfs(0, 0, 1);

	}

	private static void bfs(int x, int y, int cnt) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y, cnt));
		visit[x][y] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();
			if (now.x == N - 1 && now.y == M - 1) {
				System.out.println(now.cnt);
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny] || map[nx][ny] == 0)
					continue;

				queue.add(new Node(nx, ny, now.cnt + 1));
				visit[nx][ny] = true;
			}
		}

	}

}