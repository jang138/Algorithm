package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/15685
 * 골드4 드래곤 커브
 */

public class BJ15685_드래곤커브 {
	static boolean[][] visited = new boolean[101][101];
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	
	static class node {
		int x;
		int y;

		node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int ans = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			dragon(x, y, d, g);
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(visited[i][j] && visited[i+1][j] && visited[i][j+1] && visited[i+1][j+1]) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);

	}

	static void dragon(int x, int y, int d, int g) {
		node end = new node(x, y);
		ArrayList<Integer> dir = new ArrayList<>();
		dir.add(d);
		visited[x][y] = true;

		for (int i = 0; i < g+1; i++) {
			for (int j = dir.size() / 2; j < dir.size(); j++) {
				end.x = end.x + dx[dir.get(j)];
				end.y = end.y + dy[dir.get(j)];
				visited[end.x][end.y] = true;
			}

			ArrayList<Integer> temp = new ArrayList<>();
			for (int j = dir.size() - 1; j > -1; j--) {
				temp.add((dir.get(j) + 1) % 4);
			}
			
			for (int j : temp) {
				dir.add(j);
			}
		}
	}

}
