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

public class BJ2178_미로탐색하기 {

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
				// System.out.print(map[i][j]);
			}
			// System.out.println();
		}

		bfs(0, 0);
		System.out.println(map[N - 1][M - 1]);
	}

	static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });

		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			visit[i][j] = true;

			for (int d = 0; d < 4; d++) {
				int x = now[0] + dx[d];
				int y = now[1] + dy[d];

				if (x < 0 || y < 0 || x >= N || y >= M) {
					continue;
				}

				if (visit[x][y] || map[x][y] == 0) {
					continue;
				}

				queue.add(new int[] { x, y });
				map[x][y] = map[now[0]][now[1]] + 1;
				visit[x][y] = true;
			}
		}

	}

}