package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/7576
 * 골드5 토마토
 */

public class BJ7576_토마토2 {

	static int N, M, max;
	static int box[][];

	static Queue<Tomato> queue = new LinkedList<>();

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					queue.add(new Tomato(i, j, 0));
				}
			}
		}

		bfs();

		Flag: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					max = -1;
					break Flag;
				}
			}
		}

		System.out.println(max);

	}

	static class Tomato {
		int x;
		int y;
		int day;

		public Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}

	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			Tomato target = queue.poll();
			max = Math.max(max, target.day);

			for (int d = 0; d < 4; d++) {
				int nx = target.x + dx[d];
				int ny = target.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}

				if (box[nx][ny] != 0) {
					continue;
				}

				queue.add(new Tomato(nx, ny, target.day + 1));
				box[nx][ny] = 1;
			}
		}
	}

}
