package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2567
 * 실버4 색종이 2
 */

public class BJ2567_색종이2 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		boolean[][] paper = new boolean[101][101];
		int border = 0;

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					paper[i][j] = true;
				}
			}
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j]) {
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];

						if (!paper[nx][ny] || nx < 0 || nx > 100 || ny < 0 || ny > 100)
							border++;
					}
				}

			}
		}

		System.out.println(border);

	}

}
