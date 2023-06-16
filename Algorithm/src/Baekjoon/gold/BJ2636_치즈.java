package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2636_치즈 {

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
	}

	static int N, M, hour, cheese;
	static int map[][];
	static boolean visitAir[][];
	static boolean visitCheese[][];

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static Queue<Node> queueAir = new LinkedList<>();
	static Queue<Node> queueBorder = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visitAir = new boolean[N][M];
		visitCheese = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visitAir[0][0] = true;
		queueAir.add(new Node(0, 0));

		while (true) {

			/*
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					boolean va = visitCheese[i][j];
					int a = va ? 1 : 0;
					System.out.print(a + " ");
				}
				System.out.println();
			}
			
			System.out.println("=============");
			*/
			
			// map의 값이 0인 부분(공기)을 돌아다니며 치즈의 가장자리를 탐색하고 가장자리 큐에 담아준다.
			bfsAir();

			// 가장자리에 해당하는 치즈가 없다 => 모두 녹았다 => break
			if (queueBorder.isEmpty()) {
				break;
			}

			
			// 치즈의 가장자리에 해당하는 부분을 공기로 바꿔주고 공기 큐에 담아준다.
			bfsBorder();

			hour++;
		}

		System.out.println(hour);
		System.out.println(cheese);
	}

	private static void bfsAir() {
		while (!queueAir.isEmpty()) {
			Node node = queueAir.poll();

			// node 기준 사방 탐색
			for (int d = 0; d < 4; d++) {
				int nx = node.x + dx[d];
				int ny = node.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visitAir[nx][ny])
					continue;

				// 공기를 만남
				if (map[nx][ny] == 0) {
					visitAir[nx][ny] = true;
					queueAir.add(new Node(nx, ny));
					continue;
				}

				// 치즈를 만남(가장자리)
				if (map[nx][ny] == 1) {
					// 다른 공기에 의해 치즈가 이미 저장된 경우
					if (visitCheese[nx][ny])
						continue;
					visitCheese[nx][ny] = true;
					queueBorder.add(new Node(nx, ny));
				}
			}
		}
	}

	// 경계면 치즈는 공기로 바뀐다.
	// 매번 남아 있는 치즈를 새롭게 계산
	private static void bfsBorder() {
		cheese = 0;

		// 가장자리 치즈들을 모두 공기로 바꿔주고 방문 체크 해준다
		while (!queueBorder.isEmpty()) {
			Node node = queueBorder.poll();
			visitAir[node.x][node.y] = true;
			queueAir.add(node);
			cheese++;
		}
	}
}
