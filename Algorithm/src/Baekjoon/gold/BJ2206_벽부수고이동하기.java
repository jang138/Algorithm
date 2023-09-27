package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2206
 * 골드3 벽 부수고 이동하기
 */

public class BJ2206_벽부수고이동하기 {

	static int N, M, result;
	static int[][] map, visit;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		visit = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				int input = str.charAt(j - 1) - '0';
				map[i][j] = input;
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
				
		result = getRoute(1, 1);
		System.out.println(result);

	}

	private static int getRoute(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y, 1, 0));
		visit[x][y] = 0;

		while (!queue.isEmpty()) {
			Point point = queue.poll();

			if (point.x == N && point.y == M) {
				return point.count;
			}

			for (int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				

				if (nx > 0 && ny > 0 && nx < N + 1 && ny < M + 1) {
					if (visit[nx][ny] > point.crash) {
						if (map[nx][ny] == 0) {
							queue.offer(new Point(nx, ny, point.count + 1, point.crash));
							visit[nx][ny] = point.crash;
						} else {
							if (point.crash == 0) {
								queue.offer(new Point(nx, ny, point.count + 1, point.crash + 1));
								visit[nx][ny] = point.crash + 1;
							}
						}
					}
				}
			}
		}
		
		return -1;
	}

	static class Point {
		int x, y, count, crash;

		public Point(int x, int y, int count, int crash) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.crash = crash;
		}
	}
}
