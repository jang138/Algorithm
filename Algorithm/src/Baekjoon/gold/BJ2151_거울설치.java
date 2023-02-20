package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2151
 * 골드3 거울 설치
 */

/*
5
***#*
*.!.*
*!.!*
*.!.*
*#***

*/

public class BJ2151_거울설치 {

	static int N, ans;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static char[][] map;
	static boolean[][][] visit; // 방문할 때 빛이 들어오는 방향까지 3차원 배열

	static class Node {
		int x, y, mirror, dir;

		public Node(int x, int y, int mirror, int dir) {
			this.x = x;
			this.y = y;
			this.mirror = mirror;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		Node start = null;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '#') {
					start = new Node(i, j, 0, 0);
					System.out.println(i + " " + j);
				}
			}
		}

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
			return o1.mirror - o2.mirror;
		});

		visit = new boolean[4][N][N];
		for (int i = 0; i < 4; i++) {
			pq.offer(new Node(start.x, start.y, 0, i));
			visit[i][start.x][start.y] = true;
		}

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			
			for (int i = -1; i <= 1; i++) {
				
			}
		}
	}

}
