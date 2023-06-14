package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2573
 * 골드4 빙산
 */

public class BJ2573_빙산 {

	static int N, M;
	static int map[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0;

		while (true) {
			int count = countIce();

			if (count >= 2) { // 빙산이 2개로 갈라짐
				break;
			} else if (count == 0) { // 빙산이 사라질 때까지 갈라지지 않음
				year = 0;
				break;
			}

			bfs();
			year++;
		}

		
		System.out.println(year);
	}

	// 빙산 개수 체크
	private static int countIce() {
		boolean visit[][] = new boolean[N][M];

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && map[i][j] > 0) {
					dfs(i, j, visit);
					cnt++;
				}
			}
		}

		return cnt;
	}

	private static void dfs(int i, int j, boolean visit[][]) {
		visit[i][j] = true;

		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (!visit[nx][ny] && map[nx][ny] > 0) {
					dfs(nx, ny, visit);
				}
			}
		}

	}

	// 빙산이 녹음
	private static void bfs() {
		Queue<IceBurg> queue = new LinkedList<>();
		boolean visit[][] = new boolean[N][M];

		// 빙산인 부분을 큐에 저장, 빙산 주변 바다를 체크할 때 제외할 수 있도록 visit도 true로 바꿈
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) {
					queue.add(new IceBurg(i, j));
					visit[i][j] = true;
				}
			}
		}

		while (!queue.isEmpty()) {
			IceBurg ice = queue.poll();

			int zero = 0;

			// 주변에 바다가 얼마나 있는지 사방 탐색
			for (int d = 0; d < 4; d++) {
				int nx = ice.x + dx[d];
				int ny = ice.y + dy[d];

				// 경계선 탐색 and 이미 체크한 빙산이 아닌 경우
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if(!visit[nx][ny] && map[nx][ny] == 0) {
						zero++;
					}
				}
			}
			
			if(map[ice.x][ice.y] >= zero) {
				map[ice.x][ice.y] = map[ice.x][ice.y] - zero;
			} else {
				map[ice.x][ice.y] = 0;
			}
		}
	}

	static class IceBurg {
		int x, y;

		public IceBurg(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
