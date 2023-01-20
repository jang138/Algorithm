package Baekjoon.gold;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/16929
 * 골드4 Two Dots
 */

public class BJ16929_TwoDots {
	static int N, M;
	static char[][] arr;
	static boolean check[][];
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		check = new boolean[N][M];
		String ans = "No";
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				boolean cycle = false;
				// 방문하지 않은 경우 탐색
				if (!check[i][j]) {
					cycle = dfs(-1, -1, i, j, arr[i][j]);
				}
				// 사이클 발견
				if (cycle) {
					ans = "Yes";
					break;
				}
			}
		}
		System.out.println(ans);
	}

	static boolean dfs(int prex, int prey, int x, int y, char dot) {
		if (check[x][y]) {
			return true;
		}
		check[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// 경계선
			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				// 이전 위치인지  && 같은 점인지
				if ((!(nx == prex && ny == prey)) && arr[nx][ny] == dot) {
					if (dfs(x, y, nx, ny, dot)) {
						return true; // 전에 방문한 노드라면 싸이클 완성
					}
				}
			}
		}
		return false;
	}

}
