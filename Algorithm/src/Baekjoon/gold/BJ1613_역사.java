package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1613
 * 골드3 역사
 */

public class BJ1613_역사 {
	static final int INF = 1000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 사건의 수 (노드 개수)
		int K = Integer.parseInt(st.nextToken()); // 관계의 수 (간선 개수)

		int[][] arr = new int[N + 1][N + 1];
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], INF);
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr[x][y] = 1;
		}

		// 플로이드 워셜 알고리즘
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		
		print(arr);

		int S = Integer.parseInt(br.readLine());

		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 뒤의 사건이 먼저 일어났다면
			if (arr[x][y] > arr[y][x]) 
				System.out.println(1);

			// 앞의 사건이 먼저 일어났다면
			else if (arr[x][y] < arr[y][x]) 
				System.out.println(-1);

			// 몰루
			else 
				System.out.println(0);
		}
	}
	
	static void print(int[][] arr) {
		for(int[] i : arr) {
            for(int j : i) {
                System.out.printf("%15d", j);
            }
            System.out.println();
        }
	}

}
