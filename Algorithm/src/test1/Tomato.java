package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {

	static int M, N, max = Integer.MIN_VALUE;
	static int[][] box;
	static Queue<TMT> queue = new LinkedList<>();
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class TMT {
		int x;
		int y;
		int d;

		public TMT(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

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
					queue.add(new TMT(i, j, 0));
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

	private static void bfs() {
		while (!queue.isEmpty()) {
			TMT tmt = queue.poll();
			max = Math.max(max, tmt.d);

			for (int d = 0; d < 4; d++) {
				int nx = tmt.x + dx[d];
				int ny = tmt.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || box[nx][ny] == -1)
					continue;

				if (box[nx][ny] == 0) {
					queue.add(new TMT(nx, ny, tmt.d + 1));
					box[nx][ny] = 1;
				}

			}
		}
	}
}
