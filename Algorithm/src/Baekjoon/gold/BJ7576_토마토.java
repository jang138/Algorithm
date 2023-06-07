package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/7576
 * 골드5 토마토
 */

public class BJ7576_토마토 {

	static int M, N, max;
	static int box[][];
	static Queue<int[]> queue = new LinkedList<>();
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				box[i][j] = a;

				if (a == 1) {
					queue.offer(new int[] { i, j, 0 }); // row, column, day
				}
			}
		}

		bfs();
		
		Flag:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j] == 0) {
					max = -1;
					break Flag;
				}
			}
		}

		System.out.println(max);
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			int[] now = queue.poll();

//			System.out.println(Arrays.toString(now));

			max = Math.max(max, now[2]);

			for (int d = 0; d < 4; d++) {
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}

				if (box[nx][ny] == 0) {
					queue.offer(new int[] { nx, ny, now[2] + 1 });
					box[nx][ny] = 1;
				}

			}
		}
	}

}
