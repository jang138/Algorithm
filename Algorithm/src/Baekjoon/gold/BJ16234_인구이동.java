package Baekjoon.gold;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/16234
 * 골드5 인구 이동
 * 참고 링크
 * https://moonsbeen.tistory.com/259
 */

public class BJ16234_인구이동 {

	static int n, l, r;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static ArrayList<Node> list; // 인구 이동이 필요한 노드 리스트

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		l = scan.nextInt();
		r = scan.nextInt();

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = scan.nextInt();
			}
		}

		System.out.println(move());
	}

	// 더 이상 인구이동이 일어나지 않을 때까지
	public static int move() {
		int result = 0;
		
		while (true) {
			boolean isMove = false;
			visit = new boolean[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j]) {
						int sum = bfs(i, j); // bfs탐색으로 열릴 수 있는 국경선 확인 하며 인구 이동할 총 인구수 반환
						if (list.size() > 1) {
							changePopulation(sum); // 열린 국경선 내의 노드들 인구 변경
							isMove = true;
						}
					}
				}
			}
			if (!isMove) {
				return result;				
			}
			
			result++;
		}
	}

	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		list = new ArrayList<>();

		q.offer(new Node(x, y));
		list.add(new Node(x, y));
		visit[x][y] = true;

		int sum = map[x][y];
		while (!q.isEmpty()) {
			Node current = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny]) {
					int diff = Math.abs(map[current.x][current.y] - map[nx][ny]);
//					System.out.println(diff);
					if (l <= diff && diff <= r) {
						q.offer(new Node(nx, ny));
						list.add(new Node(nx, ny));
						sum += map[nx][ny];
						visit[nx][ny] = true;
					}
				}
			}
		}
		return sum;
	}

	public static void changePopulation(int sum) {
		int avg = sum / list.size();
		for (Node n : list) {
			map[n.x][n.y] = avg;
		}
	}

	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
