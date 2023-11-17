package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1937
 * 골드3 욕심쟁이 판다
 */

public class BJ1937_욕심쟁이판다 {

	static int N;
	static int[][] map;
	static int[][] move;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		move = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans = Math.max(ans, dfs(i, j));
			}
		}

		System.out.println(ans);

	}

	private static int dfs(int x, int y) {
		if (move[x][y] != 0)
			return move[x][y];

		move[x][y] = 1;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;

			if (map[x][y] < map[nx][ny]) {
				move[x][y] = Math.max(move[x][y], dfs(nx, ny) + 1);
			}
		}

		return move[x][y];
	}

}
