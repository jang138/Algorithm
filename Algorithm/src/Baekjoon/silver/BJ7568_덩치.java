package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/7568
 * 실버5 덩치
 */

public class BJ7568_덩치 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int array[][] = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.deepToString(array));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int rank = 1;

			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				
				if(array[i][0] < array[j][0] && array[i][1] < array[j][1]) {
					rank++;
				}
			}
			
			sb.append(rank).append(" ");
		}
		
		System.out.println(sb);
	}

}
