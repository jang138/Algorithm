package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2096
 * 골드5 내려가기
 */

public class BJ2096_내려가기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] array = new int[N + 1][3];
		int[][] maxDP = new int[N + 1][3];
		int[][] minDP = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			maxDP[i][0] = array[i][0] + Math.max(maxDP[i - 1][0], maxDP[i - 1][1]);
			maxDP[i][1] = array[i][1] + Math.max(Math.max(maxDP[i - 1][0], maxDP[i - 1][1]), maxDP[i - 1][2]);
			maxDP[i][2] = array[i][2] + Math.max(maxDP[i - 1][1], maxDP[i - 1][2]);

			minDP[i][0] = array[i][0] + Math.min(minDP[i - 1][0], minDP[i - 1][1]);
			minDP[i][1] = array[i][1] + Math.min(Math.min(minDP[i - 1][0], minDP[i - 1][1]), minDP[i - 1][2]);
			minDP[i][2] = array[i][2] + Math.min(minDP[i - 1][1], minDP[i - 1][2]);
		}
/*
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf("%5d", maxDP[i][j]);
			}
			System.out.println();
		}
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf("%5d", minDP[i][j]);
			}
			System.out.println();
		}
*/	
		int max = Math.max(Math.max(maxDP[N][0], maxDP[N][1]), maxDP[N][2]);
		int min = Math.min(Math.min(minDP[N][0], minDP[N][1]), minDP[N][2]);
		
		System.out.println(max + " " + min);

	}

}
