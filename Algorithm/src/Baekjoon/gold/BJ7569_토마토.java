package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/7569
 * 골드5 토마토
 */

public class BJ7569_토마토 {

	static int M, N, H, max;
	static int box[][][];
	static Queue<int[]> queue = new LinkedList<>();
	static int dx[] = { 1, 0, 0, -1, 0, 0 };
	static int dy[] = { 0, 1, 0, 0, -1, 0 };
	static int dz[] = { 0, 0, 1, 0, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[N][M][H];

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int a = Integer.parseInt(st.nextToken());
//					System.out.println(i + " " + j + " " + k);
					box[i][j][k] = a;

					if (a == 1) {
						queue.offer(new int[] { i, j, k, 0 }); // row, column, high, day
					}
				}

//				System.out.println();
			}
		}

		bfs();

		
		Flag:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < H; k++) {
					
//					System.out.print(i + " " + j + " " + k + " " + box[i][j][k]);
//					System.out.println();
					
					if(box[i][j][k] == 0) {
						max = -1;
						break Flag;
					}
					
				}
				
			}
		}
		
		

		System.out.println(max);
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			//System.out.println(Arrays.toString(now));

			max = Math.max(max, now[3]);

			for (int d = 0; d < 6; d++) {
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];
				int nz = now[2] + dz[d];

				//System.out.println(nx + " " + ny + " " + nz);

				if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) {
					continue;
				}

				if (box[nx][ny][nz] == 0) {
					queue.offer(new int[] { nx, ny, nz, now[3] + 1 });
					box[nx][ny][nz] = 1;
				}

			}
		}
	}

}
