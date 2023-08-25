package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/4963
 * 실버2 섬의 개수
 */

public class BJ4963_섬의개수 {

	static int N, M, count;
	static int map[][];
	static boolean visit[][];

	static int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int dy[] = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			count = 0;

			if (N == 0 && M == 0)
				break;

			map = new int[N][M];
			visit = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visit[i][j] && map[i][j] == 1) {
						count++;
						dfs(i, j);
					}
				}
			}

			System.out.println(count);

		}

	}

	private static void dfs(int x, int y) {
		visit[x][y] = true;

		for (int d = 0; d < 8; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny] || map[nx][ny] == 0)
				continue;

			dfs(nx, ny);

		}
	}

}
