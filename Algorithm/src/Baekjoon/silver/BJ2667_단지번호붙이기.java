package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/2667
 * 실버1 단지번호붙이기
 */

public class BJ2667_단지번호붙이기 {

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int apart[];
	static int map[][];
	static boolean visit[][];
	static int N;
	static int num = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		apart = new int[N * N];
		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
				// System.out.print(map[i][j]);
			}
			// System.out.println();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					num++;
					dfs(i, j);
				}
			}
		}

		System.out.println(num);
		Arrays.sort(apart);

		for (int i = 0; i < N * N; i++) {
			if(apart[i] == 0)
				continue;
			
			System.out.println(apart[i]);
		}

	}

	static void dfs(int x, int y) {
		visit[x][y] = true;
		apart[num]++; // 단지에 해당되는 집 수 카운팅

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (map[nx][ny] == 1 && !visit[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}

}
