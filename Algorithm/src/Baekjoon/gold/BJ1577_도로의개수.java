package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1577
 * 골드5 도로의 개수
 */

public class BJ1577_도로의개수 {

	static int N, M, K, a, b, c, d;
	static long[][] map;
	static boolean[][] row, column; // 공사중인도로

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new long[N + 1][M + 1];
		map[0][0] = 1;
		K = Integer.parseInt(br.readLine());

		row = new boolean[N + 1][M + 1];
		column = new boolean[N + 1][M + 1];

		// 공사중인 도로 확인
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			// 공사중인 도로가 가로인지 세로인지
			if (a == c) {
				column[a][Math.min(b, d)] = true;
			} else {
				row[Math.min(a, c)][b] = true;
			}
		}

		// 가로가 0인 부분 초기화
		for (int i = 1; i <= M; i++) {
			if (column[0][i - 1])
				break;
			map[0][i] = 1;
		}

		// 세로가 0인 부분 초기화
		for (int i = 1; i <= N; i++) {
			if (row[i - 1][0])
				break;
			map[i][0] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = map[i-1][j] + map[i][j-1];
				
				// 공사중인 부분일 경우 다시 빼준다
				if(column[i][j-1]) map[i][j] -= map[i][j-1];
				
				if(row[i-1][j]) map[i][j] -= map[i-1][j];
				
			}
		}
		
		for (int i = 0; i <= N; i++) {
			System.out.println();
			for (int j = 0; j <= M; j++) {
				System.out.printf("%4d", map[i][j]);
			}
		}
		System.out.println(Arrays.deepToString(map));
		
		System.out.println(map[N][M]);

	}

}
