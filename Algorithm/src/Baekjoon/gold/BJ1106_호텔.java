package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1106
 * 골드5 호텔
 */

public class BJ1106_호텔 {

	static int C, N;
	static int[] values;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		values = new int[C + 101];
		Arrays.fill(values, Integer.MAX_VALUE);
		values[0] = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int reward = Integer.parseInt(st.nextToken());
			
			for (int j = reward; j < C + 101; j++) {
				int prev = values[j - reward];
				if (prev != Integer.MAX_VALUE)
					values[j] = Math.min(values[j], cost + prev);
			}
		}
		
		int result = Integer.MAX_VALUE;
		for (int i = C; i < C + 101; i++) {
			result = Math.min(result, values[i]);
		}
		System.out.println(result);
	}
}
