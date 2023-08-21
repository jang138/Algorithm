package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/2667
 * 실버1 단지번호붙이기
 */

public class BJ2667_단지번호붙이기2 {

	static int N, num;
	static int map[][];
	static boolean visit[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int apart[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		apart = new int[N * N + 1];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					num++;
					dfs(i, j);
				}
			}
		}
		
		System.out.println(num);
		Arrays.sort(apart);
		
		for (int i = 0; i < apart.length; i++) {
			if(apart[i]==0)
				continue;
			System.out.println(apart[i]);
		}
	}

	private static void dfs(int x, int y) {
		visit[x][y] = true;
		apart[num]++;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny] || map[nx][ny] != 1) {
				continue;
			}

			dfs(nx, ny);
		}
	}

}
