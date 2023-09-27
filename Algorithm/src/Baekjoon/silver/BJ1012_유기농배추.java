package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1012_유기농배추 {

	static int M, N, K;
	static int[][] map;
	static boolean[][] visit;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visit = new boolean[N][M];

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());

				map[Y][X] = 1;
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visit[i][j] && map[i][j] != 0) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			
			System.out.println(cnt);

		}
	}

	private static void dfs(int x, int y) {
		visit[x][y] = true;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;

			if (!visit[nx][ny] && map[nx][ny] != 0) {
				visit[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}

}
