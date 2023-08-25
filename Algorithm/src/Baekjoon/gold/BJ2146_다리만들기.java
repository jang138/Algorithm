package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2146
 * 골드3 다리 만들기
 */

public class BJ2146_다리만들기 {

	static int N, num = 1, min = Integer.MAX_VALUE, now;
	static int[][] map;
	static int[][] distArr;
	static boolean[][] edge;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		edge = new boolean[N][N];
		distArr = new int[N][N]; // 섬에서부터 거리를 입력받는 배열
									// 이 배열의 인접한 부분의 합은 섬과 섬 사이의 거리를 뜻한다
									// 이때 이 합의 최솟값을 찾는다 (단, 같은 섬에서 측정된 거리끼리의 합은 무시한다)

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int in = Integer.parseInt(st.nextToken());
				map[i][j] = in;

				// 땅인 부분은 0으로 바다는 -1로 초기화 (-1 부분은 나중에 섬에서 얼마나 떨어져 있는지 입력한다)
				if (in == 0) {
					distArr[i][j] = -1;
				} else {
					distArr[i][j] = 0;
				}
			}
		}

		// 섬 별로 숫자 매기기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					num++;
					dfs(i, j);
				}
			}
		}

		// 가장자리 부분만 큐에 넣고 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (edge[i][j]) {
					queue.add(new int[] { i, j, 0 });
				}
			}
		}

		bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
						continue;
					}

					// 측정된 두 거리가 다른 섬에서 이루어 진 것이지 확인하기 위해 map의 번호를 체크한다
					if (map[i][j] != map[nx][ny]) {
						min = Math.min(min, distArr[nx][ny] + distArr[i][j]);
					}

				}
			}
		}

		System.out.println(min);

	}

	private static void dfs(int x, int y) {
		// 섬에 숫자를 매긴다
		map[x][y] = num;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
				continue;
			}

			// 가장자리인 경우 체크
			if (map[nx][ny] == 0) {
				edge[x][y] = true;
			}

			if (map[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}

	}

	private static void bfs() {

		while (!queue.isEmpty()) {
			int[] target = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = target[0] + dx[d];
				int ny = target[1] + dy[d];

				// 경계선 밖 or 섬인 경우 continue
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || distArr[nx][ny] == 0) {
					continue;
				}

				// 거리가 매겨지지 않은 경우
				if (distArr[nx][ny] == -1) {
					// 다음 거리는 기존 거리의 +1
					distArr[nx][ny] = target[2] + 1;

					// 거리가 어떤 섬 기준으로 측정되었는지 기억하기 위해 섬에 해당되는 번호를 매김
					map[nx][ny] = map[target[0]][target[1]];

					queue.add(new int[] { nx, ny, target[2] + 1 });
				}

			}

		}
	}

}
