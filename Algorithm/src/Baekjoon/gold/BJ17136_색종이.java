package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/17136
 * 골드2 색종이 붙이기
 */

public class BJ17136_색종이 {

	static int ans = Integer.MAX_VALUE;
	static int[] paper = new int[6];
	static int[][] map = new int[10][10];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(paper, 5);

		dfs(0, 0);

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

	static void dfs(int idx, int cnt) {
		// 100개 모두 탐색한 경우 return
		if (idx == 100) {
			ans = Math.min(ans, cnt);
			return;
		}

		// 좌표
		int x = idx / 10;
		int y = idx % 10;

		if (map[x][y] == 1) {
			// 제일 큰 색종이부터
			for (int i = 5; i > 0; i--) {
				// 붙일 색종이가 남아있고
				if (paper[i] > 0) {
					// 붙일 수 있는 경우 체크
					if (check(x, y, i)) {
						
						change(x, y, i, 0);
						paper[i]--;
						
						dfs(idx + 1, cnt + 1);
						
						change(x, y, i, 1);
						paper[i]++;
					}
				}
			}
		} else {
			dfs(idx + 1, cnt);
		}
	}

	static boolean check(int x, int y, int size) {
		// 색종이가 크기를 넘어간 경우
		if (x + size > 10 || y + size > 10)
			return false;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				// 색종이로 덮은 구간에 0이 있을 때
				if (map[x + i][y + j] != 1)
					return false;
			}
		}
		
		return true;
	}

	// 일정 구간을 0 또는 1로 바꾸는 함수
	static void change(int x, int y, int size, int state) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[x + i][y + j] = state;
			}
		}
	}

}
