package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1890
 * 실버1 점프
 */

// BFS 푼 경우 메모리 초과
public class BJ1890_점프_fail {

	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };

	static class Node {
		int x;
		int y;
		int value;
		int cnt;

		public Node(int x, int y, int value, int cnt) {
			this.x = x;
			this.y = y;
			this.value = value;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][N];
		int dp[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, map[0][0], 0));

		while (!queue.isEmpty()) {
			Node n = queue.poll();
//			System.out.println(n.x + " " + n.y + " " + n.value);

			if (n.value == 0) {
				System.out.println(n.cnt);
				break;
			}

			for (int d = 0; d < 2; d++) {
				int nx = n.x + dx[d] * n.value;
				int ny = n.y + dy[d] * n.value;

				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}

				queue.add(new Node(nx, ny, map[nx][ny], n.cnt + 1));
			}

		}

//		System.out.println(Arrays.deepToString(map));
	}

}
