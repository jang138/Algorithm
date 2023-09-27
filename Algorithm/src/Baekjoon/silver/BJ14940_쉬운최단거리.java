package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/14940
 * 실버1 쉬운 최단거리
 */

public class BJ14940_쉬운최단거리 {

	static int N, M, targetX, targetY;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int in = Integer.parseInt(st.nextToken());
				map[i][j] = in;
				if (in == 2) {
					targetX = i;
					targetY = j;
				}

				if (in == 0) {
					visit[i][j] = true;
				}

			}
		}

		bfs();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visit[i][j])
					sb.append(map[i][j]).append(" ");
				else
					sb.append(-1).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { targetX, targetY });
		visit[targetX][targetY] = true;
		map[targetX][targetY] = 0;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (visit[nx][ny])
					continue;

				queue.add(new int[] { nx, ny });
				visit[nx][ny] = true;
				map[nx][ny] = map[now[0]][now[1]] + 1;
			}
		}
	}

}
